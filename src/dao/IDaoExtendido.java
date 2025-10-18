package dao;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:38:20 p.�m.
 */
public interface IDaoExtendido<T> extends IDaoGenerico<T> {

    /**
     *
     * @param texto
     */
    public int obtenerId(String texto);

    /**
     *
     * @param id
     */
    public String obtenerNombre(int id);

}
