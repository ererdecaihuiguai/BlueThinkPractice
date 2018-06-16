package releaselock;

public class Machine extends Thread{
    private int a=1;
    public synchronized void print(){
        System.out.println("a="+a);
    }

    public void run(){
        synchronized (this){
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            //抛出ArithmeticException
            a=1/0;
            a++;
        }
    }

    public static void main(String[] args) {
        Machine machine=new Machine();
        machine.start();
        Thread.yield();
        machine.print();
    }
}
