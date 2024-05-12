package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class VehicleCheckUp {
    private Date date;
    private Address place;
    private float kms;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if(checkIfDateSurpassed(date)){
            throw new IllegalArgumentException("Date has surpassed the actual date.");
        }
        this.date = date;
        this.place = place;
        this.kms = kms;
    }

    private boolean checkIfDateSurpassed(Date date){
        Date actualDate = new Date();
        if (actualDate.after(date))
            return true;
        return false;
    }
}
