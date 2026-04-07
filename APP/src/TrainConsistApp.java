import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("=== Train Consist Management App: Filter Passenger Bogies ===");
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 54));
        passengerBogies.add(new Bogie("First Class", 36));

        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity >= 50)
                .collect(Collectors.toList());

        System.out.println("Passenger bogies with capacity >= 50: " + highCapacityBogies);
    }
}