package honux.calendar;



public class Calendar {

	private static final int [] max_Days= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int [] LEAP_MAX_DAYS = {0,31,29,31,30,31,30,31,31,30,31,30,31};

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
		final int STANDARD_WEEKDAY=3;
		
		int count=0;
		for(int i=syear;i<year;i++) {
			int delta = isLeapYear(i)?366:365;
			count+=delta;
		}
		for(int i=1;i<month;i++) {
			int delta = getMaxDaysofMonth(year, i);
			
			count+=delta;
		}
		count+=day;
		int weekDay= (count + STANDARD_WEEKDAY) %7;
		
		
		return weekDay;
		
	}
	
	//simple test code
	public static void main(String[] args) {
		Calendar cal =new Calendar();
		cal.getWeekDay(1970, 1, 1);
		cal.getWeekDay(1971, 1, 1);
		cal.getWeekDay(1972, 1, 1);
	}

}
