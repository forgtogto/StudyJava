package kr.co.jkseo.java.basic;

import java.util.Scanner;

public class RockScissorPaper_Game {

	public static void gamegame() {
		Scanner sc = new Scanner(System.in);
		int select;
		int myCho, comCho, winCnt = 0, losCnt = 0, drowCnt = 0;

		System.out.println("=======================");
		System.out.println("==<���������� ���� ver0.1>==");
		System.out.println("=======================");
		String mywin = "\n���� �̱�!\n";
		String mylose = "\n���� ����!\n";
		String drow = "\n���º�!\n";

		while (true) {
			System.out.println("1.���ӽ���");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.print("����:");
			select = sc.nextInt();

			if (select == 1) {
				System.out.println("������(1.���� / 2.���� / 3.��)");
				System.out.print("����:");

				myCho = sc.nextInt();
				System.out.println("��ǻ�Ͱ� �������Դϴ�.");
				for (int i = 3; i > 0; i--) { // 5�ʰ� ������
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
				comCho = (int) (Math.random() * 3 + 1);

				System.out.println("��ǻ�Ͱ� " + changeTitle(comCho) + "�� �½��ϴ�.");

				System.out.println("��:" + changeTitle(myCho) + " vs " + "��ǻ��:" + changeTitle(comCho));
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
			} else if (select == 2) { //��� ���� 

				System.out.println("  ��:  " + winCnt + "  ��:  " + losCnt + "  ��:  " + drowCnt +"\n");
			} else if (select == 3) {
				break;
			}
		}
	}

	static String changeTitle(int choice) {
		String title[] = { "����", "����", "��" };
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
