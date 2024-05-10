package pt.ipp.isep.dei.esoft.project.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public class ZipCode {
    private int local;
    private int street;

    public ZipCode(int local, int street) {
        this.setStreet(street);
        this.setLocal(local);
    }

    public ZipCode(ZipCode zipCode) {
        this.local = zipCode.getLocal();
        this.street = zipCode.getStreet();
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        if (local > 9999 || local < 1000){
            throw new InvalidParameterException("Street must have a total of 4 digits.");
        }
        this.local = local;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        if (street > 999){
            throw new InvalidParameterException("Street must have a total of 3 digits.");
        }
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return local == zipCode.local && street == zipCode.street;
    }
}