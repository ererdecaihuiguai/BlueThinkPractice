/**
 * 代理人
 */
public class Deputy implements RenterIFC {

    private Renter renter;

    public void registRenter(Renter renter){
        this.renter=renter;
    }

    @Override
    public boolean isAgree(double expectedRent) {
        if(expectedRent<renter.getRentDeadLine()){
            return false;
        }
        //请示租房者的意见
        return renter.isAgree(expectedRent);
    }

    @Override
    public void fetchRent(double rent) {
        renter.fetchRent(rent);
    }
}
