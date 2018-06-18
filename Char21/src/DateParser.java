import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseDate(String text,String format){

        try {
            return new SimpleDateFormat(format).parse(text);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Date data=parseDate("06-11-2018","MM-dd-yyyy");
        System.out.println(data);

        Date data1=parseDate("2018/06/12","yyyy/MM/dd");
        System.out.println(data1);
    }
}
