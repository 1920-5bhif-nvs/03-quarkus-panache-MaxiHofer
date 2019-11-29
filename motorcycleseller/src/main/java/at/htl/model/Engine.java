package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Engine.findAll", query = "select e from Engine e"),
})
public class Engine extends PanacheEntity {

    public int cylinders;
    public int cubicCapacity;

    public Engine() {
    }

    public Engine(int cylinders, int cubicCapacity) {
        this.cylinders = cylinders;
        this.cubicCapacity = cubicCapacity;
    }

}
