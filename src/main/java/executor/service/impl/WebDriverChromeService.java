package executor.service.impl;

import executor.util.Property;
import executor.service.WebDriverInitializerService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebDriverChromeService implements WebDriverInitializerService {

    private Property property;

    @Autowired
    public WebDriverChromeService(Property property) {
        this.property = property;
    }

    public WebDriverChromeService() {

    }

    static {
        String chromedriverPath = "src/main/resources/chromedriver";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            chromedriverPath += ".exe";
        }
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
    }

    @Override
    public WebDriver create() {
        property.connect();
        ChromeOptions options = new ChromeOptions();

        options.addArguments(property.connect());
        return new ChromeDriver(options);
    }
}
