package gt.com.gyt.api.todo.dao;

import gt.com.gyt.api.model.todo.db.Task;
import java.util.List;

/**
 *
 * @author jcano
 */
public interface TodoDao {

    /**
     * Encuentra una tarea por su dbid
     *
     * @param dbid paramentro de busqueda
     * @return tarea devuelta
     */
    public Task findTaskByDbid(Integer dbid);

    /**
     * Retorna las tareas de un usuario
     *
     * @param user usuario que se esta buscando
     * @param position posicion inicial en la cual se empieza la busqueda
     * @param limit numero de registros que retorna
     * @return
     */
    public List<Task> findTasksByUser(String user, Integer position, Integer limit);

    public Long findTasksCountByUser(String user);

    public void persist(Object object);

}
