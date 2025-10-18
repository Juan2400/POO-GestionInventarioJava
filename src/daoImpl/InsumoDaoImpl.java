package daoImpl;

import dao.IDaoExtendido;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Insumo;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class InsumoDaoImpl implements IDaoExtendido<Insumo> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public InsumoDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public int obtenerId(String texto) {
        int id = -1;

        try {
            ps = conexion.conectar().prepareStatement("select IdInsumo from Insumo where NombreInsumo=?");
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
            ps = conexion.conectar().prepareStatement("select NombreInsumo from Insumo where IdInsumo=?");
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
    public boolean agregar(Insumo obj) {
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO Insumo (NombreInsumo,IdUnidadMedida,IdCategoria,IdProveedor)VALUES (?,?,?,?)");
            ps.setString(1, obj.getNombreInsumo());
            ps.setInt(2, obj.getIdUnidadMedida());
            ps.setInt(3, obj.getIdCategoria());
            ps.setInt(4, obj.getIdProveedor());
            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }
        return false;
    }

    @Override
    public boolean actualizar(Insumo obj) {
        try {
            ps = conexion.conectar().prepareStatement("UPDATE Insumo SET NombreInsumo = ?, IdUnidadMedida = ?, IdCategoria = ?, IdProveedor = ? WHERE IdInsumo = ?");
            ps.setString(1, obj.getNombreInsumo());
            ps.setInt(2, obj.getIdUnidadMedida());
            ps.setInt(3, obj.getIdCategoria());
            ps.setInt(4, obj.getIdProveedor());
            ps.setInt(5, obj.getIdInsumo());

            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }

        return false;
    }

    @Override
    public boolean eliminar(Insumo obj) {

        try {
            ps = conexion.conectar().prepareStatement("DELETE FROM Insumo WHERE IdInsumo=?");
            ps.setInt(1, obj.getIdInsumo());

            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }
        return false;

    }

    public List<Insumo> listar() {

        List<Insumo> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Insumo");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Insumo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
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
    public List<Insumo> listar(Insumo obj) {
        List<Insumo> lista = new ArrayList<>();

        boolean encontrado = false;

        try {

            if (obj.getIdInsumo() != 0) {
                ps = conexion.conectar().prepareStatement("select * from Insumo where IdInsumo=?");
                ps.setInt(1, obj.getIdInsumo());
            } else {
                ps = conexion.conectar().prepareStatement("select * from productos where nombreProducto like ?");
                ps.setString(1, "%" + obj.getNombreInsumo() + "%");
            }

            obj = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Insumo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
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
}//end InsumoDaoImpl
