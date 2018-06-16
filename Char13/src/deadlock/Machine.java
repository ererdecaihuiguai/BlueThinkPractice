package deadlock;

//死锁示例
public class Machine extends Thread {
    //共享数据
    private Counter counter;

    public Machine(Counter counter) {
        this.counter = counter;
        //开启自身线程
        start();
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.setFriend(counter2);
        counter2.setFriend(counter1);

        Machine machine1 = new Machine(counter1);
        Machine machine2 = new Machine(counter2);
    }
}

class Counter {
    private int a;
    private Counter friend;

    public void setFriend(Counter friend) {
        this.friend = friend;
    }

    public synchronized void add() {
        a++;
        Thread.yield();
        friend.delete();
        System.out.println(Thread.currentThread().getName() + ":add");
    }

    public synchronized void delete() {
        a--;
    }

}