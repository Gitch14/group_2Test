package executor.factory.impl;

import executor.facade.impl.ParallelFlowExecuteService;
import executor.factory.Factory;
import executor.service.impl.*;
import java.util.HashMap;
import java.util.Map;

public class DIFactory implements Factory {

    private static final Map<Class<?>, Object> mapOfSingletons = new HashMap<>();

    @Override
    public <T> T getInstance(Class<T> clazz) {

        if (StepExecutionServiceSleep.class.isAssignableFrom(clazz)) {
            return (T) mapOfSingletons.getOrDefault(clazz, StepExecutionServiceSleep.getInstance());
        }

        if (StepExecutionServiceClickCss.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, StepExecutionServiceClickCss.getInstance());
        }

        if (StepExecutionClickXpath.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, StepExecutionClickXpath.getInstance());
        }

        if (ScenarioExecutorService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ScenarioExecutorService());
        }

        if (ProxySourcesClientService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ProxySourcesClientService());
        }

        if (ScenarioExecutorService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ScenarioExecutorService());
        }

        if (ParallelFlowExecuteService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, ParallelFlowExecuteService.getInstance());
        }

        if (ScenarioSourceListenerService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ScenarioExecutorService());
        }

        throw new RuntimeException("Please, check class name before creation in factory");
    }

}

