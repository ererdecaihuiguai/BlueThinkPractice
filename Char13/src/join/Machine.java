package join;

public class Machine extends Thread{
    public void run(){
        for (int a=0;a<50;a++){
            System.out.println(currentThread().getName()+":"+a);
        }
    }

    public static void main(String[] args) throws Exception{
        Machine machine = new Machine();
        machine.setName("m1");

        machine.start();
        System.out.println("main:join machine");
        //主线程等待machine线程运行结束
        machine.join();
        System.out.println("main:end");
    }
}
