import java.util.*;

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment");
            }
            this.cargo = cargo;
        } catch (CargoSafetyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Assignment attempted");
        }
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        b2.assignCargo("Coal");

        System.out.println(b1.getCargo());
        System.out.println(b2.getCargo());
    }
}