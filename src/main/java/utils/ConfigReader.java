package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    //This method is used to load the properties from config.properties file
    public Properties init_property() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop;
    }
}
