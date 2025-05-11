package cat.ycamacho.freetable_api.repositories;

import org.springframework.data.repository.CrudRepository;
import cat.ycamacho.freetable_api.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
