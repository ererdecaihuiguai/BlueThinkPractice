public class Person extends Thread {
    private Well well;
    public Person(Well well){
        this.well=well;
        //启动自身线程
        start();
    }

    public void run(){
        synchronized (well){
            //打10桶水
            for (int i=0;i<10;i++){
                well.withdraw();
                yield();
            }
        }
    }

    public static void main(String[] args) {
        Well well=new Well();
        Person persons[]=new Person[10];
        //创建10个Person线程
        for (int i=0;i<10;i++){
            persons[i]=new Person(well);
        }
    }
}

class Well {
    //共享数据
    private int water = 1000;

    //打一桶水
    public void withdraw() {
        water--;
        System.out.println(Thread.currentThread().getName() + " :water left: " + water);
    }
}