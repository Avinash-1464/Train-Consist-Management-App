import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    // -------------------------------
    // Helper Methods (UC10)
    // -------------------------------

    private List<Bogie> createBogiesMultiple() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36)
        );
    }

    private List<Bogie> createBogiesSingle() {
        return Collections.singletonList(new Bogie("Sleeper", 72));
    }

    private List<Bogie> createBogiesEmpty() {
        return Collections.emptyList();
    }

    // -------------------------------
    // UC10: Stream & Reduce Test Cases
    // -------------------------------

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(162, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(162, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = createBogiesSingle();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = createBogiesEmpty();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogiesMultiple();
        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();
        assertEquals(Arrays.asList(72, 54, 36), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        int manualSum = 0;
        for (Bogie b : bogies) {
            manualSum += b.getCapacity();
        }

        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(createBogiesMultiple());
        List<Bogie> before = new ArrayList<>(bogies);

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(before, bogies);
    }

    // -------------------------------
    // UC11: REGEX VALIDATION TEST CASES
    // -------------------------------

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistApp.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistApp.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistApp.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET123"));
        assertFalse(TrainConsistApp.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        equals(TrainConsistApp.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistApp.isValidTrainId(""));
        assertFalse(TrainConsistApp.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistApp.isValidTrainId("TRN-1234X"));
        assertFalse(TrainConsistApp.isValidCargoCode("PET-ABC"));
    }
}