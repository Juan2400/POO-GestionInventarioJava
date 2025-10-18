package daoImpl;

import dao.IDaoGenerico;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.SalidaInsumo;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class SalidaInsumoDaoImpl implements IDaoGenerico<SalidaInsumo> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public SalidaInsumoDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean agregar(SalidaInsumo obj) {
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO SalidaInsumo (FechaSalida,Cantidad,IdUsuario,IdInsumo)VALUES (?,?,?,?)");
            ps.setTimestamp(1, obj.getFechaSalida());
            ps.setInt(2, obj.getCantidad());
            ps.setInt(3, obj.getIdUsuario());
            ps.setInt(4, obj.getIdInsumo());
            
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
    public boolean actualizar(SalidaInsumo obj) {
       
        return false;
    }

    @Override
    public boolean eliminar(SalidaInsumo obj) {
        
        return false;
    }
    
    @Override
    public List<SalidaInsumo> listar() {
        List<SalidaInsumo> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from SalidaInsumo");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new SalidaInsumo(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4),rs.getInt(5)));
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
    public List<SalidaInsumo> listar(SalidaInsumo obj) {
        return null;
    }
}//end SalidaInsumoDaoImpl
