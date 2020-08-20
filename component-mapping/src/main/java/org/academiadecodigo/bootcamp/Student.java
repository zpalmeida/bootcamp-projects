package org.academiadecodigo.bootcamp;

import javax.persistence.*;

@Entity
@Table (name = "student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer iD;

    private String name;

    @Embedded
    private Address address;

    @Version
    private Integer version;

    public Integer getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Integer getVersion() {
        return version;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
