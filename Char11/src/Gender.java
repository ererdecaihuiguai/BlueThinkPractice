import java.io.Serializable;
import java.util.*;

public class Gender implements Serializable {
    private final Character sex;
    private final transient String description;

    public Character getSex(){
        return sex;
    }

    public String getDescription(){
        return description;
    }

    //实例缓存
    private static final Map<Character,Gender> instancesBySex=new HashMap<Character, Gender>();

    private Gender(Character sex,String description){
        this.sex=sex;
        this.description=description;
        instancesBySex.put(sex,this);
    }

    public static final Gender FEMALE = new Gender(new Character('F'),"Female");
    public static final Gender MALE = new Gender(new Character('M'),"Male");

    public static Collection getAllValues(){
        return Collections.unmodifiableCollection(instancesBySex.values());
    }

    public static Gender getInstance(Character sex){
        Gender result=(Gender)instancesBySex.get(sex);
        if(result==null){
            throw new NoSuchElementException(sex.toString());
        }
        return result;
    }

    public String toString(){
        return description;
    }

    /**
     * 保证反序列化时直接返回Gender类包含的静态实例
     * @return
     */
    private Object readResolve(){
        return getInstance(sex);
    }
}
