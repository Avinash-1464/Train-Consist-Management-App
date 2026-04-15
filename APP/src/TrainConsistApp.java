import java.util.Arrays;

public class TrainConsistApp {

    public static boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = arr[mid].compareTo(key);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        System.out.println(binarySearch(bogies, "BG205"));
        System.out.println(binarySearch(bogies, "BG999"));
    }
}