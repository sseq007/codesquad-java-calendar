package honux.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT="cal> ";
	public static void runPrompt() {
		String PROMPT="cal> ";
		Scanner kb= new Scanner(System.in);
		Calendar cal= new Calendar();
		
		while(true) {
			System.out.println("년도를 입려하세요");
			System.out.print("YEAR");
			int year =kb.nextInt();
			System.out.println("달을 입려하세요");
			System.out.print(PROMPT);
			int month =kb.nextInt();
			if(month==0) {
				break;
			}
			if(month>12) {
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