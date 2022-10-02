package executor.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class StepTest {
    String action = "sleep";
    String value = "5000";

    @Test
    public void checkConstructor() {
        String actual = "sleep";
        Step test = new Step();
        test.setAction(action);
        test.setValue(value);
        String result = test.getAction();

        Assertions.assertEquals(actual, result);
    }

    @Test
    public void checkDefaultConstructor() {
        Step step = new Step();
        assertNull(step.getAction());
        assertNull(step.getValue());
    }
}
