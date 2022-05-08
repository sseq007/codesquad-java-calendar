package honux.calendar;

import java.util.Scanner;

public class Prompt {


	
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
		
			
			
			if(month>12 || month<1) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			
			cal.printCalendar(year,month);
		}
		System.out.println("BYE");
		kb.close();
		
	}
	public static void main(String[] args) {
		Prompt p=new Prompt();
		p.runPrompt();

	}
}