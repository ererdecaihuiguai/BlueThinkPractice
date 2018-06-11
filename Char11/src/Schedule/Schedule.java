package Schedule;

import java.util.Calendar;
import java.util.Date;

public class Schedule {

    private final Date start;
    private final Date end;

    public Schedule(Date start,Date end){
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Schedule{" + "start=" + start + ", end=" + end + '}';
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2018,06,01);
        Date start = c.getTime();
        c.set(2018,07,01);
        Date end = c.getTime();

        Schedule s = new Schedule(start,end);

        System.out.println(s.toString());

        end.setTime(System.currentTimeMillis());
        start.setTime(System.currentTimeMillis());

        System.out.println(s.toString());

    }
}
