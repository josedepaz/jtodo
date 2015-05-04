package gt.com.gyt.api.todo.svc;

import gt.com.gyt.api.model.todo.db.Task;
import gt.com.gyt.api.todo.dao.TodoDao;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jcano
 */
@Stateless
public class TodoSvcImpl implements TodoSvc, Serializable {

    private Integer identityLocal = 0;

    @Inject
    TodoDao todoDao;
    @Inject
    IdentityGenerator identityGenerator;

    @Override
    public Task createTask(Task task) {
        initTaskValues(task);
        return task;
    }

    private void initTaskValues(Task task) {
        task.setCreationDate(new Date());
        todoDao.persist(task);
        task.setDueDate(new Date());
        task.setExample(identityGenerator.generateIdentity("PRUEBA").toString() + "_" + identityLocal++);
    }

}
