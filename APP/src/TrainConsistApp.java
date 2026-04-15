public class TrainConsistApp {

    public static boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println(linearSearch(bogies, "BG309"));
        System.out.println(linearSearch(bogies, "BG999"));
    }
}