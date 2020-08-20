package org.academiadecodigo.bootcamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "car")
public class Car extends Vehicle {

    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}
