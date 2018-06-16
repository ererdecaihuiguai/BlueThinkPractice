package problem;

public class SyncTest {
    public static void main(String[] args) {
        Stack stack = new Stack("stack");
        Producer producer = new Producer(stack, "producer");
        Producer producer1 = new Producer(stack, "producer1");
        Consumer consumer = new Consumer(stack, "consumer");
        //producer.start();
    }
}

/**
 * 生产者线程
 */
class Producer extends Thread {
    private Stack theStack;

    public Producer(Stack s, String name) {
        super(name);
        theStack = s;
        start();
    }

    public void run() {
        String goods;
        for (int i = 0; i < 200; i++) {
            synchronized (theStack) {
                goods = "goods" + (theStack.getPoint() + 1);
                if(theStack.push(goods)){
                    System.out.println(getName() + ":push " + goods + " to " + theStack.getName());
                }
            }
            yield();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer extends Thread {
    private Stack theStack;

    public Consumer(Stack stack, String name) {
        super(name);
        theStack = stack;
        //启动自身消费者线程
        start();
    }

    public void run() {
        String goods;
        for (int i = 0; i < 200; i++) {
            goods = theStack.pop();
            System.out.println(getName() + ":pop " + goods + " from " + theStack.getName());
            yield();
        }
    }
}

/**
 * 堆栈
 */
class Stack {
    private String name;
    private final int SIZE=100;
    private String[] buffer = new String[SIZE];
    int point = -1;

    public Stack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized int getPoint() {
        return point;
    }

    public String pop() {
        synchronized (this) {
            //如果堆栈为空，返回null
            if(point==-1){
                return null;
            }
            String goods = buffer[point];
            buffer[point] = null;
            Thread.yield();
            point--;
            return goods;
        }
    }

    public synchronized boolean push(String goods) {
        //如果堆栈已满，返回false
        if(point==SIZE-1){
            return false;
        }
        point++;
        Thread.yield();
        buffer[point] = goods;
        return true;
    }
}