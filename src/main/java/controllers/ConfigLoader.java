package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

  private static final String CONFIG_DIR = "testconfig/";
  private static final String CONFIG_TESTRUN = CONFIG_DIR + "testrun.properties";

  public static void loadUserConfigToSystemProperties() {
    Properties allUserProperties = new Properties();

    try {
      allUserProperties.load(getResourceData(CONFIG_TESTRUN));
      saveUserPropsToSystemProperties(allUserProperties);

    } catch (IOException | NullPointerException e) {
      throw new Error("Cannot load properties file due to: " + e.getMessage());
    }
  }

  private static InputStream getResourceData(String configFile) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
  }

  private static void saveUserPropsToSystemProperties(Properties allUserProperties) {
    allUserProperties.forEach(
        (key, value) -> {
          if ((System.getProperty((String) key) == null)
              || (System.getProperty((String) key)).isEmpty()) {
            System.setProperty((String) key, (String) value);
          }
        });
  }
}
