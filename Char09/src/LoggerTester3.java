import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerTester3 {

    static class MyFormatter extends Formatter {
        public String format(LogRecord record){
            return "<" + record.getLevel() + ">:" + record.getMessage() + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        //得到一个日志记录器对象
        Logger myLogger = Logger.getLogger("myLogger");

        FileHandler fileHandler = new FileHandler("F:\\bulethink\\project\\test.log");

        //设置自定义的日志输出格式
        fileHandler.setFormatter(new MyFormatter());

        myLogger.addHandler(fileHandler);

        myLogger.info("这是一条普通提示信息");
        myLogger.warning("这是一条警告提示信息");

    }
}
