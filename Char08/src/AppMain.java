public class AppMain {
    public static void main(String[] args) throws Exception{
        Renter renter=new Renter(2000,10000);
        Deputy deputy=new Deputy();
        HouseMarket.registerRenter(deputy);
        deputy.registRenter(renter);

        Tenant tenant=new Tenant(20000);

        tenant.rentHouse(1800);
        tenant.rentHouse(2300);
    }
}
