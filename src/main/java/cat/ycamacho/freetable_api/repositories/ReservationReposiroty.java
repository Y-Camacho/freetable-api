package cat.ycamacho.freetable_api.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cat.ycamacho.freetable_api.models.Reservation;
import jakarta.transaction.Transactional;

public interface ReservationReposiroty extends CrudRepository<Reservation, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.restaurant.id = ?1")
    void reremoveByIdRestaurant(String idRes);
}
