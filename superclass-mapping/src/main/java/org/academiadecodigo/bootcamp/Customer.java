package org.academiadecodigo.bootcamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "customer")
public class Customer extends AbstractModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
