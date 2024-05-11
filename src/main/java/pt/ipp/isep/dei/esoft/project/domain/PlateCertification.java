package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.Objects;

public class PlateCertification {
    private String brand;
    private String model;
    private String type;
    private double tare;
    private double grossWeight;
    private Date registerDate;
    private String plate;

    public PlateCertification(String brand, String model, String type, double tare, double grossWeight, Date registerDate, String plate) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.registerDate = registerDate;
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()){
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("Type cannot be empty.");
        }
        this.type = type;
    }

    public double getTare() {
        return tare;
    }

    public void setTare(double tare) { //public void setTare(double tare, PlateCertification plateCertification)
        if (tare <= 0){ //if (tare <= 0 && tare > plateCertification.getGrossWeight())
            throw new IllegalArgumentException("Tare cannot have negative values or 0.");
            //throw new IllegalArgumentException("Tare cannot have negative values or 0. Tare cannot be greater than Gross Weight.");

        }
        this.tare = tare;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) { //public void setGrossWeight(double grossWeight, PlateCertification plateCertification)
        if (grossWeight <= 0){ //if (grossWeight <= 0 && grossWeight < plateCertification.getTare())
            throw new IllegalArgumentException("Tare cannot have negative values or 0.");
            //throw new IllegalArgumentException("Tare cannot have negative values or 0. Gross Weight cannot be lower than Tare.");
        }
        this.grossWeight = grossWeight;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        if (plate == null || plate.isEmpty()){
            throw new IllegalArgumentException("Plate cannot be empty.");
        }
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateCertification that = (PlateCertification) o;
        return Double.compare(tare, that.tare) == 0 && Double.compare(grossWeight, that.grossWeight) == 0 && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(type, that.type) && Objects.equals(registerDate, that.registerDate) && Objects.equals(plate, that.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, type, tare, grossWeight, registerDate, plate);
    }

    @Override
    public String toString() {
        return "PlateCertification{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", tare=" + tare +
                ", grossWeight=" + grossWeight +
                ", registerDate=" + registerDate +
                ", plate='" + plate + '\'' +
                '}';
    }

    public PlateCertification clone() {
        return new PlateCertification(this.brand, this.model,this.type,this.tare,this.grossWeight,this.registerDate,this.plate);
    }
}