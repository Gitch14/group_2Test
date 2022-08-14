package executor.service.StepExecution;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public interface Sleep {
    default String getStepAction() {
        return "Sleep";
    }

    default void step(WebDriver webDriver, Step step) throws InterruptedException {
        TimeUnit.SECONDS.sleep(Long.parseLong(step.getValue()));
    }
}
