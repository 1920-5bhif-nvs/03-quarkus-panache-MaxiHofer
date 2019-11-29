package at.htl.business;

import at.htl.model.Motorcycle;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MotorcycleFacade extends BaseFacade<Motorcycle> {

    @Override
    public List<Motorcycle> getAll() {
        return em.createNamedQuery("Motorcycle.findAll", Motorcycle.class).getResultList();
    }

    public Motorcycle getById(Long id) {
        return em.find(Motorcycle.class, id);
    }
}
