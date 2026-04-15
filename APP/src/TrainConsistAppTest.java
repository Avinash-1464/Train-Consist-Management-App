import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    private List<Bogie> sampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36),
                new Bogie("Sleeper", 80)
        );
    }

    private List<Bogie> largeDataset() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Sleeper", i % 100));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = TrainConsistApp.filterWithLoop(sampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = TrainConsistApp.filterWithStream(sampleBogies());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = TrainConsistApp.filterWithLoop(sampleBogies());
        List<Bogie> streamResult = TrainConsistApp.filterWithStream(sampleBogies());
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long loopTime = TrainConsistApp.measureLoopTime(sampleBogies());
        long streamTime = TrainConsistApp.measureStreamTime(sampleBogies());
        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> data = largeDataset();
        List<Bogie> result = TrainConsistApp.filterWithStream(data);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }
}