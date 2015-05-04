package gt.com.gyt.api.todo.web.rs;

import gt.com.gyt.api.model.todo.db.Task;
import gt.com.gyt.api.todo.dao.TodoDao;
import gt.com.gyt.api.todo.svc.TodoSvc;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jcano
 */
@Path("todo")
@ManagedBean
public class TodoRS implements Serializable {

    @Inject
    TodoDao todoDao;

    @Inject
    TodoSvc todoSvc;

    @GET
    @Path("/tasks/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task findTaskByDbid(@PathParam("id") Integer dbid) {
        return todoDao.findTaskByDbid(dbid);
    }

    @POST
    @Path("/tasks/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Task createTask(Task task) {
        
        Task result = todoSvc.createTask(task);        
        return result;
    }

}
