import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class ColourTester {
    enum Colour {
        RED, BLUE, YELLOW, GREEN;
    }

    public static void main(String[] args) {
        //EnumSet的使用
        EnumSet<Colour> colourSet = EnumSet.allOf(Colour.class);
        for (Colour colour : colourSet) {
            System.out.println(colour);
        }

        EnumMap<Colour, String> colourMap = new EnumMap<Colour, String>(Colour.class);
        colourMap.put(Colour.RED, "红色");
        colourMap.put(Colour.BLUE, "蓝色");
        colourMap.put(Colour.YELLOW, "黄色");
        colourMap.put(Colour.GREEN, "绿色");
        Set<Map.Entry<Colour, String>> set = colourMap.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
