package executor.service;

import executor.model.Scenario;
import org.openqa.selenium.WebDriver;

public interface ExecutorService
{
    void execute(Scenario scenario, WebDriver webDriver);
}
