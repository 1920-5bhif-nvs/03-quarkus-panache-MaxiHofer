package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class MotorcycleType extends PanacheEntity {

    public String brand;
    public String model;
    public LocalDate yearOfConstruction;

    public MotorcycleType() {
    }

    public MotorcycleType(String brand, String model, LocalDate yearOfConstruction) {
        this.brand = brand;
        this.model = model;
        this.yearOfConstruction = yearOfConstruction;
    }
}
