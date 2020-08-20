package org.academiadecodigo.bootcamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "boat")
public class Boat extends Vehicle {

    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}
