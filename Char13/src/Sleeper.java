public class Sleeper extends Thread{
    public void run(){
        try{
            //睡眠了1分钟
            sleep(6000);
            System.out.println("睡眠结束");
        }catch (InterruptedException e){
            System.out.println("睡眠被打断");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws Exception{
        Sleeper sleeper = new Sleeper();
        sleeper.start();
        Thread.sleep(10);
        //中断Sleeper线程的睡眠
        sleeper.interrupt();
    }
}
