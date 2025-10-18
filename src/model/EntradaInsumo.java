package model;

import java.sql.Timestamp;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class EntradaInsumo {

    private int IdEntrada;
    private String NumeroFactura;
    private Timestamp FechaEntrada;
    private int Cantidad;
    private float Importe;
    private int IdUsuario;
    private int IdInsumo;

    public EntradaInsumo() {

    }

    public EntradaInsumo(int IdEntrada) {
        this.IdEntrada = IdEntrada;
    }

    public EntradaInsumo(int IdEntrada, String NumeroFactura, Timestamp FechaEntrada, int Cantidad, float Importe, int IdUsuario, int IdInsumo) {
        this.IdEntrada = IdEntrada;
        this.NumeroFactura = NumeroFactura;
        this.FechaEntrada = FechaEntrada;
        this.Cantidad = Cantidad;
        this.Importe = Importe;
        this.IdUsuario = IdUsuario;
        this.IdInsumo = IdInsumo;
    }

    public EntradaInsumo(String NumeroFactura, Timestamp FechaEntrada, int Cantidad, float Importe, int IdUsuario, int IdInsumo) {
        this.NumeroFactura = NumeroFactura;
        this.FechaEntrada = FechaEntrada;
        this.Cantidad = Cantidad;
        this.Importe = Importe;
        this.IdUsuario = IdUsuario;
        this.IdInsumo = IdInsumo;
    }

    public int getIdEntrada() {
        return IdEntrada;
    }

    public void setIdEntrada(int IdEntrada) {
        this.IdEntrada = IdEntrada;
    }

    public String getNumeroFactura() {
        return NumeroFactura;
    }

    public void setNumeroFactura(String NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
    }

    public Timestamp getFechaEntrada() {
        return FechaEntrada;
    }

    public void setFechaEntrada(Timestamp FechaEntrada) {
        this.FechaEntrada = FechaEntrada;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdInsumo() {
        return IdInsumo;
    }

    public void setIdInsumo(int IdInsumo) {
        this.IdInsumo = IdInsumo;
    }

    public void finalize() throws Throwable {

    }
}//end EntradaInsumo
