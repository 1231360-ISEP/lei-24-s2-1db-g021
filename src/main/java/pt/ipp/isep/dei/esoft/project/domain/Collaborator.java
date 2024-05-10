package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Collaborator{
    private String name;
    private Date bornDate;
    private Date admDate;
    private Address address;
    private int phoneNumber;
    private String email;
    private int idCard;
    private int idNumber;
    private List<Skill> skills;

    public Collaborator(String name, Date bornDate, Date admDate, Address address, int phoneNumber, String email, int idCard, int idNumber) {
        this.name = name;
        this.bornDate = bornDate;
        this.admDate = admDate;
        this.setAddress(address);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
        this.idNumber = idNumber;
    }

    public Collaborator(String name, Date bornDate, Date admDate, Address address, int phoneNumber, String email, int idCard, int idNumber, List<Skill> skills) {
        this.name = name;
        this.bornDate = bornDate;
        this.admDate = admDate;
        this.setAddress(address);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
        this.idNumber = idNumber;
        this.skills = skills;
    }

    public Collaborator(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getAdmDate() {
        return admDate;
    }

    public void setAdmDate(Date admDate) {
        this.admDate = admDate;
    }

    public Address getAddress() { return new Address(address); }

    public void setAddress(Address address) { this.address = new Address(address); }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Collaborator)) {
            return false;
        }
        Collaborator collaborator = (Collaborator) o;
        return email.equals(collaborator.email);
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", bornDate=" + bornDate +
                ", admDate=" + admDate +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", idCard=" + idCard +
                ", idNumber=" + idNumber +
                ", skills=" + skills +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    public Collaborator clone() {
        return new Collaborator(this.name, this.bornDate, this.admDate, this.address, this.phoneNumber, this.email, this.idCard, this.idNumber, this.skills);
    }

    public void addSkill(Skill skill) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skill);
    }
    /*
    public void removeSkill(Skill skill) {
        if (skills != null) {
            skills.remove(skill);
        }
    }
    */
}