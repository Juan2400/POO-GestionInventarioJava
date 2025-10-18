package model;

import java.sql.Timestamp;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class SalidaInsumo {

    private int IdSalida;
    private Timestamp FechaSalida;
    private int Cantidad;
    private int IdUsuario;
    private int IdInsumo;

    public SalidaInsumo() {

    }

    public SalidaInsumo(int IdSalida) {
        this.IdSalida = IdSalida;
    }

    public SalidaInsumo(int IdSalida, Timestamp FechaSalida, int Cantidad, int IdUsuario, int IdInsumo) {
        this.IdSalida = IdSalida;
        this.FechaSalida = FechaSalida;
        this.Cantidad = Cantidad;
        this.IdUsuario = IdUsuario;
        this.IdInsumo = IdInsumo;
    }

    public SalidaInsumo(Timestamp FechaSalida, int Cantidad, int IdUsuario, int IdInsumo) {
        this.FechaSalida = FechaSalida;
        this.Cantidad = Cantidad;
        this.IdUsuario = IdUsuario;
        this.IdInsumo = IdInsumo;
    }

    public int getIdSalida() {
        return IdSalida;
    }

    public void setIdSalida(int IdSalida) {
        this.IdSalida = IdSalida;
    }

    public Timestamp getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Timestamp FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
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

}//end SalidaInsumo
