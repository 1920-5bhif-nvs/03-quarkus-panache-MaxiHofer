package at.htl.business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BaseFacade<T> {

    @PersistenceContext
    EntityManager em;

    public void safe(T t) {
        em.persist(t);
    }

    public T update(T t) {
        return em.merge(t);
    }

    public void delete(T t) {
        em.remove(t);
    }

    public abstract List<T> getAll();

    public EntityManager getEm() {
        return em;
    }
}
