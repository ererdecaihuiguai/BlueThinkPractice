package countbirds;

public class Machine implements Runnable {
    //共享数据
    private int a = 1;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            a += i;

            //给其他线程运行的机会
            //Thread.sleep(1);
            Thread.yield();
            a -= i;
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Machine machine = new Machine();
        Thread t1=new Thread(machine);
        Thread t2=new Thread(machine);
        Thread t3=new Thread(machine);
        t1.start();
        t2.start();
        t3.start();
    }
}
