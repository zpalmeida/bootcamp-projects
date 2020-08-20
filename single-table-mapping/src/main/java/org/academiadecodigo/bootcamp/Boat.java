package org.academiadecodigo.bootcamp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("boat")
public class Boat extends Vehicle {

    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}
