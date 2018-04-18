package vasouv.dietlogs.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author vasouv
 */
@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @Column(name = "app_id")
    private Integer id;

    @NotNull
    @Column(name = "app_date")
    private LocalDate appointmentDate;

    @NotNull
    @Column(name = "app_time")
    private LocalTime appointmentTime;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Appointment() {
    }

    public Appointment(LocalDate appDate, LocalTime appTime) {
        this.appointmentDate = appDate;
        this.appointmentTime = appTime;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public Integer getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}