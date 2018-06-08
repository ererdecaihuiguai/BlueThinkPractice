import java.util.HashSet;
import java.util.Set;

public class HouseMarket {

    private static Set<RenterIFC> renters = new HashSet<>();

    public static void registerRenter(RenterIFC renter){
        renters.add(renter);
    }

    public static RenterIFC findRenter(){
        return (RenterIFC) renters.iterator().next();
    }

}
