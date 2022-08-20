package executor.factory;

import executor.factory.impl.DIFactory;
import executor.service.StepExecutionService;
import executor.service.impl.StepExecutionServiceSleep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DIFactoryTest {

    @DisplayName("JUnit test for creating instance")
    @Test
    public void shouldReturnSuccessIfCreateInstance() {
        DIFactory factory = new DIFactory();
        StepExecutionService testInstance = factory.getInstance(StepExecutionServiceSleep.class);
        assertNotNull(testInstance);
    }

    @DisplayName("JUnit test for creating instance which throws exception")
    @Test
    public void shouldThrowsExceptionOnCreatingWrongClass() {
        DIFactory factory = new DIFactory();
        Exception exception = assertThrows(RuntimeException.class, () -> factory.getInstance(Object.class));

        String expectedMessage = "Please, check class name before creation in factory";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}


