package cat.ycamacho.freetable_api.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numDiners;
    private LocalDate date;
    private LocalTime hour;
    private String fromClientName;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_email")
    private Client client;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public int getNumDiners() { return numDiners; }
    public void setNumDiners(int numDiners) { this.numDiners = numDiners; }

    public String getFromClientName() { return fromClientName; }
    public void setFromClientName(String fromClientName) { this.fromClientName = fromClientName; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHour() { return hour; }
    public void setHour(LocalTime hour) { this.hour = hour; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    @Override
    public String toString() {
        return "Reservation: {id=" + id + ", numDiners=" + numDiners + ", date=" + date + ", hour=" + hour
                + ", fromClientName=" + fromClientName + ", restaurant=" + restaurant + ", client=" + client + "}";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservation other = (Reservation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
