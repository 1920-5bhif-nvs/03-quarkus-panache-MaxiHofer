package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Purchase extends PanacheEntity {

    @OneToOne(cascade = CascadeType.ALL)
    public Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    public Motorcycle motorcycle;

    public Purchase() {
    }

    public Purchase(Customer customer, Motorcycle motorcycle) {
        this.customer = customer;
        this.motorcycle = motorcycle;
    }
}
