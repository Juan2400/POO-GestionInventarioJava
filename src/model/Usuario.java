package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Usuario {

    private int IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Dni;
    private String NombreUsuario;
    private String Contrasenia;
    private String Email;
    private int IdRol;

    public Usuario() {

    }

    public Usuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public Usuario(String Nombre) {
        this.Nombre = Nombre;
    }

    public Usuario(String Nombre, String Apellido, String Dni, String NombreUsuario, String Contrasenia, String Email, int IdRol) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        this.Email = Email;
        this.IdRol = IdRol;
    }
    
    public Usuario(int IdUsuario, String Nombre, String Apellido, String Dni, String NombreUsuario, String Contrasenia, String Email, int IdRol) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Dni = Dni;
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        this.Email = Email;
        this.IdRol = IdRol;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }
    
    public void finalize() throws Throwable {

    }
}//end Usuario
