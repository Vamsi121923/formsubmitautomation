package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
    /*
    This method is used to get test data from the properties file
     */
    public static String getValueFromProperties(String input){
        String value = "";
        try{
            InputStream inputStream = new FileInputStream("src/test/resources/testdata.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            value = properties.getProperty(input);
        } catch (Exception e) {
        }
        return value;
    }
}
