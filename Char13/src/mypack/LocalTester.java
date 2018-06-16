package mypack;

class Counter{
    private static int count;
    private static ThreadLocal<Integer> serialCount=new ThreadLocal<Integer>(){
      protected synchronized Integer initialValue(){
          return new Integer(count++);
      }
    };

    public static int get(){
        return serialCount.get();
    }

    public static void set(int i){
        serialCount.set(i);
    }
}

public class LocalTester extends Thread{
    public void run(){
        for(int i=0;i<3;i++){
            int c=Counter.get();
            System.out.println(Thread.currentThread().getName()+":"+c);
            Counter.set(c+=2);
        }
    }

    public static void main(String[] args) {
        Thread thread1=new LocalTester();
        Thread thread2=new LocalTester();
        thread1.start();
        thread2.start();
    }
}
