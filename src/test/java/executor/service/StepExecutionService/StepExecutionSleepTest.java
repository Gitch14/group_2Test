package executor.service.StepExecutionService;

import executor.service.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

class StepExecutionSleepTest {
    private static final String STEP_EXECUTION_EXPECTED = "sleep";

    private StepExecution stepExecution;
    private Step step;

    @BeforeEach
    void setUp() {
        stepExecution = new StepExecutionSleep();
        step = new Step(STEP_EXECUTION_EXPECTED, "5");
    }

    @Test
    void getStepAction() {
        assertEquals(STEP_EXECUTION_EXPECTED, stepExecution.getStepAction(), "Step action wrong for Sleep");
    }

    @Test
    void step() throws InterruptedException {
        int expected = Integer.parseInt(step.getValue());

        long start = System.currentTimeMillis();
        stepExecution.step(null, step);
        long finish = System.currentTimeMillis();
        int actual = (int) (finish-start)/ 1000;
        assertEquals(expected, actual, "Sleep works incorrectly");
    }
}