package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.Objects;

public class Vehicle {
    private double currentKm;
    private Date acquisitionDate;
    private double maintenance;
    private final PlateCertification plateCertification;


    public Vehicle(double currentKm, Date acquisitionDate, double maintenance,PlateCertification plateCertification) {
        this.currentKm = currentKm;
        this.acquisitionDate = acquisitionDate;
        this.maintenance = maintenance;
        this.plateCertification = plateCertification;
    }

    public double getCurrentKm() {
        return currentKm;
    }

    public void setCurrentKm(double currentKm) {
        if (currentKm < 0){
            throw new IllegalArgumentException("There cannot be negative values for Km.");
        }
        this.currentKm = currentKm;
    }

    public PlateCertification getPlateCertification() {
        return plateCertification;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        if (maintenance <= 0){
            throw new IllegalArgumentException("There cannot be negative values or 0 for maintenance(kms).");
        }
        this.maintenance = maintenance;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "currentKm=" + currentKm +
                ", acquisitionDate=" + acquisitionDate +
                ", maintenance=" + maintenance +
                ", plateCertification=" + plateCertification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(currentKm, vehicle.currentKm) == 0 && Double.compare(maintenance, vehicle.maintenance) == 0 && Objects.equals(acquisitionDate, vehicle.acquisitionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentKm, acquisitionDate, maintenance, plateCertification);
    }

    public Vehicle clone() {
        return new Vehicle(this.currentKm, this.acquisitionDate, this.maintenance,this.plateCertification);
    }
}