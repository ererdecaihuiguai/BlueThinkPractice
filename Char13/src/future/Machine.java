package future;


import java.lang.reflect.Array;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class Machine implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int a = 1; a <= 100; a++) {
            sum += a;
            try {
                Thread.currentThread().sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    public static void main(String args[]) throws Exception {
        FutureTask<Integer> task = new FutureTask<Integer>(new Machine());
        Thread threadMachine = new Thread(task);
        //threadMachine执行Machine类的call()方法
        threadMachine.start();

        System.out.println("等待计算结果...");
        //主线程调用task.get()方法，获得运算结果
        System.out.println("从1加到100的和：" + task.get());
        System.out.println("计算完毕");
    }

}
