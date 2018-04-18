package vasouv.dietlogs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vasouv.dietlogs.entities.Appointment;

/**
 * @author vasouv
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    Appointment findByPersonId(int id);
    
    @Query("select max(a.id) from Appointment a")
    int getMaxAppointmentID();

}