import java.util.ArrayList;
import java.util.List;

public class ColTester {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {
            {
                add(new Person("Tom", 21));
                add(new Person("Mike", 32));
                add(new Person("Linda", 19));
                add(new Person("Mary", 29));
            }
        };

        personList.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> System.out.println(person.getName() + " : " + person.getAge()));

        personList.stream()
                .sorted((person1, person2) -> (person1.getAge() - person2.getAge()))
                .limit(3)
                .forEach(person -> System.out.println(person.getName() + " : " + person.getAge()));

        int maxAge =personList.parallelStream()
                              .mapToInt(person-> person.getAge())
                              .max()
                              .getAsInt();

        System.out.println("Max Age:"+maxAge);
    }
}
