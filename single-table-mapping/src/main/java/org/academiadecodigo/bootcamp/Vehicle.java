package org.academiadecodigo.bootcamp;

import javax.persistence.*;

@Entity
@Table (name = "vehicle")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iD;

    @Version
    private Integer version;

    private Integer maxSpeed;

    public Integer getiD() {
        return iD;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
