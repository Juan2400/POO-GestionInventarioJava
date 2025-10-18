package model;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:41:15 p.�m.
 */
public class UnidadMedida {

    private int IdUnidadMedida;
    private String NombreUnidadMedida;

    public UnidadMedida() {

    }

    public UnidadMedida(int IdUnidadMedida, String NombreUnidadMedida) {
        this.IdUnidadMedida = IdUnidadMedida;
        this.NombreUnidadMedida = NombreUnidadMedida;
    }

    public int getIdUnidadMedida() {
        return IdUnidadMedida;
    }

    public void setIdUnidadMedida(int IdUnidadMedida) {
        this.IdUnidadMedida = IdUnidadMedida;
    }

    public String getNombreUnidadMedida() {
        return NombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String NombreUnidadMedida) {
        this.NombreUnidadMedida = NombreUnidadMedida;
    }
    
    

    public void finalize() throws Throwable {

    }
}//end UnidadMedida
