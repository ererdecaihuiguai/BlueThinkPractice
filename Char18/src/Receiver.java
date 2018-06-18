import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Sender extends Thread {

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getPipedOutputStream() {
        return out;
    }

    @Override
    public void run() {
        try {
            for (int i = -127; i <= 128; i++) {
                out.write(i);
                yield();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

public class Receiver extends Thread {
    private PipedInputStream in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedInputStream(sender.getPipedOutputStream());
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = in.read()) != -1) {
                System.out.println(data);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        sender.start();
        receiver.start();
    }
}
