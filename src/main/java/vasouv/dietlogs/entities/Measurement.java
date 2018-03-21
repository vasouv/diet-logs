package vasouv.dietlogs.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vasouv
 */
@Entity
@Table(name = "measurements")
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measure_id")
    private Integer measureID;

    @NotNull
    @Column(name = "measuredate")
    @Temporal(TemporalType.DATE)
    private Date measuredate;

    @NotNull
    @Column(name = "weightkg")
    private double weightkg;

    @NotNull
    @Column(name = "bmi")
    private double bmi;

    @ManyToOne
    private Person person;

    private Measurement() {
    }

    public Measurement(Date measuredate, double weightkg, double bmi) {
        this.measuredate = measuredate;
        this.weightkg = weightkg;
        this.bmi = bmi;
    }

    public Integer getMeasureID() {
        return measureID;
    }

    public void setMeasureID(Integer measureID) {
        this.measureID = measureID;
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

}
