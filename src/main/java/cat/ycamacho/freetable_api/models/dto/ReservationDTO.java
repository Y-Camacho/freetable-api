package cat.ycamacho.freetable_api.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDTO {

    private int numDiners;
    private LocalDate date;
    private LocalTime hour;
    private String clientEmail;
    private String clientFullName;
    private String clientPhone;
    private int restaurantId;

    // Accesores
    public int getNumDiners() { return numDiners; }
    public void setNumDiners(int numDiners) { this.numDiners = numDiners; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHour() { return hour; }
    public void setHour(LocalTime hour) { this.hour = hour; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clietnEmail) { this.clientEmail = clietnEmail; }

    public String getClientFullName() { return clientFullName; }
    public void setClientFullName(String clientFullName) { this.clientFullName = clientFullName; }

    public String getClientPhone() { return clientPhone; }
    public void setClientPhone(String clientPhone) { this.clientPhone = clientPhone; }

    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    @Override
    public String toString() {
        return "ReservationDTO: {numDiners=" + numDiners + ", date=" + date + ", hour=" + hour + ", clientEmail="
                + clientEmail + ", clientFullName=" + clientFullName + ", clientPhone=" + clientPhone
                + ", restaurantId=" + restaurantId + "}";
    }

    
    
}
