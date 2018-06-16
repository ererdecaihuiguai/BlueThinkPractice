package waitio;

public class Machine extends Thread {
    private static StringBuffer log = new StringBuffer();
    private static int count = 0;

    @Override
    public void run() {
        for (int a = 0; a < 50; a++) {
            System.out.println(currentThread().getName() + ":" + a);
        }
    }

    public static void main(String[] args) throws Exception {
        Machine machine = new Machine();
        machine.start();

        //主线程进入阻塞状态，等待用户的输入，知道获得用户输入的数据，才推出阻塞
        int data = System.in.read();
        machine.run();
    }
}