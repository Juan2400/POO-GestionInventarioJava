package daoImpl;

import dao.IDaoExtendido;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Rol;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class RolDaoImpl implements IDaoExtendido<Rol>{

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public RolDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public int obtenerId(String texto) {
        int id = -1;

        try {
            ps = conexion.conectar().prepareStatement("select IdRol from Rol where NombreRol=?");
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
            ps = conexion.conectar().prepareStatement("select NombreRol from Rol where IdRol=?");
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
    public boolean agregar(Rol obj) {
        return false;
    }

    @Override
    public boolean actualizar(Rol obj) {
        return false;
    }

    @Override
    public boolean eliminar(Rol obj) {
        return false;
    }
    
    @Override
    public List<Rol> listar() {
        List<Rol> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Rol");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Rol(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
    public List<Rol> listar(Rol obj) {
        return null;
    }
}//end RolDaoImpl
