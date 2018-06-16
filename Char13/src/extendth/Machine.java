package extendth;

public class Machine extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.start();
    }
}
