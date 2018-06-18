import java.util.*;

public class Visitor {

    public static void print(Collection<? extends Object> c) {
        Iterator<? extends Object> iterator = c.iterator();
        //遍历集合中的所有元素
        while (iterator.hasNext()) {
            //取出集合中的一个元素
            Object element = iterator.next();
            System.out.println(element);
        }
    }

    public static void printWithForEach(Collection<? extends Object> collection) {
        //用foreach语句来遍历集合
        for (Object element : collection) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Tom");
        set.add("Mary");
        set.add("Jack");
        print(set);

        List<String> list = new ArrayList<>();
        list.add("Linda1");
        list.add("Linda2");
        list.add("Linda3");
        print(list);

        Queue<String> queue = new ArrayDeque<>();
        queue.add("Man1");
        queue.add("Man2");
        queue.add("Man3");
        print(queue);

        Map<String, String> map = new HashMap<>();
        map.put("M","男");
        map.put("F","女");
        //map.entrySet()方法返回一个集合，该集合中存放了MapEntry元素;
        //每个Map.Entry元素表示一个键/值
        print(map.entrySet());

        printWithForEach(set);
        printWithForEach(list);
        printWithForEach(queue);
        printWithForEach(map.entrySet());
    }

}
