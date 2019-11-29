package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Motorcycle.findAll", query = "select m from Motorcycle m"),
})
public class Motorcycle extends PanacheEntity {

    public String colour;
    public int hp;
    @OneToOne(cascade = CascadeType.ALL)
    public MotorcycleType motorcycleType;
    @OneToOne(cascade = CascadeType.ALL)
    public Engine engine;
    @OneToOne(cascade = CascadeType.ALL)
    public Transmission transmission;
    @OneToMany
    public List<Purchase> purchases;


    public Motorcycle() {
    }

    public Motorcycle(String colour, int hp, MotorcycleType motorcycleType, Engine engine, Transmission transmission) {
        this.colour = colour;
        this.hp = hp;
        this.motorcycleType = motorcycleType;
        this.engine = engine;
        this.transmission = transmission;
    }

}
