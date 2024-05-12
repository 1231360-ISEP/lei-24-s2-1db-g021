package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class VehicleCheckUp {
    private Date date;
    private Address place;
    private float kms;

    public Date getDate() {
        return date;
    }

    public boolean setDate(Date date) {
        if(checkIfDateSurpassedActualOne(date)){
            return false;
        }
        this.date = date;
        return true;
    }

    public Address getPlace() {
        return place;
    }

    public void setPlace(Address place) {
        this.place = place;
    }

    public float getKms() {
        return kms;
    }

    public boolean setKms(float kms) {
        if(kmsAreNegative(kms)){
            return false;
        }
        this.kms = kms;
        return true;
    }

    public VehicleCheckUp(Date date, Address place, float kms) {
        if(checkIfDateSurpassedActualOne(date)){
            throw new IllegalArgumentException("Date has surpassed the actual date.");
        }
        this.date = date;
        this.place = place;
        if(kmsAreNegative(kms)){
            throw new IllegalArgumentException("Kilometers can't be negative.");
        }
        this.kms = kms;
    }

    private static boolean checkIfDateSurpassedActualOne(Date date){
        Date actualDate = new Date();
        if (actualDate.after(date))
            return true;
        return false;
    }
    private static boolean kmsAreNegative(float kms){
        return kms < 0;
    }
}
