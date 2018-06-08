import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTester2 {
    public static void main(String[] args) throws IOException {
        Logger myLogger=Logger.getLogger("myLogger");

        FileHandler fileHandler=new FileHandler("F:\\bulethink\\project\\test.log");
        fileHandler.setLevel(Level.INFO);
        myLogger.addHandler(fileHandler);

        myLogger.info("这是一条普通提示信息");
        myLogger.warning("这是一条警告信息");
        myLogger.severe("这是一条严重错误信息");
    }
}
