package executor.factory.impl;


import executor.factory.Factory;
import executor.service.impl.StepExecutionServiceSleep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

public class DIFactory implements Factory {

    final static Logger logger = LogManager.getLogger(DIFactory.class);

    private static final Map<Class<?>, Object> mapOfSingletons = new HashMap<>();

    @Override
    public <T> T getInstance(Class<T> clazz) {

        if (StepExecutionServiceSleep.class.isAssignableFrom(clazz)) {
            return (T) mapOfSingletons.getOrDefault(clazz, StepExecutionServiceSleep.getInstance());
        }

/*

    //TODO use and refactor this when all classes will be created (and facade)

        if (StepExecutionServiceClickCss.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new StepExecutionServiceClickCss());
        }

        if (StepExecutionServiceClickXpath.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new StepExecutionServiceClickXpath());
        }

        if (ScenarioExecutor.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ScenarioExecutor());
        }

        if (ProxySourcesClient.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ProxySourcesClient());
        }

        if (ExecutionService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ExecutionService());
        }

        if (ParallelFlowExecutorService.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ParallelFlowExecutorService());
        }

        if (ScenarioSourceListener.class.isAssignableFrom(clazz)) {
            return (T)mapOfSingletons.getOrDefault(clazz, new ScenarioSourceListener());
        }

*/

        throw new RuntimeException("Please, check class name before creation in factory");
    }

/*

    private Object getProxy(Class clazz) {
        return Proxy
                .newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        logger.info(Arrays.toString(clazz.getInterfaces()));

                        for (Constructor<?> constructor : clazz.getConstructors()) {
                            logger.info((Arrays.toString(constructor.getParameters())));
                        }

                        for (Parameter par : method.getParameters()) {
                            logger.info((par.getType() + " " + par.getName()));
                        }

                        return null;
                    }
                });
    }

*/

}

