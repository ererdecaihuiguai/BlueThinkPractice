public class Renter implements RenterIFC{

    //房屋租金最低价格
    private double rentDeadLine;
    //存款
    private double money;

    public Renter(double rentDeadLine, double money) {
        this.rentDeadLine = rentDeadLine;
        this.money = money;
    }

    public double getRentDeadLine() {
        return rentDeadLine;
    }

    @Override
    public boolean isAgree(double expectedRent) {
        //如果租赁者的期望价格比房屋租金最低价格多100元，则同意出租
        return expectedRent-rentDeadLine>100;
    }

    @Override
    public void fetchRent(double rent) {
        money+=rent;
    }
}
