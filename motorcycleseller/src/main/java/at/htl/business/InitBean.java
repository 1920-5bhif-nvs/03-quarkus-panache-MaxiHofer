package at.htl.business;

import at.htl.model.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev) {
        Customer c1 = new Customer("Hans", "Huber");
        em.persist(c1);
        Transmission t = new Transmission(5);
        Engine e = new Engine(2, 1290);
        MotorcycleType mt = new MotorcycleType("KTM", "Superduke", LocalDate.now());
        Motorcycle m = new Motorcycle("Orange", 180, mt, e, t);
        em.persist(m);
        Purchase p = new Purchase(c1, m);
        em.persist(p);
    }
}
