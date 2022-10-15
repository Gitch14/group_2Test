package executor.service.impl;

import executor.service.WebDriverInitializerService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebDriverChromeService implements WebDriverInitializerService {

    @Value("${ProxyConfigHolder.ProxyCredentials.username}")
    private String username;

    @Value("${ProxyConfigHolder.ProxyCredentials.password}")
    private String password;

    @Value("${ProxyConfigHolder.ProxyNetworkConfig.hostname}")
    private String hostname;

    @Value("${ProxyConfigHolder.ProxyNetworkConfig.port}")
    private String port;

    @Value("${WebDriverConfig.webDriverExecutable}")
    private String webDriverExecutable;

    @Value("${WebDriverConfig.userAgent}")
    private String userAgent;

    @Value("${WebDriverConfig.pageLoadTimeout}")
    private String pageLoadTimeout;

    @Value("${WebDriverConfig.implicitlyWait}")
    private String implicitlyWait;

    public WebDriverChromeService() {

    }

    static {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver create() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(username, password, hostname, port,
                webDriverExecutable, userAgent, pageLoadTimeout, implicitlyWait);
        return new ChromeDriver(options);
    }
}
