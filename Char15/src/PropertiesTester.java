import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTester {

    public static void print(Properties properties) {
        Set<Object> keys = properties.keySet();
        Iterator<Object> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = properties.getProperty(key);
            System.out.println(key + " = " + value);
        }

    }

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream=PropertiesTester.class.getResourceAsStream("myapp.properties");
        print(properties);
        properties.load(inputStream);
        inputStream.close();
        print(properties);

        properties=System.getProperties();
        print(properties);
    }

}
