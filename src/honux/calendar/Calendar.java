package honux.calendar;


import java.util.Scanner;

public class Calendar {

	private static final int [] max_Days= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int getMaxDaysofMonth(int month) {
		return max_Days[month-1];
	}
	
	static void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토 일");
		System.out.println("---------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	public static void main(String[] args) {


		Scanner kb= new Scanner(System.in);
		Calendar cal= new Calendar();
		System.out.println("반복횟수를 입력하세요");
		int repeat = kb.nextInt();
		for(int i=0;i<repeat;i++) {
			System.out.println("달을 입려하세요");
			int month =kb.nextInt();
			System.out.printf("%d월은 %d일 까지 있습니다.\n",month,cal.getMaxDaysofMonth(month));
			cal.printSampleCalendar();
		}
		System.out.println("BYE");
		kb.close();

		



	}

}
