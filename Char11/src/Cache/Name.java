package Cache;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Name {

    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    //实例缓存，存放Name对象的软引用
    private static final Set<SoftReference<Name>> names = new HashSet<SoftReference<Name>>();

    //静态工厂方法
    public static Name valueOf(String firstName,String lastName){
        Iterator<SoftReference<Name>> it = names.iterator();
        while (it.hasNext()) {
            SoftReference<Name> ref = it.next();
            Name name = ref.get();

            if (name != null && name.firstName.equals(firstName) && name.lastName.equals(lastName)) {
                return name;
            }
        }
            Name name = new Name(firstName,lastName);
            names.add(new SoftReference<Name>(name));
            return name;
        }

    public static void main(String[] args) {
        Name n1 = Name.valueOf("小红","王");
        Name n2 = Name.valueOf("小红","王");
        Name n3 = Name.valueOf("小东","张");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n1==n2);
    }
}
