public class AssertTester {

    public int divide(int a,int b){
        assert b!=0:"can't be 0";
        return a/b;
    }

    public static void main(String[] args) {
        AssertTester t=new AssertTester();
        System.out.println(t.divide(3,0));
    }
}
