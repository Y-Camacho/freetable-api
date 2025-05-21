package cat.ycamacho.freetable_api.exceptions;

public class RestaurantCapacityExceededException extends RuntimeException {
    public RestaurantCapacityExceededException(String message) {
        super(message);
    }
}
