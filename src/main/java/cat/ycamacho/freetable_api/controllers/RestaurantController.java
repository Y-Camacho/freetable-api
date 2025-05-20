package cat.ycamacho.freetable_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.ycamacho.freetable_api.models.Admin;
import cat.ycamacho.freetable_api.models.Restaurant;
import cat.ycamacho.freetable_api.repositories.ReservationReposiroty;
import cat.ycamacho.freetable_api.repositories.RestaurantRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository _RestaurantRepository;

    @Autowired 
    private ReservationReposiroty _ReservationReposiroty;

    public RestaurantController(){ }

    @GetMapping
    public List<Restaurant> getRestaurants(
            @RequestParam(required = false) String resName,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) Integer limit) {

        if (resName != null && resName.isEmpty()) resName = null;
        if (tag != null && tag.isEmpty()) tag = null;

        // Si no se especifica el límite, se usa Integer.MAX_VALUE
        int recordLimit = (limit != null && limit > 0) ? limit : Integer.MAX_VALUE;

        Pageable pageable = PageRequest.of(0, recordLimit);

        return _RestaurantRepository.findByNameAndTag(resName, tag, pageable);
    }


    @GetMapping("/{resId}")
    public Restaurant getRestaurantById(@PathVariable String resId) {
        return _RestaurantRepository.findById(Integer.parseInt(resId)).orElseThrow();
    }

    @PostMapping
    public Restaurant postRestaurant(@RequestBody Restaurant restBody) {
        Restaurant restaurant = restBody;
        Admin admin = new Admin("super@gmail.com");
        restaurant.setAdmin(admin);
        restaurant.testTags();

        _RestaurantRepository.save(restaurant);
        
        return restaurant;
    }

    @PutMapping("/{resId}")
    public Restaurant putRestaurant(@RequestBody Restaurant restBody, @PathVariable String resId) {
        
        Restaurant restaurant = _RestaurantRepository.findById(Integer.parseInt(resId)).orElseThrow();;
        restaurant = restBody;
        restaurant.setId(Integer.parseInt(resId));
        restaurant.testTags();

        _RestaurantRepository.save(restaurant);
        
        return restaurant;
    }
    
    @DeleteMapping("/{resId}")
    public Map<String, String> deleteRestaurant(@PathVariable String resId) {
        Map<String, String> respMap = new HashMap<String, String>();
        Restaurant restaurant = _RestaurantRepository.findById(Integer.parseInt(resId)).orElseThrow();

        _ReservationReposiroty.reremoveByIdRestaurant(resId);
        _RestaurantRepository.delete(restaurant);
        
        respMap.put("restaurant_id", resId);
        respMap.put("message", "Restaurante eliminado");

        return respMap;
    }
    
}