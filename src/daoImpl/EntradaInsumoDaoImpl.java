package daoImpl;

import dao.IDaoGenerico;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.EntradaInsumo;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:46:51 p.�m.
 */
public class EntradaInsumoDaoImpl implements IDaoGenerico<EntradaInsumo> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public EntradaInsumoDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean agregar(EntradaInsumo obj) {
        try {
            ps = conexion.conectar().prepareStatement("INSERT INTO EntradaInsumo (NumeroFactura,FechaEntrada,Cantidad,Importe,IdUsuario,IdInsumo)VALUES (?,?,?,?,?,?)");
            ps.setString(1, obj.getNumeroFactura());
            ps.setTimestamp(2, obj.getFechaEntrada());
            ps.setInt(3, obj.getCantidad());
            ps.setFloat(4, obj.getImporte());
            ps.setInt(5, obj.getIdUsuario());
            ps.setInt(6, obj.getIdInsumo());
            
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
    public boolean actualizar(EntradaInsumo obj) {
        
//        try {
//            ps = conexion.conectar().prepareStatement("UPDATE EntradaInsumo SET NumeroFactura=?,FechaEntrada= ?,Cantidad=?,Importe=?,IdUsuario=?,IdInsumo=? WHERE IdEntrada=?");
//            ps.setString(1, obj.getNumeroFactura());
//            ps.setTimestamp(2, obj.getFechaEntrada());
//            ps.setInt(3, obj.getCantidad());
//            ps.setFloat(4, obj.getImporte());
//            ps.setInt(5, obj.getIdUsuario());
//            ps.setInt(6, obj.getIdInsumo());
//            ps.setInt(7, obj.getIdEntrada());
//            
//
//            if (ps.executeUpdate() > 0) {
//                ps.close();
//                return true;
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return false;
//
//        } finally {
//            ps = null;
//            conexion.desconectar();
//        }
        
        return false;
        
    }

    @Override
    public boolean eliminar(EntradaInsumo obj) {
        
//        try {
//            ps = conexion.conectar().prepareStatement("DELETE FROM EntradaInsumo WHERE IdEntrada=?");
//            ps.setInt(1, obj.getIdEntrada());
//
//            if (ps.executeUpdate() > 0) {
//                ps.close();
//                return true;
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            return false;
//        } finally {
//            ps = null;
//            conexion.desconectar();
//        }

        return false;
        
    }

    @Override
    public List<EntradaInsumo> listar() {
        List<EntradaInsumo> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from EntradaInsumo");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new EntradaInsumo(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getFloat(5),rs.getInt(6), rs.getInt(7)));
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
    public List<EntradaInsumo> listar(EntradaInsumo obj) {
        return null;
    }
}//end EntradaInsumoDaoImpl
