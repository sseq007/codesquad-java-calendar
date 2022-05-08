package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int [] max_Days= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int [] LEAP_MAX_DAYS = {0,31,29,31,30,31,30,31,31,30,31,30,31};

	private HashMap <Date,String> planMap;
	
	public Calendar(){
		planMap = new HashMap<Date,String>();
	}
	
	
	public void registerPlan(String strDate,String plan) throws ParseException {
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		//System.out.println(date);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan=planMap.get(date);
		return plan;
	}
	
	public static boolean isLeapYear(int year) {

		if(year%4==0 &&(year%100!=0||year%400==0)) {
			return true;

		}else {
			return false;
		}
	}
	public static int getMaxDaysofMonth(int year,int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
			return max_Days[month];
		}
	}
	
	void printCalendar(int year,int month) {
		System.out.printf("   <<%d년 %d월>>\n",year,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("-----------------------");
		
		int weekDay = getWeekDay(year, month, 1);
		int	maxDay=getMaxDaysofMonth(year,month);
		int count=7-weekDay;
		int delim = (count<7)?count:0;
		for(int i=0;i<weekDay;i++) {
			System.out.print("   ");
		}
		
		for(int i=1;i<=count;i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		count++;
		for(int i=count;i<=maxDay;i++) {
			System.out.printf("%3d",i);
			if(i%7==delim) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	int getWeekDay(int year,int month,int day) {
		int syear=1970;
		final int STANDARD_WEEKDAY=4;
		
		int count=0;
		for(int i=syear;i<year;i++) {
			int delta = isLeapYear(i)?366:365;
			count+=delta;
		}
		for(int i=1;i<month;i++) {
			int delta = getMaxDaysofMonth(year, i);
			
			count+=delta;
		}
		count+=day-1;
		int weekDay= (count + STANDARD_WEEKDAY) %7;
		
		
		return weekDay;
		
	}
	
	//simple test code
	public static void main(String[] args) throws ParseException {
		Calendar cal =new Calendar();
		
		
		cal.registerPlan("2022-05-09", "Let's go");
		System.out.println(cal.searchPlan("2022-05-09").equals("Let's go"));
	}

}
