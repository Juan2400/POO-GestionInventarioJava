package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class Inventario {

    private int IdInventario;
    private int Entrada;
    private int Salida;
    private int Stock;
    private int IdInsumo;
    private String NombreInsumo;

    public Inventario() {

    }

    public Inventario(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public Inventario(String NombreInsumo) {
        this.NombreInsumo = NombreInsumo;
    }
   
    public Inventario(int IdInventario, int Entrada, int Salida, int Stock, int IdInsumo, String NombreInsumo) {
        this.IdInventario = IdInventario;
        this.Entrada = Entrada;
        this.Salida = Salida;
        this.Stock = Stock;
        this.IdInsumo = IdInsumo;
        this.NombreInsumo = NombreInsumo;
    }

    public int getIdInventario() {
        return IdInventario;
    }

    public void setIdInventario(int IdInventario) {
        this.IdInventario = IdInventario;
    }

    public int getEntrada() {
        return Entrada;
    }

    public void setEntrada(int Entrada) {
        this.Entrada = Entrada;
    }

    public int getSalida() {
        return Salida;
    }

    public void setSalida(int Salida) {
        this.Salida = Salida;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
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
    
    public void finalize() throws Throwable {

    }
}//end Inventario
