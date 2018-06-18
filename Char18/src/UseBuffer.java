import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class UseBuffer {
    public static void main(String[] args) throws IOException {

        final int SIZE = 1024;
        FileInputStream in = new FileInputStream("C:\\Workspace\\Idea\\BlueThinkPractice\\Char18\\src\\in.txt");
        FileOutputStream out = new FileOutputStream("C:\\Workspace\\Idea\\BlueThinkPractice\\Char18\\src\\out.txt");

        //创建字节数组缓冲区
        byte[] buff=new byte[SIZE];
        int len=in.read(buff);
        while (len != -1) {
            //把buff中的数据写到out.txt文件中
            out.write(buff,0,len);
            len=in.read(buff);
        }
        in.close();
        out.close();

        System.out.println(System.getProperty("file.encoding"));

        Charset charset=Charset.defaultCharset();
        System.out.println(charset);
    }
}
