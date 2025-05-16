package cat.ycamacho.freetable_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cat.ycamacho.freetable_api.models.Reservation;
import jakarta.transaction.Transactional;

public interface ReservationReposiroty extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r " +
        "WHERE (:resId IS NULL OR r.restaurant.id = :resId) " +
        "AND (:clientEmail IS NULL OR LOWER(r.client.email) LIKE LOWER(CONCAT('%', :clientEmail, '%')))")
    List<Reservation> search(@Param("resId") Integer resId, @Param("clientEmail") String clientEmail);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.restaurant.id = ?1")
    void reremoveByIdRestaurant(String idRes);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.client.email = ?1")
    void reremoveByEmailClient(String clientEmail);

}
