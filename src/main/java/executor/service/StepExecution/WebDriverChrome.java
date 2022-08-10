package executor.service.StepExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverChrome implements WebDriverInitializer{

    Property property = new Property();

    @Override
    public WebDriver create() {
        property.connect();
        ChromeOptions options = new ChromeOptions();

        return new ChromeDriver();
    }
}
