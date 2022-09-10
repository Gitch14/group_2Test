package executor.service;

import executor.model.ProxyConfigHolder;

import java.util.Queue;

public interface ProxySourcesClient {
    Queue<ProxyConfigHolder> getProxy();
}
