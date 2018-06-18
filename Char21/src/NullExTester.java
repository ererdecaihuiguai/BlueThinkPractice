import java.util.Optional;

public class NullExTester {
    public String upper1(String string){
        return string.toUpperCase();
    }

    public String upper2(String string){
        if (string!=null){
            return string.toUpperCase();
        }else {
            return null;
        }
    }

    public String upper3(String string){
        Optional<String> optional=Optional.ofNullable(string);
        if (optional.isPresent()){
            return optional.get().toUpperCase();
        }else {
            return null;
        }
    }
}
