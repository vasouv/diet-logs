package vasouv.dietlogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vasouv
 */
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Integer personID;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "fname")
    private String name;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 5, max = 10)
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "height")
    private double height;

    @NotNull
    @Column(name = "targetkg")
    private double targetkg;

    @Size(max = 2147483647)
    @Column(name = "illness")
    private String illness;

    @Size(max = 2147483647)
    @Column(name = "medication")
    private String medication;

    @Size(max = 2147483647)
    @Column(name = "allergies")
    private String allergies;

    //One person has many measurements
    @OneToMany(mappedBy = "person")
    private List<Measurement> measurementList;

    private Person() {
    }

    public Person(String name, String address, String phone, int age, double height, double targetkg, String illness, String medication, String allergies) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.height = height;
        this.targetkg = targetkg;
        this.illness = illness;
        this.medication = medication;
        this.allergies = allergies;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTargetkg() {
        return targetkg;
    }

    public void setTargetkg(double targetkg) {
        this.targetkg = targetkg;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public List<Measurement> getMeasurementList() {
        return measurementList;
    }

    public void setMeasurementList(List<Measurement> measurementList) {
        this.measurementList = measurementList;
    }

}
