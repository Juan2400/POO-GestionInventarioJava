package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Insumo {

    private int IdInsumo;
    private String NombreInsumo;
    private int IdUnidadMedida;
    private int IdCategoria;
    private int IdProveedor;

    public Insumo() {

    }

    public Insumo(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public Insumo(String NombreInsumo) {
        this.NombreInsumo = NombreInsumo;
    }
    
    public Insumo(String NombreInsumo, int IdUnidadMedida, int IdCategoria, int IdProveedor) {
        this.NombreInsumo = NombreInsumo;
        this.IdUnidadMedida = IdUnidadMedida;
        this.IdCategoria = IdCategoria;
        this.IdProveedor = IdProveedor;
    }
    
    public Insumo(int IdInsumo, String NombreInsumo, int IdUnidadMedida, int IdCategoria, int IdProveedor) {
        this.IdInsumo = IdInsumo;
        this.NombreInsumo = NombreInsumo;
        this.IdUnidadMedida = IdUnidadMedida;
        this.IdCategoria = IdCategoria;
        this.IdProveedor = IdProveedor;
    }

    public int getIdInsumo() {
        return IdInsumo;
    }

    public void setIdInsumo(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public String getNombreInsumo() {
        return NombreInsumo;
    }

    public void setNombreInsumo(String NombreInsumo) {
        this.NombreInsumo = NombreInsumo;
    }

    public int getIdUnidadMedida() {
        return IdUnidadMedida;
    }

    public void setIdUnidadMedida(int IdUnidadMedida) {
        this.IdUnidadMedida = IdUnidadMedida;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
    
    

    public void finalize() throws Throwable {

    }
}//end Insumo
