import java.util.*;

public class BulkTester {

    final static Integer[] DATA1={11,22,33,44,55,66};
    final static Integer[] DATA2={11,22,77,88};

    static Set<Integer> getOriginalSet(Integer[] data){
        Set<Integer> set=new HashSet<>(Arrays.asList(data));
        return set;
    }

    static void print(Collection<Integer> collection){
        for (Integer integer:collection){
            System.out.print(integer+" ");
        }
    }

    public static void main(String[] args) {
        Set<Integer> set1=getOriginalSet(DATA1);
        Set<Integer> set2=getOriginalSet(DATA2);
        set1.retainAll(set2);
        System.out.println("打印两个集合的交集");
        print(set1);

        set1=getOriginalSet(DATA1);
        set2=getOriginalSet(DATA2);
        //批量添加元素
        set1.addAll(set2);
        System.out.println("\n打印加入SET2中元素后的SET1集合");
        print(set1);

        List<Integer> list1=new ArrayList<Integer>(Arrays.asList(DATA1));
        List<Integer> list2=list1.subList(0,3);
        list2.clear();
        System.out.println("\n打印删除子列表视图后的LIST1列表");
        print(list1);
    }
}
