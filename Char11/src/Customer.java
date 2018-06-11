public class Customer implements Cloneable {
    private String name;
    private Integer age;

    public Customer() {
        this("unknown",0);
        System.out.println("调用默认构造器");
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("调用第二个构造器");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        return age != null ? age.equals(customer.age) : customer.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception{
        Class objClass=Class.forName("Customer");
        Customer c1=(Customer)objClass.newInstance();
        System.out.println("c1:"+c1);

        Customer c2=new Customer("Tom",20);
        System.out.println("c2:"+c2);

        //运用克隆手段创建Customer对象
        Customer c3=(Customer)c2.clone();
        System.out.println("c3:"+c3);

        System.out.println("c2==c3:"+(c2==c3));
        System.out.println("c2.equals(c3):"+c2.equals(c3));

    }
}
