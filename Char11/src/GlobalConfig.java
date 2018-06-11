import java.util.Properties;

//为每一个线程分配一个实例
public class GlobalConfig {
    private static final ThreadLocal<GlobalConfig> threadConfig=new ThreadLocal<GlobalConfig>();

    private Properties properties=null;
    private GlobalConfig(){
        /*try{
            InputStream in=getClass().getResourceAsStream("myapp.properties");

        }catch (IOException e){
            throw new RuntimeException("加载配置信息失败");
        }*/
    }

    public static GlobalConfig getInstance(){
        GlobalConfig config=threadConfig.get();
        if(config==null){
            config=new GlobalConfig();
            threadConfig.set(config);
        }
        return  config;
    }

    public Properties getProperties() {
        return properties;
    }
}
