public class TrainConsistApp {

    public static boolean searchBogie(String[] bogies, String key) {
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String b : bogies) {
            if (b.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101", "BG205", "BG309"};

        System.out.println(searchBogie(bogies, "BG205"));
    }
}