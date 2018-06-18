import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class SequenceTester {
    public static void main(String[] args) throws IOException {
        InputStream s1 = new ByteArrayInputStream("您好".getBytes());
        InputStream s2 = new ByteArrayInputStream("世界".getBytes());
        InputStream in = new SequenceInputStream(s1, s2);
        //byte[] buff = new byte[1024];
        int data;
        while ((data = in.read()) != -1) {
            System.out.print(data + " ");
        }
        in.close();
    }
}
