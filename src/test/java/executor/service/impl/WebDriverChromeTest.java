package executor.service.impl;

import executor.util.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WebDriverChromeTest {

    @Autowired
    Property property;

    @Test
    public void TestProperty() {

        List<String> actual;
        actual = Arrays.asList("test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8");

        assertEquals(property.connect(), actual);

    }

}
