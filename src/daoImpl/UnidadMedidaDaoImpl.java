package daoImpl;

import dao.IDaoExtendido;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.UnidadMedida;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class UnidadMedidaDaoImpl implements IDaoExtendido<UnidadMedida> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public UnidadMedidaDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public int obtenerId(String texto) {
        int id = -1;

        try {
            ps = conexion.conectar().prepareStatement("select IdUnidadMedida from UnidadMedida where NombreUnidadMedida=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return id;
    }

    @Override
    public String obtenerNombre(int id) {
        String nombre = null;

        try {
            ps = conexion.conectar().prepareStatement("select NombreUnidadMedida from UnidadMedida where IdUnidadMedida=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }

        return nombre;
    }

    @Override
    public boolean agregar(UnidadMedida obj) {
        return false;
    }

    @Override
    public boolean actualizar(UnidadMedida obj) {
        return false;
    }

    @Override
    public boolean eliminar(UnidadMedida obj) {
        return false;
    }

    @Override
    public List<UnidadMedida> listar() {
        List<UnidadMedida> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from UnidadMedida");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new UnidadMedida(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return lista;
    }

    @Override
    public List<UnidadMedida> listar(UnidadMedida obj) {
        return null;
    }
}//end UnidadMedidaDaoImpl
