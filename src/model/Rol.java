package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Rol {

    private int IdRol;
    private String NombreRol;
    private String DescripcionRol;

    public Rol() {

    }

    public Rol(int IdRol, String NombreRol, String DescripcionRol) {
        this.IdRol = IdRol;
        this.NombreRol = NombreRol;
        this.DescripcionRol = DescripcionRol;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }

    public String getDescripcionRol() {
        return DescripcionRol;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionRol = DescripcionRol;
    }


    public void finalize() throws Throwable {

    }
}//end Rol
