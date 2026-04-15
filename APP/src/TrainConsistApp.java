import java.util.*;
import java.util.stream.*;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {

    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36),
                new Bogie("Sleeper", 80)
        );

        long loopTime = measureLoopTime(bogies);
        long streamTime = measureStreamTime(bogies);

        System.out.println("Loop Time: " + loopTime);
        System.out.println("Stream Time: " + streamTime);
    }
}