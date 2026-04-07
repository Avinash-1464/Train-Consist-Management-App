import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

//class Bogie {
//    String name;
//    int capacity;
//
//    Bogie(String name, int capacity) {
//        this.name = name;
//        this.capacity = capacity;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(obj == null || getClass() != obj.getClass()) return false;
//        Bogie bogie = (Bogie) obj;
//        return capacity == bogie.capacity && Objects.equals(name, bogie.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, capacity);
//    }
//
//    @Override
//    public String toString() {
//        return name + " (" + capacity + ")";
//    }
//}

public class TrainConsistAppTest {

    private List<Bogie> createSampleBogies() {
        return new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 50)
        ));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, grouped.size());  // Sleeper, AC Chair, First Class
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();

        Map<String, List<Bogie>> grouped = emptyList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> singleCategory = Collections.singletonList(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = singleCategory.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(1, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        Set<String> expectedKeys = new HashSet<>(Arrays.asList("Sleeper", "AC Chair", "First Class"));
        assertEquals(expectedKeys, grouped.keySet());
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createSampleBogies();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createSampleBogies();
        List<Bogie> copyBefore = new ArrayList<>(bogies);

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(copyBefore, bogies);
    }
}