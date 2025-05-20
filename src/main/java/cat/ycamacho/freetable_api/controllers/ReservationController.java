package cat.ycamacho.freetable_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.ycamacho.freetable_api.models.Admin;
import cat.ycamacho.freetable_api.models.Client;
import cat.ycamacho.freetable_api.models.Reservation;
import cat.ycamacho.freetable_api.models.Restaurant;
import cat.ycamacho.freetable_api.models.dto.ReservationDTO;
import cat.ycamacho.freetable_api.repositories.ClientRespository;
import cat.ycamacho.freetable_api.repositories.ReservationReposiroty;
import cat.ycamacho.freetable_api.repositories.RestaurantRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationReposiroty _ReservationReposiroty;

    @Autowired
    ClientRespository _ClientRespository;

    @Autowired
    RestaurantRepository _RestaurantRepository;

    @GetMapping
    public List<Reservation> getReservations(@RequestParam(required = false) Integer resId, @RequestParam(required = false) String clientEmail) {
        return _ReservationReposiroty.search(resId, clientEmail);
    }

    @GetMapping("/{bookingId}")
    public Reservation getReservation(@PathVariable Long bookingId ) {
        return _ReservationReposiroty.findById(bookingId).orElseThrow();
    }
    
    @PostMapping
    public Reservation postNewReservation(@RequestBody ReservationDTO booking) {

        Admin admin = new Admin("super@gmail.com");

        Restaurant restaurant = _RestaurantRepository.findById(booking.getRestaurantId()).orElseThrow();

        Optional<Client> optClient = _ClientRespository.findById(booking.getClientEmail());
        Client client = new Client();
        if(optClient.isPresent()) {
            client = optClient.get();
        } else {
            client.setAdmin(admin);
            client.setEmail(booking.getClientEmail());
            client.setName(booking.getClientFullName());
            client.setNumberPhone(booking.getClientPhone());
            _ClientRespository.save(client);
        }

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setFromClientName(booking.getClientFullName());
        reservation.setRestaurant(restaurant);
        reservation.setNumDiners((booking.getNumDiners()));
        reservation.setDate(booking.getDate());
        reservation.setHour(booking.getHour());
        _ReservationReposiroty.save(reservation);

        return reservation;
    }

    @PutMapping("/{bookingId}")
    public Reservation putReservation(@RequestBody ReservationDTO restBody, @PathVariable String bookingId) {
        
        Reservation reservation = _ReservationReposiroty.findById(Long.parseLong(bookingId)).orElseThrow();;
        reservation.setFromClientName(restBody.getClientFullName());
        reservation.setNumDiners(restBody.getNumDiners());
        reservation.setId(Long.parseLong(bookingId));

        _ReservationReposiroty.save(reservation);
        
        return reservation;
    }

    @DeleteMapping("/{bookingId}")
    public Map<String, String> deleteReservation(@PathVariable String bookingId) {
        Map<String, String> respMap = new HashMap<String, String>();
        Reservation reservation = _ReservationReposiroty.findById(Long.parseLong(bookingId)).orElseThrow();

        _ReservationReposiroty.delete(reservation);
        
        respMap.put("reservation_id", bookingId);
        respMap.put("message", "Reserva eliminada");

        return respMap;
    }

}