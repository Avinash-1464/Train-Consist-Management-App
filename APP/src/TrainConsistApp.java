import java.util.Arrays;

public class TrainConsistApp {

    public static String[] sortBogieNames(String[] names) {
        Arrays.sort(names);
        return names;
    }

    public static void main(String[] args) {
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        sortBogieNames(bogies);

        System.out.println(Arrays.toString(bogies));
    }
}