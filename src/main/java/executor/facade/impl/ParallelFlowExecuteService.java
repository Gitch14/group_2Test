package executor.facade.impl;

import executor.facade.ParallelFlowExecute;
import executor.model.ThreadPoolConfig;
import executor.util.Property;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParallelFlowExecuteService implements ParallelFlowExecute {
    private static final ParallelFlowExecuteService INSTANCE;
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    protected ParallelFlowExecuteService() {  }

    static {
        ThreadPoolConfig poolConfig = Property.readThreadPoolConfig();
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
                poolConfig.getCorePoolSize(),
                poolConfig.getCorePoolSize(),
                poolConfig.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );
        INSTANCE = new ParallelFlowExecuteService();
    }

    public static ParallelFlowExecuteService getInstance() {
        return INSTANCE;
    }

    @Override
    public synchronized void parallelExecute(Runnable task) {
        this.parallelExecute(task, null);
    }

    protected void parallelExecute(Runnable task, Runnable testCallBack) {
        if (testCallBack != null) {
            testCallBack.run();
        } else {
            THREAD_POOL_EXECUTOR.submit(task);
        }
    }
}