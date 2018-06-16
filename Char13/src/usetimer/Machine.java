package usetimer;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Machine extends Thread {
    private int a;

    public void start() {
        super.start();

        //把与Timer关联的线程设为后台线程
        Timer timer = new Timer(true);

        //匿名类
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                reset();
            }
        };

        //设置定时任务
        timer.schedule(task, 1, 1000);
    }

    private void reset() {
        a = 0;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(currentThread().getName() + ":" + a++);
            yield();
        }
    }

    public static void main(String[] args) throws Exception{
        Machine machine = new Machine();
        machine.start();
    }
}
