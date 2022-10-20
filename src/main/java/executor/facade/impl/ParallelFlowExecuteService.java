package executor.facade.impl;

import executor.facade.ParallelFlowExecute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class ParallelFlowExecuteService implements ParallelFlowExecute {

    @Value("${ThreadPoolConfig.corePoolSize}")
    private Integer corePoolSize;

    @Value("${ThreadPoolConfig.keepAliveTime}")
    private Integer keepAliveTime;

    public ParallelFlowExecuteService() {

    }

    public void parallelExecute(Runnable task) {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                    corePoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
            threadPoolExecutor.submit(new Worker());

    }
}