package control;

//以编程的方式控制线程
public class Machine extends ControlledThread{
    private int count;

    public void run(){
        while (true){
            synchronized (this){
                count++;
                System.out.println(Thread.currentThread().getName()+":run "+count+" times");
            }
            if(!checkState()){
                System.out.println(Thread.currentThread().getName()+" stop");
                break;
            }
        }
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized void reset(){
        count=0;
        System.out.println(Thread.currentThread().getName()+" reset");
    }

    public static void main(String[] args) {
        Machine machine=new Machine();
        machine.start();
        for(int i=0;i<200000;i++){
            if(machine.getCount()>5000){
                //让machine线程暂停
                machine.setState(ControlledThread.SUSP);
                yield();
                machine.reset();
                //让machine线程恢复运行
                machine.setState(ControlledThread.RUN);
            }
            yield();
        }
        //让线程终止运行
        machine.setState(ControlledThread.STOP);
    }
}
