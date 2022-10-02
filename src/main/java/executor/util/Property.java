package executor.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Property {
    final static Logger logger = LogManager.getLogger(Property.class);

    @Value("${ProxyConfigHolder.ProxyCredentials.username}")
    private String username;

    @Value("${ProxyConfigHolder.ProxyCredentials.password}")
    private String password;

    @Value("${ProxyConfigHolder.ProxyNetworkConfig.hostname}")
    private String hostname;

    @Value("${ProxyConfigHolder.ProxyNetworkConfig.port}")
    private String port;

    @Value("${WebDriverConfig.webDriverExecutable}")
    private String webDriverExecutable;

    @Value("${WebDriverConfig.userAgent}")
    private String userAgent;

    @Value("${WebDriverConfig.pageLoadTimeout}")
    private String pageLoadTimeout;

    @Value("${WebDriverConfig.implicitlyWait}")
    private String implicitlyWait;

    public Property() {

    }

    public List<String> connect() {

        logger.info(new StringBuilder()
                .append("username: ")
                .append(username)
                .append(", port: ")
                .append(port)
                .append(", webDriverExecutable: ")
                .append(webDriverExecutable)
                .append(", userAgent: ")
                .append(userAgent)
                .append(", pageLoadTimeout: ")
                .append(pageLoadTimeout)
                .append(", implicitlyWait: ").toString());

        return Arrays.asList(username, password, hostname, port, webDriverExecutable,
                userAgent, pageLoadTimeout, implicitlyWait);
    }

    @Override
    public String toString() {
        return connect().toString();
    }
}
