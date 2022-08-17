package executor.service;

import executor.service.model.Step;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StepTest {
    private final String expected = "sleep";
    private final String value = "6000:15000";

    @Test
    public void checkFields() {

        Step test = new Step();
        test.setAction(expected);
        test.setValue(value);
        String result = test.getAction();

        assertEquals(expected, result);
    }
}
