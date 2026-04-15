import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        TrainConsistApp.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, input);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        TrainConsistApp.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        TrainConsistApp.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        TrainConsistApp.sortBogieNames(input);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, input);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        TrainConsistApp.sortBogieNames(input);
        assertArrayEquals(new String[]{"Sleeper"}, input);
    }
}