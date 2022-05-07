package honux.calendar;


import java.util.Scanner;

public class Calendar {

	private static final int [] max_Days= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int getMaxDaysofMonth(int month) {
		return max_Days[month-1];
	}
	
	static void printCalendar(int year,int month) {
		System.out.printf("   <<%4d년%3d월>>\n",year,month);
		System.out.println(" SU MO TU WE TH FI SA");
		System.out.println("-----------------------");
		
		int maxDay=getMaxDaysofMonth(month);
		for(int i=1;i<maxDay;i++) {
			System.out.printf("%3d",i);
			if(i%7==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	

}
