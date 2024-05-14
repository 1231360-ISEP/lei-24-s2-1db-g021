package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class VehicleCheckUp {
    private Date date;
    private Address place;
    private float kms;

    public Vehicle getVehicle() {
        return vehicle;
    }

    Vehicle vehicle;

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
     * Throws IllegalArgumentException if the kilometers is negative i.e. below 0
     * @param date the date
     * @param place the place
     * @param kms the kilometers
     */
    public VehicleCheckUp(Date date, Address place, float kms, Vehicle vehicle) {
        if(kmsAreNegative(kms)){
            throw new IllegalArgumentException("Kilometers can't be negative.");
        }
        this.kms = kms;
        this.vehicle = vehicle;
        this.date = date;
        this.place = place;
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
