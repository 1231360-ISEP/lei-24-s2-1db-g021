package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Address {
    private int doorNumber;
    private ZipCode zipCode;

    public Address(int doorNumber, ZipCode zipCode) {
        this.doorNumber = doorNumber;
        this.setZipCode(zipCode);
    }

    public Address(Address address) {
        this.doorNumber = address.getDoorNumber();
        this.zipCode = address.getZipCode();
    }


    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public ZipCode getZipCode() {
        return new ZipCode(zipCode);
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = new ZipCode(zipCode);
    }
}