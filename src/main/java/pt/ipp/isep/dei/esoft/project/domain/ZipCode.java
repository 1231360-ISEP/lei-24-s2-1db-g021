package pt.ipp.isep.dei.esoft.project.domain;

public class ZipCode {
    private int local;
    private int street;

    public ZipCode(int local, int street) {
        this.local = local;
        this.street = street;
    }

    public ZipCode(ZipCode zipCode) {
        this.local = zipCode.getLocal();
        this.street = zipCode.getStreet();
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }


}