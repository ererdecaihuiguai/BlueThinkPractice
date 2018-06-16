package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Machine implements Runnable{
    //创建外部锁
    private final Lock lock=new ReentrantLock();

    int data=100;

    @Override
    public void run() {
        //用外部锁同步
        lock.lock();
        try {
            data++;
            Thread.currentThread().sleep(1000);
            data--;
            System.out.println(Thread.currentThread().getName()+" :data "+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        Machine machine=new Machine();
        //创建10个线程，都执行同一个Machine对象的run()方法
        for (int i=0;i<10;i++){
            Thread thread =new Thread(machine);
            thread.start();
        }
    }
}
