package gt.com.gyt.api.todo.svc;

import gt.com.gyt.api.model.todo.db.Task;

/**
 *
 * @author jcano
 */
public interface TodoSvc {

    public Task createTask(Task task);

}
