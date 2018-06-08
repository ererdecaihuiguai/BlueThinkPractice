/**
 * 承租者
 */
public class Tenant {

    private double money;

    public Tenant(double money){
        this.money = money;
    }

    public boolean rentHouse(double expectedRent){
        //从房产市场找到一个房屋出租代理
        RenterIFC renter = HouseMarket.findRenter();

        //如果代理不同意预期的租金价格，就继续执行
        if(!renter.isAgree(expectedRent)){
            System.out.println("租房失败");
            return false;
        }
        //从存款中取出预付租金
        money-=expectedRent;
        renter.fetchRent(expectedRent);

        System.out.println("租房成功");
        return true;
    }
}
