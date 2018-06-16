package exhandler;

//TODO: 代理解
class MachineGroup extends ThreadGroup {
    public MachineGroup() {
        super("MachineGroup");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(getName() + "catches an exception from " + t.getName());
        super.uncaughtException(t, e);

    }
}

class MachineHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MachineHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(name + " catches an exception from " + t.getName());
    }

}

public class Machine extends Thread {

    public Machine(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        int a = 1 / 0;
    }

    public static void main(String[] args) throws Exception{
        ThreadGroup group=new MachineGroup();
        //设置Machine类的默认异常处理器
        UncaughtExceptionHandler defaultHandler=new MachineHandler("DefaultHandler");
        Machine.setDefaultUncaughtExceptionHandler(defaultHandler);

        Machine m1=new Machine(group,"machine1");
        Machine m2=new Machine(group,"machine2");

        //设置m2的当前异常处理器
        UncaughtExceptionHandler currentHandler=new MachineHandler("Machine2\'handler");
        m2.setUncaughtExceptionHandler(currentHandler);

        m1.start();
        m2.start();
    }

}