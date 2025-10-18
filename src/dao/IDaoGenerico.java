package dao;

import java.util.List;

/**
 * @author HP
 * @version 1.0
 * @created 08-Dic.-2023 11:38:20 p.�m.
 */
public interface IDaoGenerico<T> {

    /**
     *
     * @param obj
     */
    public boolean agregar(T obj);

    /**
     *
     * @param obj
     */
    public boolean actualizar(T obj);

    /**
     *
     * @param obj
     */
    public boolean eliminar(T obj);

    public List<T> listar();

    /**
     *
     * @param obj
     */
    public List<T> listar(T obj);

}
