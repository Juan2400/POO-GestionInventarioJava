package daoImpl;

import dao.IDaoGenerico;
import dataSource.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * Implementación DAO para Usuario con manejo seguro de contraseñas
 * @author HP
 * @version 2.0
 */
public class UsuarioDaoImpl implements IDaoGenerico<Usuario> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {
        // Limpieza de recursos si es necesario
    }

    @Override
    public boolean agregar(Usuario obj) {
        try {
            // Verificar si el usuario ya existe
            if (existeNombreUsuario(obj.getNombreUsuario())) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Por favor, elija otro.");
                return false;
            }

            ps = conexion.conectar().prepareStatement(
                "INSERT INTO Usuario (Nombre, Apellido, Dni, NombreUsuario, Contrasenia, Email, IdRol) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDni());
            ps.setString(4, obj.getNombreUsuario());
            ps.setString(5, HashUtil.getMD5(obj.getContrasenia())); // Encriptar contraseña
            ps.setString(6, obj.getEmail());
            ps.setInt(7, obj.getIdRol());

            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }
        return false;
    }

    /**
     * Verifica si un nombre de usuario ya existe en la base de datos
     */
    private boolean existeNombreUsuario(String nombreUsuario) {
        try {
            ps = conexion.conectar().prepareStatement(
                "SELECT 1 FROM Usuario WHERE NombreUsuario = ?"
            );
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();
            boolean existe = rs.next();
            rs.close();
            ps.close();
            return existe;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar usuario: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Usuario obj) {
        try {
            // PASO 1: Obtener la contraseña actual de la base de datos
            ps = conexion.conectar().prepareStatement(
                "SELECT Contrasenia FROM Usuario WHERE IdUsuario=?"
            );
            ps.setInt(1, obj.getIdUsuario());
            rs = ps.executeQuery();
            
            String contraseniaActualBD = "";
            if (rs.next()) {
                contraseniaActualBD = rs.getString("Contrasenia");
            }
            rs.close();
            ps.close();
            
            // PASO 2: Determinar si la contraseña cambió
            String contraseniaNueva;
            String contraseniaIngresada = obj.getContrasenia();
            
            // Si la contraseña ingresada es igual al hash de la BD, no cambió
            if (contraseniaIngresada.equals(contraseniaActualBD)) {
                contraseniaNueva = contraseniaActualBD; // Mantener el hash existente
            } 
            // Si la contraseña ya está hasheada (por alguna razón), mantenerla
            else if (HashUtil.isHashedMD5(contraseniaIngresada)) {
                contraseniaNueva = contraseniaIngresada;
            }
            // Si es una nueva contraseña en texto plano, hashearla
            else {
                contraseniaNueva = HashUtil.getMD5(contraseniaIngresada);
            }
            
            // PASO 3: Actualizar el usuario
            ps = conexion.conectar().prepareStatement(
                "UPDATE Usuario SET Nombre=?, Apellido=?, Dni=?, NombreUsuario=?, " +
                "Contrasenia=?, Email=?, IdRol=? WHERE IdUsuario=?"
            );
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDni());
            ps.setString(4, obj.getNombreUsuario());
            ps.setString(5, contraseniaNueva);
            ps.setString(6, obj.getEmail());
            ps.setInt(7, obj.getIdRol());
            ps.setInt(8, obj.getIdUsuario());

            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + ex.getMessage());
            return false;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return false;
    }

    @Override
    public boolean eliminar(Usuario obj) {
        try {
            ps = conexion.conectar().prepareStatement(
                "DELETE FROM Usuario WHERE IdUsuario=?"
            );
            ps.setInt(1, obj.getIdUsuario());
            
            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }
        return false;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("SELECT * FROM Usuario");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("IdUsuario"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Dni"),
                    rs.getString("NombreUsuario"),
                    rs.getString("Contrasenia"), // Hash de la contraseña
                    rs.getString("Email"),
                    rs.getInt("IdRol")
                ));
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
            lista = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return lista;
    }

    @Override
    public List<Usuario> listar(Usuario obj) {
        List<Usuario> lista = new ArrayList<>();

        try {
            if (obj.getIdUsuario() != 0) {
                ps = conexion.conectar().prepareStatement(
                    "SELECT * FROM Usuario WHERE IdUsuario=?"
                );
                ps.setInt(1, obj.getIdUsuario());
            } else {
                ps = conexion.conectar().prepareStatement(
                    "SELECT * FROM Usuario WHERE NombreUsuario LIKE ?"
                );
                ps.setString(1, "%" + obj.getNombreUsuario() + "%");
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("IdUsuario"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Dni"),
                    rs.getString("NombreUsuario"),
                    rs.getString("Contrasenia"),
                    rs.getString("Email"),
                    rs.getInt("IdRol")
                ));
            }

            ps.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuarios: " + e.getMessage());
            lista = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }

        return lista;
    }

    /**
     * Obtiene un usuario por nombre de usuario y contraseña (para login)
     */
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) {
        Usuario usuario = null;
        try {
            String hashContrasenia = HashUtil.getMD5(contrasenia);
            ps = conexion.conectar().prepareStatement(
                "SELECT * FROM Usuario WHERE NombreUsuario=? AND Contrasenia=?"
            );
            ps.setString(1, nombreUsuario);
            ps.setString(2, hashContrasenia);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("IdUsuario"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Dni"),
                    rs.getString("NombreUsuario"),
                    rs.getString("Contrasenia"),
                    rs.getString("Email"),
                    rs.getInt("IdRol")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuario: " + e.getMessage());
            usuario = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }
        return usuario;
    }
    
    /**
     * Actualiza solo la contraseña de un usuario
     */
    public boolean actualizarContrasenia(int idUsuario, String nuevaContrasenia) {
        try {
            ps = conexion.conectar().prepareStatement(
                "UPDATE Usuario SET Contrasenia=? WHERE IdUsuario=?"
            );
            ps.setString(1, HashUtil.getMD5(nuevaContrasenia));
            ps.setInt(2, idUsuario);
            
            if (ps.executeUpdate() > 0) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar contraseña: " + ex.getMessage());
            return false;
        } finally {
            ps = null;
            conexion.desconectar();
        }
        return false;
    }

}//end UsuarioDaoImpl

//Borras esa clase D hastUtil





/**

public class UsuarioDaoImpl implements IDaoGenerico<Usuario> {

    private Conexion conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDaoImpl() {
        conexion = Conexion.getInstancia();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public boolean agregar(Usuario obj) {
        try {
            // Verificar si el usuario y la contraseña ya existen
            if (!existeUsuario(obj.getNombreUsuario(), obj.getContrasenia())) {
                ps = conexion.conectar().prepareStatement("INSERT INTO Usuario (Nombre, Apellido, Dni, NombreUsuario, Contrasenia, Email, IdRol) VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, obj.getNombre());
                ps.setString(2, obj.getApellido());
                ps.setString(3, obj.getDni());
                ps.setString(4, obj.getNombreUsuario());
                ps.setString(5, obj.getContrasenia());
                ps.setString(6, obj.getEmail());
                ps.setInt(7, obj.getIdRol());

                if (ps.executeUpdate() > 0) {
                    ps.close();
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                return false;
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

    private boolean existeUsuario(String nombreUsuario, String contrasenia) {
        try {
            // Consulta para verificar si el usuario y la contraseña existen
            PreparedStatement ps = conexion.conectar().prepareStatement("SELECT 1 FROM Usuario WHERE NombreUsuario = ? AND Contrasenia = ?");
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Si hay filas, significa que el usuario y la contraseña existen
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean actualizar(Usuario obj) {

        try {
            ps = conexion.conectar().prepareStatement("UPDATE Usuario SET Nombre=?,Apellido= ?,Dni=?,NombreUsuario=?,Contrasenia=?,Email=?,IdRol=? WHERE IdUsuario=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDni());
            ps.setString(4, obj.getNombreUsuario());
            ps.setString(5, obj.getContrasenia());
            ps.setString(6, obj.getEmail());
            ps.setInt(7, obj.getIdRol());
            ps.setInt(8, obj.getIdUsuario());

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
    public boolean eliminar(Usuario obj) {
        try {
            ps = conexion.conectar().prepareStatement("DELETE FROM Usuario WHERE IdUsuario=?");
            ps.setInt(1, obj.getIdUsuario());
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
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
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
    public List<Usuario> listar(Usuario obj) {
        List<Usuario> lista = new ArrayList<>();

        boolean encontrado = false;

        try {
            if (obj.getIdUsuario() != 0) {
                ps = conexion.conectar().prepareStatement("select * from Usuario where idUsuario=?");
                ps.setInt(1, obj.getIdUsuario());
            } else {
                ps = conexion.conectar().prepareStatement("select * from Usuario where Nombre like ?");
                ps.setString(1, "%" + obj.getNombreUsuario() + "%");
            }

            obj = null;

            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
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

    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia) {
        Usuario usuario = null;

        try {
            ps = conexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE NombreUsuario=? AND Contrasenia=?");
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);

            rs = ps.executeQuery();

            if (rs.next()) { // Si se encuentra una coincidencia
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            } else { // Si no se encuentra ninguna coincidencia
                usuario = null;
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            usuario = null;
        } finally {
            ps = null;
            rs = null;
            conexion.desconectar();
        }

        return usuario;
    }

}

*/
