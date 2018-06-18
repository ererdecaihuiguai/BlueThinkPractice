import java.util.Arrays;
import java.util.List;

public class SimpleTester {
    public static void main(String[] args) {
        String[] data = {"Tom", "Mike", "Linda", "Jack"};
        List<String> names= Arrays.asList(data);

        //方式一：传统的遍历集合的方式
        for (String name:names){
            System.out.println(name);
        }

        //方式二：使用Lambda表达式
        names.forEach((name)-> System.out.println(name));

        //方式三：使用Lambda表达式
        names.forEach(System.out::println);
    }
}
