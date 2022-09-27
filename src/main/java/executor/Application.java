package executor;

import executor.model.Scenario;
import executor.model.Step;
import executor.service.impl.ScenarioExecutorService;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Application {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    public static void main(String[] args) {
        // create Scenario
        Step step1 = new Step("clickCss", "body > ul > li:nth-child(1) > a");
        Step step2 = new Step("sleep", "5");
        Step step3 = new Step("clickXpath", "/html/body/p");
        Scenario scenario1 = new Scenario("test scenario 1", "http://info.cern.ch",
                Arrays.asList(step1, step2, step3));

        // create WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--crash-dumps-dir=/tmp");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver webDriver = new ChromeDriver(options);

        // create ScenarioExecutorService and execute it
        ScenarioExecutorService scenarioExecutorService = new ScenarioExecutorService();
        scenarioExecutorService.execute(scenario1, webDriver);
    }
}
