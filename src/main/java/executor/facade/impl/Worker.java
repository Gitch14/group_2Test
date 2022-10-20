package executor.facade.impl;

import executor.service.impl.ProxySourcesClientService;
import executor.util.ObjectMapperUtil;

public class Worker implements Runnable{

    private ProxySourcesClientService proxy;
    private ObjectMapperUtil service;

    @Override
    public void run() {
       service.getObjectMapper();
       proxy.getProxy();
    }

    public ProxySourcesClientService getProxy() {
        return proxy;
    }

    public ObjectMapperUtil getService() {
        return service;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "proxy=" + proxy +
                ", service=" + service +
                '}';
    }
}
