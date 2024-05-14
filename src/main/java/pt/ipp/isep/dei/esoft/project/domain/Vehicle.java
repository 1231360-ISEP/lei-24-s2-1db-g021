package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.Objects;

public class Vehicle {
    private double currentKm;
    private Date acquisitionDate;
    private double maintenance;
    private final PlateCertification plateCertification;

    /**
     *
     * @param currentKm Represents the current km of a vehicle.
     * @param acquisitionDate Represents the date the vehicle was acquired by MusgoSublime.
     * @param maintenance Represents the value, in km, at which the vehicle must go for inspection.
     * @param plateCertification Through an aggregation relationship with PlateCertification class, it represents the license plate of a car and other attributes of a vehicle.
     */
    public Vehicle(double currentKm, Date acquisitionDate, double maintenance,PlateCertification plateCertification) {
        this.currentKm = currentKm;
        this.acquisitionDate = acquisitionDate;
        this.maintenance = maintenance;
        this.plateCertification = plateCertification;
    }

    /**
     * Returns the value of the attribute currentKm.
     * @return the currentKm value.
     */
    public double getCurrentKm() {
        return currentKm;
    }

    /**
     * @param currentKm Represents the current km of a vehicle,
     *             if the currentKm is lower than zero, it throws a IllegalArgumentException.
     */
    public void setCurrentKm(double currentKm) {
        if (currentKm < 0){
            throw new IllegalArgumentException("There cannot be negative values for Km.");
        }
        this.currentKm = currentKm;
    }

    /**
     * Returns the values of the attributes relating to the license plate of a vehicle.
     * @return the plateCertification value.
     */
    public PlateCertification getPlateCertification() {
        return plateCertification;
    }

    /**
     * Returns the value of the attribute acquisitionDate.
     * @return the acquisitionDate value.
     */
    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    /**
     * @param acquisitionDate Represents the date of acquisition of a vehicle.
     */
    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    /**
     * Returns the value of the attribute maintenance.
     * @return the maintenance value.
     */
    public double getMaintenance() {
        return maintenance;
    }

    /**
     * @param maintenance Represents the value, in km, at which the vehicle must go for inspection,
     *             if the maintenance is lower than zero or negative, it throws a IllegalArgumentException.
     */
    public void setMaintenance(double maintenance) {
        if (maintenance <= 0){
            throw new IllegalArgumentException("There cannot be negative values or 0 for maintenance(in kms).");
        }
        this.maintenance = maintenance;
    }

    /**
     * Returns a String representation of the Vehicle object.
     * This representation includes relevant information about the Vehicle object.
     * @return String representation of the PlateCertification object.
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "currentKm=" + currentKm +
                ", acquisitionDate=" + acquisitionDate +
                ", maintenance=" + maintenance +
                ", plateCertification=" + plateCertification +
                '}';
    }

    /**
     * Compare this Vehicle object with another for equality.
     * @param o The object to be compared.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(currentKm, vehicle.currentKm) == 0 && Double.compare(maintenance, vehicle.maintenance) == 0 && Objects.equals(acquisitionDate, vehicle.acquisitionDate);
    }

    /**
     * Returns a hash code for the Vehicle object.
     * This method is supported to facilitate the use of objects in hash-based data structures such as HashMap.
     * @return A hash code for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(currentKm, acquisitionDate, maintenance, plateCertification);
    }

    /**
     * Creates and returns a copy of this Vehicle object.
     * @return A copy of this object.
     */
    public Vehicle clone() {
        return new Vehicle(this.currentKm, this.acquisitionDate, this.maintenance,this.plateCertification);
    }
}