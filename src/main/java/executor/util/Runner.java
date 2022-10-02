package executor.util;

import executor.facade.impl.ExecutionServiceFacade;
import executor.service.impl.ScenarioExecutorService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.service.impl.WebDriverChromeService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Runner implements CommandLineRunner {

    private ScenarioExecutorService scenarioExecutorService;
    private WebDriverChromeService webDriverChromeService;
    private ScenarioSourceListenerService scenarioSourceListenerService;
    private ExecutionServiceFacade executionServiceFacade;

    @Autowired
    public Runner(ScenarioExecutorService scenarioExecutorService,
                  WebDriverChromeService webDriverChromeService,
                  ScenarioSourceListenerService scenarioSourceListenerService,
                  ExecutionServiceFacade executionServiceFacade) {
        this.scenarioExecutorService = scenarioExecutorService;
        this.webDriverChromeService = webDriverChromeService;
        this.scenarioSourceListenerService = scenarioSourceListenerService;
        this.executionServiceFacade = executionServiceFacade;
    }

    public Runner() {

    }

    @Override
    public void run(String[] args) {

        // get WebDriver
        WebDriver webDriver = webDriverChromeService.create();

        // execute ScenarioExecutorService
        executionServiceFacade.execute(webDriver, scenarioSourceListenerService, scenarioExecutorService);
    }

}
