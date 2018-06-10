package kr.co.jkseo.java.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SimpleProgram {

	public static void main(String[] args) {
		Program();
	}

	public static void Program() {
		Scanner sc = new Scanner(System.in);
		// 회원가입변수 아이디/암호/이름/전번/주소
		String id[] = new String[100];
		String pw[] = new String[100];
		String name[] = new String[100];
		String tel[] = new String[100];
		String addr[] = new String[100];

		// 사람수체크변수
		int personCnt = 0;

		// 로그인 id,pw
		String adminId = "admin";
		String adminPw = "1234";

		int loginOk = 0; // 0:로그아웃 1:로그인 2:관리자
		int select = 0, select2, select3, select4;

		System.out.println("=============================");
		System.out.println("======= JK's Program! =======");
		System.out.println("=============================");

		while (true) {

			if (loginOk == 0) {
				System.out.println("1.로그인");
				System.out.println("2.회원가입");
				System.out.println("3.종료");
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
						loginOk = 2;
					}
					}
				} else if (select == 3) {
					System.out.println(" ");
					break;
				}
 
		
			////////////////////////////////////////////////////////

			////////////////////////////////////////////////////////
			if (loginOk == 1) // select2로 본다
			{
				System.out.println("<<관리자 모드>>");
				System.out.println("1.전체회원보기");
				System.out.println("2.회원검색");
				System.out.println("3.로그아웃");
				System.out.println("4.종료");
				System.out.print("선택:");
				select2 = sc.nextInt();

				if (select2 == 3) {
					System.out.print("== 로그아웃 완료 == \n");
					loginOk = 0;
				}
			}
			/////////////////////////////////////////////////////

			////////////////////////////////////////////////////
			if (loginOk == 2) // select3으로 본다
			{
				System.out.println("<<로그인되었당>>");
				System.out.println("1.메인화면");
				System.out.println("2.내정보보기");
				System.out.println("3.로그아웃");
				System.out.println("4.종료");
				System.out.print("선택:");
				select3 = sc.nextInt();

				if (select3 == 1) {
					loginOk = 3;
				}else if (select3 == 3) {
					System.out.print("== 로그아웃 완료 == \n");
					loginOk = 0;
				}
			}
			//////////////////////////////////////////////////////////

			/////////////////////////////////////////////////////////
			if (loginOk == 3) // select4으로 본다
			{
				System.out.println("1.오늘의 날짜");
				System.out.println("2.로또");
				System.out.println("3.주사위");
				System.out.println("4.가위바위보 게임");
				System.out.println("5.내정보");
				System.out.println("6.로그아웃");
				System.out.print("선택:");
				select4 = sc.nextInt();

				if (select4 == 1) // 날짜
				{
					///////////////////////////////////////////
					Date now = new Date();
					String strNow1 = now.toString();
					System.out.println(strNow1);

					SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 ss초");

					String strNow2 = sdf.format(now);
					System.out.println(strNow2);
					System.out.println("");
					//////////////////////////////////////////

				} else if (select4 == 2) // 로또
				{
					////////////////////////////////////
					int[] selNum = new int[6];
					Random random = new Random(3);
					System.out.print("오늘의 로또 번호:");
					for (int i = 0; i < 6; i++) {
						selNum[i] = random.nextInt(45) + 1;
						System.out.print(selNum[i] + " ");
					}
					System.out.println("");
					System.out.println("");
					//////////////////////////////////////////

				} else if (select4 == 3) // 주사위
				{
					//////////////////////////////////////////
					int num = (int) (Math.random() * 6 + 1);
					System.out.println("주사위 눈:" + num + "/6");
					System.out.println("");
					//////////////////////////////////////////

					////////////////////////////////////////////////////
				} else if (select4 == 4) // 가위바위보
				{
					System.out.println("");
					RockScissorPaper_Game.gamegame();
					System.out.println("");

					////////////////////////////////////////////////////
				} else if (select4 == 6) // 로그아웃
				{
					System.out.println("\n로그아웃 되었습니다.\n");

					loginOk = 0;
				}
			}
		}
	}
}
