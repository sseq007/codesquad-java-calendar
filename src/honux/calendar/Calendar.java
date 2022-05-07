package honux.calendar;



public class Calendar {

	private static final int [] max_Days= {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int [] LEAP_MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};

	public static boolean isLeapYear(int year) {

		if(year%4==0 &&(year%100!=0||year%400==0)) {
			return true;

		}else {
			return false;
		}
	}
	public static int getMaxDaysofMonth(int year,int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		}else {
			return max_Days[month-1];
		}
	}
	
	void printCalendar(int year,int month,int weekDay) {
		System.out.printf("   <<%4d년%3d월>>\n",year,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("-----------------------");
		
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
	

}
