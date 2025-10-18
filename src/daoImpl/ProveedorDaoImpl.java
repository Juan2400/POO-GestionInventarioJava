package daoImpl;

import dao.IDaoExtendido;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Proveedor;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class ProveedorDaoImpl implements IDaoExtendido<Proveedor> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProveedorDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public int obtenerId(String texto) {
        int id = -1;
        try {

            ps = conexion.conectar().prepareStatement("select IdProveedor from Proveedor where NombreProveedor=?");
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
            ps = conexion.conectar().prepareStatement("select NombreProveedor from Proveedor where IdProveedor=?");
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
    public boolean agregar(Proveedor obj) {
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO Proveedor (NombreProveedor,Direccion,Ruc,Telefono)VALUES (?,?,?,?)");
            ps.setString(1, obj.getNombreProveedor());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getRuc());
            ps.setString(4, obj.getTelefono());

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
    public boolean actualizar(Proveedor obj) {
        try {
            ps = conexion.conectar().prepareStatement("UPDATE Proveedor SET NombreProveedor=?,Direccion=?,Ruc=?,Telefono=? WHERE IdProveedor=?");
            ps.setString(1, obj.getNombreProveedor());
            ps.setString(2, obj.getDireccion());
            ps.setString(3, obj.getRuc());
            ps.setString(4, obj.getTelefono());
            ps.setInt(5, obj.getIdProveedor());

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
    public boolean eliminar(Proveedor obj) {

        try {
            ps = conexion.conectar().prepareStatement("DELETE FROM Proveedor WHERE IdProveedor=?");
            ps.setInt(1, obj.getIdProveedor());

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
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();

        try {
            ps = conexion.conectar().prepareStatement("select * from proveedor");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    public List<Proveedor> listar(Proveedor obj) {
        List<Proveedor> lista = new ArrayList<>();
        boolean encontrado = false;

        try {

            if (obj.getIdProveedor()!= 0) {
                ps = conexion.conectar().prepareStatement("select * from Proveedor where IdProveedor=?");
                ps.setInt(1, obj.getIdProveedor());
            } else {
                ps = conexion.conectar().prepareStatement("select * from Proveedor where NombreProveedor like ?");
                ps.setString(1, "%" + obj.getNombreProveedor() + "%");
            }
            obj = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
}//end ProveedorDaoImpl
