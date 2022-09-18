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
import java.util.Random;

public class ProxySourcesClientService implements ProxySourcesClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ProxyConfigHolder getProxy() {
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

        Random random = new Random();
        int randNetwork = random.nextInt(network.size());
        int randCredential = random.nextInt(credentials.size());

        return new ProxyConfigHolder(network.get(randNetwork), credentials.get(randCredential));
    }
}
