package vasouv.dietlogs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author vasouv
 */
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @Column(name = "measure_id")
    private Integer id;

    @NotNull
    @Column(name = "measure_date")
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date measuredate;

    @NotNull
    @Column(name = "weightkg")
    private double weightkg;

    @NotNull
    @Column(name = "bmi")
    private double bmi;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference //to not include the Person in the returning JSON
    private Person person;

    public Measurement() {
    }

    public Measurement(Date measuredate, double weightkg, double bmi) {
        this.measuredate = measuredate;
        this.weightkg = weightkg;
        this.bmi = bmi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMeasuredate() {
        return measuredate;
    }

    public void setMeasuredate(Date measuredate) {
        this.measuredate = measuredate;
    }

    public double getWeightkg() {
        return weightkg;
    }

    public void setWeightkg(double weightkg) {
        this.weightkg = weightkg;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Measurement{" + "id=" + id + ", measuredate=" + measuredate + ", weightkg=" + weightkg + ", bmi=" + bmi + '}';
    }

}
