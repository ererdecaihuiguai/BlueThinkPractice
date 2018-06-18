import java.util.HashSet;
import java.util.Set;

public class ConcurrentTester {

    public static void main(String[] args) {
        final int size=100;
        final Set<Integer>set=new HashSet<>();
        for (int i=0;i<size;i++){
            set.add(new Integer(i));
        }

        //负责遍历集合的线程
        Thread reader=new Thread(){
            @Override
            public void run() {
                for (Integer i:set){
                    //抛出ConcurrentModificationException
                    System.out.println(i);
                    yield();
                }
            }
        };

        //负责删除集合中的元素的线程
        Thread remover=new Thread(){
            @Override
            public void run() {
                for (int i=0;i<size;i++){
                    set.remove(new Integer(i));
                    yield();
                }
            }
        };

        reader.start();
        remover.start();
    }

}
