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
		// ȸ�����Ժ��� ���̵�/��ȣ/�̸�/����/�ּ�
		String id[] = new String[100];
		String pw[] = new String[100];
		String name[] = new String[100];
		String tel[] = new String[100];
		String addr[] = new String[100];

		// �����üũ����
		int personCnt = 0;

		// �α��� id,pw
		String adminId = "admin";
		String adminPw = "1234";

		int loginOk = 0; // 0:�α׾ƿ� 1:�α��� 2:������
		int select = 0, select2, select3, select4;

		System.out.println("=============================");
		System.out.println("======= JK's Program! =======");
		System.out.println("=============================");

		while (true) {

			if (loginOk == 0) {
				System.out.println("1.�α���");
				System.out.println("2.ȸ������");
				System.out.println("3.����");
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
						loginOk = 2;
					}
					}
				} else if (select == 3) {
					System.out.println(" ");
					break;
				}
 
		
			////////////////////////////////////////////////////////

			////////////////////////////////////////////////////////
			if (loginOk == 1) // select2�� ����
			{
				System.out.println("<<������ ���>>");
				System.out.println("1.��üȸ������");
				System.out.println("2.ȸ���˻�");
				System.out.println("3.�α׾ƿ�");
				System.out.println("4.����");
				System.out.print("����:");
				select2 = sc.nextInt();

				if (select2 == 3) {
					System.out.print("== �α׾ƿ� �Ϸ� == \n");
					loginOk = 0;
				}
			}
			/////////////////////////////////////////////////////

			////////////////////////////////////////////////////
			if (loginOk == 2) // select3���� ����
			{
				System.out.println("<<�α��εǾ���>>");
				System.out.println("1.����ȭ��");
				System.out.println("2.����������");
				System.out.println("3.�α׾ƿ�");
				System.out.println("4.����");
				System.out.print("����:");
				select3 = sc.nextInt();

				if (select3 == 1) {
					loginOk = 3;
				}else if (select3 == 3) {
					System.out.print("== �α׾ƿ� �Ϸ� == \n");
					loginOk = 0;
				}
			}
			//////////////////////////////////////////////////////////

			/////////////////////////////////////////////////////////
			if (loginOk == 3) // select4���� ����
			{
				System.out.println("1.������ ��¥");
				System.out.println("2.�ζ�");
				System.out.println("3.�ֻ���");
				System.out.println("4.���������� ����");
				System.out.println("5.������");
				System.out.println("6.�α׾ƿ�");
				System.out.print("����:");
				select4 = sc.nextInt();

				if (select4 == 1) // ��¥
				{
					///////////////////////////////////////////
					Date now = new Date();
					String strNow1 = now.toString();
					System.out.println(strNow1);

					SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� MM�� dd�� hh�� mm�� ss��");

					String strNow2 = sdf.format(now);
					System.out.println(strNow2);
					System.out.println("");
					//////////////////////////////////////////

				} else if (select4 == 2) // �ζ�
				{
					////////////////////////////////////
					int[] selNum = new int[6];
					Random random = new Random(3);
					System.out.print("������ �ζ� ��ȣ:");
					for (int i = 0; i < 6; i++) {
						selNum[i] = random.nextInt(45) + 1;
						System.out.print(selNum[i] + " ");
					}
					System.out.println("");
					System.out.println("");
					//////////////////////////////////////////

				} else if (select4 == 3) // �ֻ���
				{
					//////////////////////////////////////////
					int num = (int) (Math.random() * 6 + 1);
					System.out.println("�ֻ��� ��:" + num + "/6");
					System.out.println("");
					//////////////////////////////////////////

					////////////////////////////////////////////////////
				} else if (select4 == 4) // ����������
				{
					System.out.println("");
					RockScissorPaper_Game.gamegame();
					System.out.println("");

					////////////////////////////////////////////////////
				} else if (select4 == 6) // �α׾ƿ�
				{
					System.out.println("\n�α׾ƿ� �Ǿ����ϴ�.\n");

					loginOk = 0;
				}
			}
		}
	}
}
