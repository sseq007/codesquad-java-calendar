package honux.calendar;

import java.util.Scanner;

public class Prompt {

	public int parseDay(String week) {
		if(week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else return 0;
	}
	
	public void runPrompt() {
		
		Scanner kb= new Scanner(System.in);
		Calendar cal= new Calendar();
		
		
		
		while(true) {
			System.out.println("년도를 입려하세요");
			System.out.print("YEAR");
			int year =kb.nextInt();
			if(year==-1) break;
			System.out.println("달을 입려하세요");
			System.out.print("MONTH");
			int month =kb.nextInt();
			System.out.println("첫째 날의 요일을 입력하세요");
			System.out.print("WEEKDAY");
			String week =kb.next();
			int weekDay=parseDay(week);
			
			
			if(month>12 || month<1) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			
			cal.printCalendar(year,month,weekDay);
		}
		System.out.println("BYE");
		kb.close();
		
	}
	public static void main(String[] args) {
		Prompt p=new Prompt();
		p.runPrompt();

	}
}