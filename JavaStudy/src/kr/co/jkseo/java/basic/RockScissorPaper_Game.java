package kr.co.jkseo.java.basic;

import java.util.Scanner;

public class RockScissorPaper_Game {

	public static void gamegame() {
		Scanner sc = new Scanner(System.in);
		int select;
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
			select = sc.nextInt();

			if (select == 1) {
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
			} else if (select == 2) { //통계 내기 

				System.out.println("  승:  " + winCnt + "  패:  " + losCnt + "  무:  " + drowCnt +"\n");
			} else if (select == 3) {
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
