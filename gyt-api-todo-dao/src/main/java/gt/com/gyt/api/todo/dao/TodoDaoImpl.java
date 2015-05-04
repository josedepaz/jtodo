package gt.com.gyt.api.todo.dao;

import gt.com.gyt.api.model.todo.db.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jcano
 */
@Stateless
public class TodoDaoImpl implements TodoDao {

    @PersistenceContext(unitName = "ApiTodysgytPU")
    private EntityManager em;

    @Override
    public Task findTaskByDbid(Integer dbid) {
        return em.find(Task.class, dbid);
    }

    @Override
    public List<Task> findTasksByUser(String user, Integer position, Integer limit) {
        TypedQuery qry = em.createNamedQuery("Task.findByUser", Task.class);
        qry.setParameter("user", user);
        qry.setMaxResults(limit);
        qry.setFirstResult(position);
        return qry.getResultList();
    }

    @Override
    public Long findTasksCountByUser(String user) {
        Query qry = em.createQuery("SELECT COUNT(t) FROM Task t WHERE t.assignee.user = :user");
        qry.setParameter("user", user);
        return (Long) qry.getSingleResult();
    }

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

}
