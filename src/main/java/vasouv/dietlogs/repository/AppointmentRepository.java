package vasouv.dietlogs.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vasouv.dietlogs.entities.Appointment;

/**
 * @author vasouv
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findByPersonId(int id);

    @Query("select max(a.id) from Appointment a")
    int getMaxAppointmentID();

}
