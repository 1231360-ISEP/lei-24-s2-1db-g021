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

    /**
     * Creates a new instance of PlateCertification Class.
     * @param brand Represents the brand of the vehicle.
     * @param model Represents the car model.
     * @param type Represents the type of vehicle.
     * @param tare Represents the total weight of the vehicle when it is empty.
     * @param grossWeight Represents the total weight of the vehicle along with all its contents.
     * @param registerDate Represents the date on which the plate was registered.
     * @param plate Represents the plate format.
     */
    public PlateCertification(String brand, String model, String type, double tare, double grossWeight, Date registerDate, String plate) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.registerDate = registerDate;
        this.plate = plate;
    }

    /**
     * Returns the value of the attribute brand.
     * @return the brand value.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand it's the brand of vehicle,
     *             if the brand is valid, set the brand,
     *             if it's null or empty, it throws a IllegalArgumentException.
     */
    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    /**
     * Returns the value of the attribute model.
     * @return the model value.
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model it's the model of vehicle,
     *             if the model is valid, set the model,
     *             if it's null or empty, it throws a IllegalArgumentException.
     */
    public void setModel(String model) {
        if (model == null || model.isEmpty()){
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model;
    }

    /**
     * Returns the value of the attribute type.
     * @return the type value.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type it's the type of vehicle,
     *             if the model is valid, set the model,
     *             if it's null or empty, it throws a IllegalArgumentException.
     */
    public void setType(String type) {
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("Type cannot be empty.");
        }
        this.type = type;
    }

    /**
     * Returns the value of the attribute tare.
     * @return the tare value.
     */
    public double getTare() {
        return tare;
    }

    /**
     * @param tare it's the tare of vehicle,
     *             if the tare is valid, set the tare,
     *             if it's less than or equal to zero, and is greater than grossWeight, it throws a IllegalArgumentException.
     */
    public void setTare(double tare, PlateCertification plateCertification) {
        if (tare <= 0 && tare > plateCertification.getGrossWeight()){
            throw new IllegalArgumentException("Tare cannot have negative values or 0. Tare cannot be greater than Gross Weight.");
        }
        this.tare = tare;
    }

    /**
     * Returns the value of the attribute grossWeight.
     * @return the grossWeight value.
     */
    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight, PlateCertification plateCertification) {
        if (grossWeight <= 0 && grossWeight < plateCertification.getTare()){
            throw new IllegalArgumentException("Tare cannot have negative values or 0. Gross Weight cannot be lower than Tare.");
        }
        this.grossWeight = grossWeight;
    }

    /**
     * Returns the value of the attribute registerDate.
     * @return the registerDate value.
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate it's the date on which the plate was registered.
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Returns the value of the attribute plate.
     * @return the plate value.
     */
    public String getPlate() {
        return plate;
    }

    /** MATRÍCULA VER PRINT TELEMÓVEL - validação
     * @param plate it's the vehicle plate,
     *             if the plate is valid, set the model,
     *             if it's null or empty, it throws a IllegalArgumentException.
     */
    public void setPlate(String plate) {
        if (plate == null || plate.isEmpty()){
            throw new IllegalArgumentException("Plate cannot be empty.");
        }
        this.plate = plate;
    }

    /**
     * Compare this PlateCertification object with another for equality.
     * @param o The object to be compared.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateCertification that = (PlateCertification) o;
        return Double.compare(tare, that.tare) == 0 && Double.compare(grossWeight, that.grossWeight) == 0 && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(type, that.type) && Objects.equals(registerDate, that.registerDate) && Objects.equals(plate, that.plate);
    }

    /**
     * Returns a hash code for the PlateCertification object.
     * This method is supported to facilitate the use of objects in hash-based data structures such as HashMap.
     * @return A hash code for the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, type, tare, grossWeight, registerDate, plate);
    }

    /**
     * Returns a String representation of the PlateCertification object.
     * This representation includes relevant information about the PlateCertification object.
     * @return String representation of the PlateCertification object.
     */
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

    /**
     * Creates and returns a copy of this Job object.
     * @return A copy of this object.
     */
    public PlateCertification clone() {
        return new PlateCertification(this.brand, this.model,this.type,this.tare,this.grossWeight,this.registerDate,this.plate);
    }
}