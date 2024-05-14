package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class VehicleCheckUp {
    private Date date;
    private Address place;
    private float kms;
    Vehicle vehicle;

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

    /**
     * This method set the kilometers of the vehicle check-up
     * if the kilometers provided are negative, its returns false
     * @param kms the kilometers
     * @return a boolean value indicating the success of it
     */
    public boolean setKms(float kms) {
        if(kmsAreNegative(kms)){
            return false;
        }
        this.kms = kms;
        return true;
    }

    /**
     * Initializes a new VehicleCheckUp
     * Throws IllegalArgumentException if the date is earlier than the current date
     * Throws IllegalArgumentException if the kilometers is negative i.e. below 0
     * @param date the date
     * @param place the place
     * @param kms the kilometers
     */
    public VehicleCheckUp(Date date, Address place, float kms, Vehicle vehicle) {
        if(checkIfDateSurpassedActualOne(date)){
            throw new IllegalArgumentException("Date has surpassed the actual date.");
        }
        this.date = date;
        this.place = place;
        if(kmsAreNegative(kms)){
            throw new IllegalArgumentException("Kilometers can't be negative.");
        }
        this.kms = kms;
        this.vehicle = vehicle;
    }

    /**
     * This method returns true if the date of the moment is later than the date
     * @param date the date
     * @return a boolean value
     */
    private static boolean checkIfDateSurpassedActualOne(Date date){
        Date actualDate = new Date();
        if (actualDate.after(date))
            return true;
        return false;
    }

    /**
     * This method returns true if the kilometers are negative i.e. are below 0
     * @param kms the kilometers
     * @return a boolean value
     */
    private static boolean kmsAreNegative(float kms){
        return kms < 0;
    }

    public VehicleCheckUp clone() {
        return new VehicleCheckUp(this.date, this.place, this.kms, this.vehicle);
    }
}
