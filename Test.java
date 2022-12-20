import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.time.DayOfWeek;
import static java.time.temporal.TemporalAdjusters.firstInMonth;


public class Test {
    public static void main(String[] args) {
        Test test= new Test();

        DayOfWeek week[] =  DayOfWeek.values();
        System.out.println("週  "+week[0]);
        System.out.println("週  "+week[6].getValue());
        System.out.println("週  "+week[1].getValue());
        
        LocalDate ret = test.getDateByWeekandDay(LocalDate.now(), 2, week[0]);
        System.out.println("day  "+ret);

         ret = test.getDateByWeekandDay(LocalDate.now(), 5, week[1]);
        System.out.println("day  "+ret);

        // create WeekFields
        WeekFields weekFields
            = WeekFields.of(DayOfWeek.MONDAY, 1);
  
        // apply dayOfWeek()
        TemporalField dayOfWeek
            = weekFields.dayOfWeek();
  
        // create a LocalDate
        LocalDate day = LocalDate.of(2022, 12, 12);
  
        // get day of week for localdate
        int dow = day.get(dayOfWeek);
  
        // print results
        System.out.println("day of week for "
                           + day + " :" + dow);

        LocalDate now = LocalDate.now(); //2015-11-23
        LocalDate firstMonday = now.with(firstInMonth(DayOfWeek.MONDAY)); 

        System.out.println("1st Mondy for "
                           + now + " :" + firstMonday);

        System.out.println("week  "      + getWeek(day));
        
    }

    static LocalDate firstMonday = LocalDate.now().with(firstInMonth(DayOfWeek.MONDAY)); 

    static int  getWeek(LocalDate sDate){
        int week = 0;
        LocalDate monday = firstMonday;
        while(!sDate.isBefore(monday)){
            monday = monday.plusDays(7);
            week++;
            System.out.println( " sfsf monday "      + monday);
            System.out.println( " sfsf week  "      + week);
        }
        return week;
    }

    LocalDate getDateByWeekandDay(LocalDate startDate, int week, DayOfWeek dayOfWeek){
		LocalDate weekDate = startDate
					//.with(TemporalAdjusters.firstDayOfMonth())
					.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
					.plusDays(7*(week-1));
		if(weekDate.getMonth() == startDate.getMonth()) return weekDate;
		return null;
	}

    void testCalDate(){
         // Write your code here
         List<String> numbers = new ArrayList<String>();
         String line = "每月2次(週2/4) 2 Times Per Month (Week 2 / 4)";
         // Pattern p = Pattern.compile("週\\d+");
         // Matcher m = p.matcher(line); 
         // while (m.find()) {
         //     //numbers.add(m.group());
         //     int n = Integer.parseInt(m.group());
         //     System.out.println("週  "+n);
         // }
 
         int iw = line.indexOf("週");
         try {
             String subline = line.substring(iw+1);
             int Week = Integer.parseInt(subline.substring(0,1));
             System.out.println("週  "+Week);
 
             iw = line.indexOf("/");
             if(iw !=-1){
                 subline = line.substring(iw+1);
                 Week = Integer.parseInt(subline.substring(0,1));
                 System.out.println("週  "+Week);
             }
             
         } catch (NumberFormatException e) {
             e.printStackTrace();
         }		
    }

}
