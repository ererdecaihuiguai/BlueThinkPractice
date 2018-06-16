package allrun;

public class Machine extends Thread {
    @Override
    public void run() {
        for (int i=0;i<50;i++){
            System.out.println(currentThread().getName()+":"+i);
            try {
                sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Machine machine1 = new Machine();
        Machine machine2 = new Machine();
        machine1.start();
        machine2.start();
        machine1.run();
    }
}
