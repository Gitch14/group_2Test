package executor.service.StepExecutionService;

import executor.service.StepExecution.Property;
import executor.service.StepExecution.WebDriverChrome;
import executor.service.StepExecution.WebDriverInitializer;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WebDriverChromeTest {
    Property property = new Property();

    @Test
    public void TestProperty() {
        property.connect();
    List<String> actual;
    actual = Arrays.asList("test1","test2","test3","test4","test5","test6","test7","test8");

         assertEquals(property.connect(),actual);

    }

}
