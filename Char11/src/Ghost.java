import java.util.HashMap;
import java.util.Map;

public class Ghost {

    //实例缓存
    private static final Map<String,Ghost> ghosts = new HashMap<String,Ghost>();
    private final String name;

    public Ghost(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    //如果实例缓存中存在与name参数匹配的Ghost对象，就将其返回，否则创建新的Ghost对象，将其返回
    public  static Ghost getInstance(String name){
        Ghost ghost = ghosts.get(name);
        if(ghost==null){
            ghost=new Ghost(name);
            ghosts.put(name,ghost);
        }
        return ghost;
    }

    //从缓存中删除name参数指定的Ghost对象
    public static void removeInstance(String name){
        ghosts.remove(name);
    }

    @Override
    protected void finalize() throws Throwable {
        ghosts.put(name,this);
        System.out.println("execute finalize");
        //throw new Exception("Just Test");
    }

    public static void main(String[] args) throws Exception{
        Ghost ghost = Ghost.getInstance("IAmBack");
    }
}
