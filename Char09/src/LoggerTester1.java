import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTester1 {
    public static void main(String[] args) {
        Logger myLogger= Logger.getLogger("myLogger");
        myLogger.setLevel(Level.WARNING);

        myLogger.info("这是一个普通提示信息");
        myLogger.warning("这是一个警告细信息");
        myLogger.severe("这是一个严重错误信息");
    }
}
