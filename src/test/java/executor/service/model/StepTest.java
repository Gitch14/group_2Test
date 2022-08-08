package executor.service.model;

import executor.service.model.Step;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class StepTest {
    String action = "sleep";
    String value = "6000:15000";


        String actual = "sleep";
        Step test = new Step();
        test.setAction(action);
        test.setValue(value);
        String result = test.getAction();

        assertEquals(actual, result);
    }
}
