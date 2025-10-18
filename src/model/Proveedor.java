package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Proveedor {

    private int IdProveedor;
    private String NombreProveedor;
    private String Direccion;
    private String Ruc;
    private String Telefono;

    public Proveedor() {

    }

    public Proveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public Proveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public Proveedor(String NombreProveedor, String Direccion, String Ruc, String Telefono) {
        this.NombreProveedor = NombreProveedor;
        this.Direccion = Direccion;
        this.Ruc = Ruc;
        this.Telefono = Telefono;
    }
 
    public Proveedor(int IdProveedor, String NombreProveedor, String Direccion, String Ruc, String Telefono) {
        this.IdProveedor = IdProveedor;
        this.NombreProveedor = NombreProveedor;
        this.Direccion = Direccion;
        this.Ruc = Ruc;
        this.Telefono = Telefono;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    

    public void finalize() throws Throwable {

    }
}//end Proveedor
