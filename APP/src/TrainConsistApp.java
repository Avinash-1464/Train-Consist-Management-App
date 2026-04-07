import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    String name;
    int capacity;
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 54));
        passengerBogies.add(new Bogie("First Class", 36));
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("Passenger bogies sorted by capacity: " + passengerBogies);
    }
}