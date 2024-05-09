package pt.ipp.isep.dei.esoft.project.domain;

import java.security.InvalidParameterException;

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
        if (local > 9999){
            throw new InvalidParameterException("Street must have a total of 3 digits.");
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

}