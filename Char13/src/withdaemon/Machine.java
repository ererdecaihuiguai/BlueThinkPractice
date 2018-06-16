package withdaemon;

public class Machine extends Thread {
    private int a;
    private static int count;

    public void start() {
        super.start();

        //匿名线程类
        Thread deamon = new Thread() {
            public void run() {
                //无线循环
                while (true) {
                    //每隔一秒把实例变量a设为0
                    rest();
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
            }
        };
        deamon.setDaemon(true);
        deamon.start();
    }

    private void rest() {
        a = 0;
    }

    public void run() {
        while (true) {
            System.out.println(currentThread().getName() + ":" + a++);
            if (count++ == 100) {
                break;
            }
            yield();
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.start();
    }

}
