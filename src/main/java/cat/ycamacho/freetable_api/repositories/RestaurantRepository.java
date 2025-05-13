package cat.ycamacho.freetable_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cat.ycamacho.freetable_api.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    //@Query("SELECT r FROM Restaurant r WHERE (:resName IS NULL OR LOWER(r.name) LIKE LOWER(CONCAT('%', :resName, '%'))) AND (:tag IS NULL OR LOWER(r.tags) = LOWER(:tag))")
    //@Query("SELECT r FROM Restaurant r JOIN r.tags t WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :resName, '%')) AND LOWER(t) = LOWER(:tag)")
    @Query("SELECT r FROM Restaurant r " +
       "WHERE (:resName IS NULL OR LOWER(r.name) LIKE LOWER(CONCAT('%', :resName, '%'))) " +
       "AND (:tag IS NULL OR :tag MEMBER OF r.tags)")
    List<Restaurant> findByNameAndTag(@Param("resName") String resName, @Param("tag") String tag);

    // @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %?1%")
    // List<Restaurant> findLikeName(String resName);
    
    // @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %?1%")
    // List<Restaurant> findByTag(String tag);
}
