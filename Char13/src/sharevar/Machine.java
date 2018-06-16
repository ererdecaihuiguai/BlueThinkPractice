package sharevar;

public class Machine extends Thread {
    private int i=0;
    @Override
    public void run() {
        for (i=0;i<50;i++){
            System.out.println(currentThread().getName()+":"+i);
            try {
                sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        Machine machine1 = new Machine();
        machine.start();
        machine1.start();
        //machine.run();
    }

}
