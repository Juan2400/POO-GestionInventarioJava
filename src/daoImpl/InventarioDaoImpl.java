package daoImpl;

import dao.IDaoGenerico;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Inventario;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class InventarioDaoImpl implements IDaoGenerico<Inventario> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public InventarioDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean agregar(Inventario obj) {
        return false;
    }

    @Override
    public boolean actualizar(Inventario obj) {
        return false;
    }

    @Override
    public boolean eliminar(Inventario obj) {
        return false;
    }

    @Override
    public List<Inventario> listar() {
        List<Inventario> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("SELECT Ivn.IdInventario, Ivn.Entrada, Ivn.Salida, Ivn.Stock,Ism.IdInsumo,Ism.NombreInsumo FROM Inventario Ivn JOIN Insumo Ism ON Ivn.IdInsumo = Ism.IdInsumo");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Inventario(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            lista = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return lista;
    }

    @Override
    public List<Inventario> listar(Inventario obj) {
        List<Inventario> lista = new ArrayList<>();

        try {
            if (obj.getIdInsumo() != 0) {
                ps = conexion.conectar().prepareStatement("SELECT Ivn.IdInventario, Ivn.Entrada, Ivn.Salida, Ivn.Stock,Ism.IdInsumo,Ism.NombreInsumo FROM Inventario Ivn JOIN Insumo Ism ON Ivn.IdInsumo = Ism.IdInsumo where Ism.IdInsumo = ?");
                ps.setInt(1, obj.getIdInsumo());
            } else {
                ps = conexion.conectar().prepareStatement("SELECT Ivn.IdInventario, Ivn.Entrada, Ivn.Salida, Ivn.Stock,Ism.IdInsumo,Ism.NombreInsumo FROM Inventario Ivn JOIN Insumo Ism ON Ivn.IdInsumo = Ism.IdInsumo WHERE Ism.NombreInsumo LIKE ?");
                ps.setString(1, "%" + obj.getNombreInsumo() + "%");
            }

            obj = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Inventario(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            lista = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }

        return lista;

    }
}//end InventarioDaoImpl
