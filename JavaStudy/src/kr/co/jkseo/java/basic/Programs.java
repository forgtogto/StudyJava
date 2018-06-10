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

			System.out.println("1.�α���");
			System.out.println("2.����");
			System.out.print("����:");
			select = sc.nextInt();
			if (select == 1) {
				String inputId, inputPw;
				System.out.print("�α���:");
				inputId = sc.next();
				System.out.print("�н�����:");
				inputPw = sc.next();

				if (inputId.equals(adminId) && inputPw.equals(adminPw)) {
					System.out.println("== �α��� �Ǿ����ϴ�. ==");
					menu();
				} //�α��� ���� 
				
			} // select 1�϶� 
			else if (select == 2) {
				break;
			} // select 2�϶� 
		} // while �ݺ� 
	} // ������ 
	
	public void menu() {
		
		System.out.println("");
		System.out.println("1.������ ��¥");
		System.out.println("2.�ζ�");
		System.out.println("3.�ֻ���");
		System.out.println("4.���������� ����");
		System.out.println("5.�α׾ƿ�");
		System.out.print("����:");
		int selectmenu = sc.nextInt();
		
		if(selectmenu == 1 ) {today(); menu();}
		else if(selectmenu == 2 ) {lottery(); menu();}
		else if(selectmenu == 3 ) {dice(); menu();}
		else if(selectmenu == 4 ) {rockScissorPaper(); menu();}
		else if(selectmenu == 5 ) {
			System.out.println("== �α׾ƿ� �Ǿ����ϴ�. ==");
			System.out.println("");
		}
	}
	
	public void today() {
 
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� MM�� dd�� hh�� mm�� ss��");

			String strNow1 = sdf.format(now);
			System.out.println(strNow1);
			System.out.println("");
 
	}
	
	public void lottery() {
		
		int[] selNum = new int[6];
		Random random = new Random(3);
		System.out.print("������ �ζ� ��ȣ:");
		for (int i = 0; i < 6; i++) {
			selNum[i] = random.nextInt(45) + 1;
			System.out.print(selNum[i] + " ");
		}
		System.out.println("");
	}
	
	public void dice() {
		
		int num = (int) (Math.random() * 6 + 1);
		System.out.println("�ֻ��� ��:" + num + "/6");
		System.out.println("");
	}
	
	public void rockScissorPaper() {
		Scanner sc = new Scanner(System.in);
		int selectRSP;
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
			selectRSP = sc.nextInt();

			if (selectRSP == 1) {
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
			} else if (selectRSP == 2) { //��� ���� 

				System.out.println("  ��:  " + winCnt + "  ��:  " + losCnt + "  ��:  " + drowCnt +"\n");
			} else if (selectRSP == 3) {
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







