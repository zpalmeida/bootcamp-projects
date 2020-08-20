package org.academiadecodigo.bootcamp;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String zIPCode;

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getzIPCode() {
        return zIPCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setzIPCode(String zIPCode) {
        this.zIPCode = zIPCode;
    }
}
