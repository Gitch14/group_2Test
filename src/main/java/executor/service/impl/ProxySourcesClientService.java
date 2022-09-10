package executor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.ProxyConfigHolder;
import executor.model.ProxyCredentials;
import executor.model.ProxyNetworkConfig;
import executor.service.ProxySourcesClient;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProxySourcesClientService implements ProxySourcesClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Queue<ProxyConfigHolder> getProxy() {
        List<ProxyCredentials> credentials = new ArrayList<>();
        List<ProxyNetworkConfig> network = new ArrayList<>();
        try {
            URL credentURI = this.getClass().getClassLoader().getResource("ProxyCredentials.json");
            URL networkURI = this.getClass().getClassLoader().getResource("ProxyNetwork.json");

            if (credentURI != null && networkURI != null) {
                File file = new File(credentURI.toURI());
                credentials.addAll(List.of(objectMapper.readValue(file, ProxyCredentials[].class)));
                file = new File(networkURI.toURI());
                network.addAll(List.of(objectMapper.readValue(file, ProxyNetworkConfig[].class)));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Queue<ProxyConfigHolder> proxyConfigHolders = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < Math.max(credentials.size(), network.size()); i++) {
            ProxyNetworkConfig proxyNetworkConfig = network.size() > i ? network.get(i) : null;
            ProxyCredentials proxyCredentials =  credentials.size() > i ? credentials.get(i) : null;
            proxyConfigHolders.add(new ProxyConfigHolder(proxyNetworkConfig, proxyCredentials));
        }

        return proxyConfigHolders;
    }
}
