import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfigFactory {
    private static final GlobalConfigFactory INSTANCE=new GlobalConfigFactory();
    private Properties properties=new Properties();

    private GlobalConfigFactory(){
        try {
            //加载配置信息
            InputStream in=getClass().getResourceAsStream("myapp.properties");
            properties.load(in);
            in.close();
        }catch (IOException e) {
            throw new RuntimeException("加载配置信息失败");
        }
    }

    //静态工厂方法
    public static GlobalConfigFactory getInstance(){
        return INSTANCE;
    }

    public Properties getProperties(){
        return properties;
    }
}
