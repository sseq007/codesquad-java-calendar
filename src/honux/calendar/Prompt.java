package honux.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------------+");
		System.out.println("1.  일정 등록");
		System.out.println("2.  일정 검색");
		System.out.println("3.  달력 보기");
		System.out.println("h.  도움말 q.  종료");
		System.out.println("+----------------------------+");
	}

	
	public void runPrompt() throws ParseException {
		
		printMenu();
		Scanner kb= new Scanner(System.in);
		Calendar cal= new Calendar();



		while(true) {
			String cmd = kb.next();
			if(cmd.equals("1")) cmdRegister(kb, cal);
			else if(cmd.equals("2")) cmdSearch(kb,cal);
			else if(cmd.equals("3")) cmdCal(kb,cal);
			else if (cmd.equals("h")) printMenu();
			else if (cmd.equals("q")) break;



		}
			System.out.println("Thank you Bye!!");
			kb.close();

		
	}
	private void cmdCal(Scanner kb,Calendar cal) {
		System.out.println("년도를 입력하세요");
		System.out.print("YEAR");
		int year =kb.nextInt();
		System.out.println("달을 입려하세요");
		System.out.print("MONTH");
		int month =kb.nextInt();
	
		
		
		if(month>12 || month<1) {
			return;
		}
		
		cal.printCalendar(year,month);
		
	}


	private void cmdSearch(Scanner kb,Calendar cal) {
		
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요(yyyy-mm-dd) . ");
		String date =kb.next();
		String plan="";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생하였습니다");
		}
		System.out.println(plan);
	}


	private void cmdRegister(Scanner kb,Calendar cal) throws ParseException {
		
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요(yyyy-mm-dd) . ");
		String date=kb.next();
		System.out.println("일정을 입력해 주세요 (문장의 끝에 ; 입력해주세요)");
		String text ="";
		while(true) {
			String word = kb.next();
			text+=word+" ";
			if(word.endsWith(";")) {
				break;
			}
		}
		cal.registerPlan(date, text);
		
		
	}


	public static void main(String[] args) throws ParseException {
		Prompt p=new Prompt();
		p.runPrompt();

	}
}