import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) throws InvalidCapacityException {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("AC Chair", 54);
        PassengerBogie b3 = new PassengerBogie("First Class", 36);

        System.out.println(b1.getType() + " " + b1.getCapacity());
        System.out.println(b2.getType() + " " + b2.getCapacity());
        System.out.println(b3.getType() + " " + b3.getCapacity());
    }
}