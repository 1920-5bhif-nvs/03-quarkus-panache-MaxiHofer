package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Transmission.findAll", query = "select t from Transmission t"),
})
public class Transmission extends PanacheEntity {

    public int gears;

    public Transmission() {
    }

    public Transmission(int gears) {
        this.gears = gears;
    }

}
