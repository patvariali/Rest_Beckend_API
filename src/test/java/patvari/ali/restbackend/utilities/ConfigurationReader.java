package patvari.ali.restbackend.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();



    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/configurations.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
