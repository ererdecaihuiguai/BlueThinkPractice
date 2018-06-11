public class Person {
    private String name;
    private Gender gender;

    public Person(String name,Gender gender){
        this.name=name;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {

        Person mary = new Person("Mary",Gender.FEMALE);
        //Person tom = new Person("Tom",Gender.getInstance('a'));
    }
}
