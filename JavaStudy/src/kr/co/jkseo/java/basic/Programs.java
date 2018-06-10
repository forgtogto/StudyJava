package kr.co.jkseo.java.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Programs {
	Scanner sc = new Scanner(System.in);
	
	public Programs() {
		
		String adminId = "admin";
		String adminPw = "1234";
		int select;
		
		System.out.println("=============================");
		System.out.println("======= JK's Program! =======");
		System.out.println("=============================");

		while (true) {

			System.out.println("1.로그인");
			System.out.println("2.종료");
			System.out.print("선택:");
			select = sc.nextInt();
			if (select == 1) {
				String inputId, inputPw;
				System.out.print("로그인:");
				inputId = sc.next();
				System.out.print("패스워드:");
				inputPw = sc.next();

				if (inputId.equals(adminId) && inputPw.equals(adminPw)) {
					System.out.println("== 로그인 되었습니다. ==");
					menu();
				} //로그인 검증 
				
			} // select 1일때 
			else if (select == 2) {
				break;
			} // select 2일때 
		} // while 반복 
	} // 생성자 
	
	public void menu() {
		
		System.out.println("");
		System.out.println("1.오늘의 날짜");
		System.out.println("2.로또");
		System.out.println("3.주사위");
		System.out.println("4.가위바위보 게임");
		System.out.println("5.로그아웃");
		System.out.print("선택:");
		int selectmenu = sc.nextInt();
		
		if(selectmenu == 1 ) {today(); menu();}
		else if(selectmenu == 2 ) {lottery(); menu();}
		else if(selectmenu == 3 ) {dice(); menu();}
		else if(selectmenu == 4 ) {rockScissorPaper(); menu();}
		else if(selectmenu == 5 ) {
			System.out.println("== 로그아웃 되었습니다. ==");
			System.out.println("");
		}
	}
	
	public void today() {
 
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 ss초");

			String strNow1 = sdf.format(now);
			System.out.println(strNow1);
			System.out.println("");
 
	}
	
	public void lottery() {
		
		int[] selNum = new int[6];
		Random random = new Random(3);
		System.out.print("오늘의 로또 번호:");
		for (int i = 0; i < 6; i++) {
			selNum[i] = random.nextInt(45) + 1;
			System.out.print(selNum[i] + " ");
		}
		System.out.println("");
	}
	
	public void dice() {
		
		int num = (int) (Math.random() * 6 + 1);
		System.out.println("주사위 눈:" + num + "/6");
		System.out.println("");
	}
	
	public void rockScissorPaper() {
		Scanner sc = new Scanner(System.in);
		int selectRSP;
		int myCho, comCho, winCnt = 0, losCnt = 0, drowCnt = 0;

		System.out.println("=======================");
		System.out.println("==<가위바위보 게임 ver0.1>==");
		System.out.println("=======================");
		String mywin = "\n내가 이김!\n";
		String mylose = "\n내가 졌소!\n";
		String drow = "\n무승부!\n";

		while (true) {
			System.out.println("1.게임시작");
			System.out.println("2.통계");
			System.out.println("3.종료");
			System.out.print("선택:");
			selectRSP = sc.nextInt();

			if (selectRSP == 1) {
				System.out.println("내선택(1.가위 / 2.바위 / 3.보)");
				System.out.print("선택:");

				myCho = sc.nextInt();
				System.out.println("컴퓨터가 생각중입니다.");
				for (int i = 3; i > 0; i--) { // 5초간 생각중
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
				comCho = (int) (Math.random() * 3 + 1);

				System.out.println("컴퓨터가 " + changeTitle(comCho) + "를 냈습니다.");

				System.out.println("나:" + changeTitle(myCho) + " vs " + "컴퓨터:" + changeTitle(comCho));
				if (myCho == 1) {
					if (comCho == 1) {
						System.out.println(drow);
						drowCnt++;
					} else if (comCho == 2) {
						System.out.println(mylose);
						losCnt++;
					} else if (comCho == 3) {
						System.out.println(mywin);
						winCnt++;
					}
				} else if (myCho == 2) {
					if (comCho == 1) {
						System.out.println(mywin);
						winCnt++;
					} else if (comCho == 2) {
						System.out.println(drow);
						drowCnt++;
					} else if (comCho == 3) {
						System.out.println(mylose);
						losCnt++;
					}
				} else if (myCho == 3) {
					if (comCho == 1) {
						System.out.println(mylose);
						losCnt++;
					} else if (comCho == 2) {
						System.out.println(mywin);
						winCnt++;
					} else if (comCho == 3) {
						System.out.println(drow);
						drowCnt++;
					}
				}
			} else if (selectRSP == 2) { //통계 내기 

				System.out.println("  승:  " + winCnt + "  패:  " + losCnt + "  무:  " + drowCnt +"\n");
			} else if (selectRSP == 3) {
				break;
			}
		}
	}
 
	static String changeTitle(int choice) {
		String title[] = { "가위", "바위", "보" };
		if (choice == 1) {
			return title[0];
		} else if (choice == 2) {
			return title[1];
		} else if (choice == 3) {
			return title[2];
		}
		return "";
	}
}







