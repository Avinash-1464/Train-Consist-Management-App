import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//class Bogie {
//    String name;
//    int capacity;
//
//    Bogie(String name, int capacity) {
//        this.name = name;
//        this.capacity = capacity;
//    }
//
//    @Override
//    public String toString() {
//        return name + " (" + capacity + ")";
//    }
//}

public class TrainConsistAppTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 36));
        bogies.add(new Bogie("Economy", 24));
        bogies.add(new Bogie("Luxury", 90));
        return bogies;
    }

    @Test
    void testFilterCapacityGreaterOrEqual50() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity >= 50)
                .collect(Collectors.toList());

        List<Bogie> expected = new ArrayList<>();
        expected.add(new Bogie("Sleeper", 72));
        expected.add(new Bogie("AC Chair", 54));
        expected.add(new Bogie("Luxury", 90));

        assertEquals(expected.toString(), filtered.toString());
    }

    @Test
    void testFilterCapacityLessThan50() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity < 50)
                .collect(Collectors.toList());

        List<Bogie> expected = new ArrayList<>();
        expected.add(new Bogie("First Class", 36));
        expected.add(new Bogie("Economy", 24));

        assertEquals(expected.toString(), filtered.toString());
    }

    @Test
    void testFilterCapacityBetween40And80() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity >= 40 && b.capacity <= 80)
                .collect(Collectors.toList());

        List<Bogie> expected = new ArrayList<>();
        expected.add(new Bogie("Sleeper", 72));
        expected.add(new Bogie("AC Chair", 54));

        assertEquals(expected.toString(), filtered.toString());
    }

    @Test
    void testFilterCapacityGreaterThan100() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        List<Bogie> expected = new ArrayList<>();

        assertEquals(expected.toString(), filtered.toString());
    }
}