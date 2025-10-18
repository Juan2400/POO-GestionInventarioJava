package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Categoria {

    private int IdCategoria;
    private String NombreCategoria;
    private String Descripcion;

    public Categoria() {

    }

    public Categoria(int IdCategoria, String NombreCategoria, String Descripcion) {
        this.IdCategoria = IdCategoria;
        this.NombreCategoria = NombreCategoria;
        this.Descripcion = Descripcion;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    

    public void finalize() throws Throwable {

    }
}//end Categoria
