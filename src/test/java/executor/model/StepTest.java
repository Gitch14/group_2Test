package executor.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StepTest {
    String action = "sleep";
    String value = "6000:15000";

    @Test
    public void checkConstructor() {
        String actual = "sleep";
        Step test = new Step();
        test.setAction(action);
        test.setValue(value);
        String result = test.getAction();

        assertEquals(actual, result);
    }

    @Test
    public void checkDefaultConstructor() {
        Step step = new Step();
        assertNull(step.getAction());
        assertNull(step.getValue());
    }
}
