package Schedule;

import java.util.Calendar;
import java.util.Date;

//采用了保护性复制
public class ScheduleProtect {

    private final Date start;
    private final Date end;

    @Override
    public String toString() {
        return "ScheduleProtect{" + "start=" + start + ", end=" + end + '}';
    }

    public ScheduleProtect(Date start, Date end){
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start = new Date(start.getTime());     //采用保护性复制
        this.end = new Date(end.getTime());         //采用保护性复制
    }

    //采用保护性复制
    public Date getStart() {
        return (Date)start.clone();
    }

    //采用保护性复制
    public Date getEnd() {
        return (Date)end.clone();
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2018,06,01);
        Date start = c.getTime();
        c.set(2018,07,01);
        Date end = c.getTime();

        ScheduleProtect s = new ScheduleProtect(start,end);

        System.out.println(s.toString());

        end.setTime(System.currentTimeMillis());
        start.setTime(System.currentTimeMillis());

        System.out.println(s.toString());
    }
}
