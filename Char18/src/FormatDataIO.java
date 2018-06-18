import java.io.*;

//装饰模式
public class FormatDataIO{

    public static void main(String[] args) throws IOException{
        FileOutputStream out1=new FileOutputStream("C:\\Workspace\\Idea\\BlueThinkPractice\\Char18\\src\\text.txt");
        //装饰文件输出流
        BufferedOutputStream out2=new BufferedOutputStream(out1);
        //装饰带缓冲输出流
        DataOutputStream out=new DataOutputStream(out2);

        out.writeByte(-12);
        out.writeLong(12);
        out.writeChar('1');
        out.writeUTF("好");
        out.close();

        InputStream in1=new FileInputStream("C:\\Workspace\\Idea\\BlueThinkPractice\\Char18\\src\\text.txt");
        BufferedInputStream in2=new BufferedInputStream(in1);
        DataInputStream in = new DataInputStream(in2);
        System.out.println(in.readByte()+" ");
        System.out.println(in.readLong()+" ");
        System.out.println(in.readChar()+" ");
        System.out.println(in.readUTF()+" ");

        in.close();
    }

}
