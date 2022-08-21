package executor.util;

<<<<<<< HEAD
=======
import org.apache.log4j.Logger;

>>>>>>> 0798927ab789ce30b3cc791e9a7bdf49d0ea351e
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Property {
<<<<<<< HEAD

=======
final static Logger logger = Logger.getLogger(Property.class);
>>>>>>> 0798927ab789ce30b3cc791e9a7bdf49d0ea351e
    Properties property = new Properties();


        public List connect() {
            List<String> list = null;
            try (FileInputStream file = new FileInputStream("src/main/resources/settings.properties")) {
                property.load(file);

                String username = property.getProperty("ProxyConfigHolder.ProxyCredentials.username");
                String password = property.getProperty("ProxyConfigHolder.ProxyCredentials.password");
                String hostname = property.getProperty("ProxyConfigHolder.ProxyNetworkConfig.hostname");
                String port = property.getProperty("ProxyConfigHolder.ProxyNetworkConfig.port");
                String webDriverExecutable = property.getProperty("WebDriverConfig.webDriverExecutable");
                String userAgent = property.getProperty("WebDriverConfig.userAgent");
                String pageLoadTimeout = property.getProperty("WebDriverConfig.pageLoadTimeout");
                String implicitlyWait = property.getProperty("WebDriverConfig.implicitlyWait");

<<<<<<< HEAD

                System.out.println("username: " + username
=======
                logger.info(
                        "username: " + username
>>>>>>> 0798927ab789ce30b3cc791e9a7bdf49d0ea351e
                        + ", password: " + password
                        + ", host: " + hostname
                        + ", port: " + port
                        + ", webDriverExecutable: " + webDriverExecutable
                        + ", userAgent: " + userAgent
                        + ", pageLoadTimeout: " + pageLoadTimeout
                        + ", implicitlyWait: " + implicitlyWait);
                list = new ArrayList<>();
                list = Arrays.asList(username, password, hostname, port, webDriverExecutable, userAgent, pageLoadTimeout, implicitlyWait);


            } catch (
                    IOException e) {
                System.err.println("Error file not found");
            }
            return list;
        }

    @Override
    public String toString() {
        return "Property{" +
                "property=" + property +
                '}';
    }
}
