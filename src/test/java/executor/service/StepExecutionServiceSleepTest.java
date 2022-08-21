package executor.service;

import executor.service.impl.StepExecutionServiceSleep;
import executor.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepExecutionServiceSleepTest {
    private static final String STEP_EXECUTION_EXPECTED = "sleep";

    private StepExecutionService stepExecutionService;
    private Step step;

    @BeforeEach
    void setUp() {
        stepExecutionService = new StepExecutionServiceSleep();
        step = new Step(STEP_EXECUTION_EXPECTED, "5");
    }

    @Test
    void getStepAction() {
        assertEquals(STEP_EXECUTION_EXPECTED, stepExecutionService.getStepAction(), "Step action wrong for Sleep");
    }

    @Test
    void step() throws InterruptedException {
        int expected = Integer.parseInt(step.getValue());

        long start = System.currentTimeMillis();
        stepExecutionService.step(null, step);
        long finish = System.currentTimeMillis();
        int actual = (int) (finish-start)/ 1000;
        assertEquals(expected, actual, "Sleep works incorrectly");
    }
}
