import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistAppTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        b.assignCargo("Coal");
        assertEquals("Coal", b.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"));
    }
}