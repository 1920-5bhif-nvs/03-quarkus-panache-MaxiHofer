package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends PanacheEntity {

    public String firstname;
    public String lastname;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Purchase> purchases;


    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer() {
    }
}
