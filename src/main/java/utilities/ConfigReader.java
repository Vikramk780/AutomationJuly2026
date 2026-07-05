package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private Properties prop;

    public ConfigReader() throws IOException {

        prop = new Properties();

        FileInputStream file =
                new FileInputStream(
                        System.getProperty("user.dir")
                                + "/src/test/resources/config/config.properties");

        prop.load(file);
    }

     public String getBrowser(){
       return prop.getProperty("browser");
             }

             public String getUsername(){
        return prop.getProperty("username");
             }
             public String getPassword(){
        return prop.getProperty("password");
             }

public String getUrl(){
        return prop.getProperty("url");
}



}
