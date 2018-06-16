package correctstart;

public class Machine extends Thread {
    private  int a = 0;
    //统计被启动的Machine线程的数目
    private static int count = 0;

    public void start(){
        super.start();
        //这段代码由主线程执行
        System.out.println(currentThread().getName()+":第"+(++count)+"个Machine线程启动");
    }

    public void run(){
        //使用Machine对象的实例变量a
        for (a=0;a<50;a++){
            System.out.println(currentThread().getName()+":"+a);
            try{
                sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Machine machine1=new Machine();
        Machine machine2=new Machine();
        machine1.start();
        machine2.start();
    }
}
