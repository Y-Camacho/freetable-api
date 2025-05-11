package cat.ycamacho.freetable_api.repositories;

import org.springframework.data.repository.CrudRepository;

import cat.ycamacho.freetable_api.models.Reservation;

public interface ReservationReposiroty extends CrudRepository<Reservation, Long> {

}
