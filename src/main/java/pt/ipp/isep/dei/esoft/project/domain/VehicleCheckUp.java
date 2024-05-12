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

    public void setKms(float kms) {
        this.kms = kms;
    }

    public VehicleCheckUp(Date date, Address place, float kms) {
        if(checkIfDateSurpassedActualOne(date)){
            throw new IllegalArgumentException("Date has surpassed the actual date.");
        }
        this.date = date;
        this.place = place;
        this.kms = kms;
    }

    private static boolean checkIfDateSurpassedActualOne(Date date){
        Date actualDate = new Date();
        if (actualDate.after(date))
            return true;
        return false;
    }
}
