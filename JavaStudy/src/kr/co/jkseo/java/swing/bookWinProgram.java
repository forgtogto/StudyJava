package kr.co.jkseo.java.swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class bookWinProgram {

	public static void main(String[] args) {
		BooksManager bm = new BooksManager();

	}
}

class BooksManager extends Frame implements ActionListener {
	Scanner sc = new Scanner(System.in);
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Dimension dimen3, dimen4;
	private int xpos1, ypos1;

	/////////////////// �α��ο�/////////////////////////
	private Label lbid1 = new Label("�� �� ��:");
	private Label lbpw1 = new Label("�н�����:");
	private Label lbresult1 = new Label("�α��� �Է�...");
	private Label lbblank1 = new Label("");
	private TextField textid1 = new TextField("");
	private TextField textpw1 = new TextField("");
	private Button btlogin1 = new Button("�α���");
	private Button btcancel1 = new Button("���");
	/////////////////////////////////////////////////////////

	/////////////////// ���μ��� ��ư//////////////////////////////
	private Label ��������� = new Label("1. �� �� �� ��");
	private Label �̸��Է¶� = new Label("�̸��Է�");
	private Label �̸��Է¶�1 = new Label("�̸��Է�");
	private Label �̸��Է¶�2 = new Label("�̸��Է�");
	private Label ȸ����ȣ�Է¶� = new Label("ȸ����ȣ�Է�");
	private Label �����ݳ��� = new Label("2. �� �� �� ��");
	private Label �̳�ȸ���� = new Label("3. �� �� ȸ ��");
	private Label �뿩����Ʈ�� = new Label("4. �� �� �� �� Ʈ");
	private Label ȸ�������� = new Label("5. ȸ �� �� ��");
	private Label ȯ�漳���� = new Label("6. ȯ �� �� �� ");
	private Button ���������̸��� = new Button("Ȯ��");
	private Button ��������ȸ���� = new Button("Ȯ��");
	private Button �����ݳ��� = new Button("Ȯ��");
	private Button �̳�ȸ���� = new Button("Ȯ��");
	private Button �뿩����å��Ϲ� = new Button("�뿩����å���");
	private Button �뿩����å��Ϲ� = new Button("�뿩����å���");
	private Button ȸ���߰��� = new Button("ȸ���߰�");
	private Button ��üȸ���� = new Button("��üȸ������");
	private Button �뿩�ݾ׼����� = new Button("�뿩�ݾ׼���");
	private Button �űԵ����Է¹� = new Button("�űԵ����Է�");
	private Button ������ü��Ϲ� = new Button("������ü���");
	private Button ���� = new Button(" ===�� ��=== ");
	private TextField ���������̸� = new TextField("");
	private TextField ���������̸�1 = new TextField("");
	private TextField ���������̸�2 = new TextField("");
	private TextField ��������ȸ�� = new TextField("");
	Label lbblank2 = new Label("");
	Label lbblank3 = new Label("");
	Label lbblank4 = new Label("");
	Label lbblank5 = new Label("");
	Label lbblank6 = new Label("");
	Label lbblank7 = new Label("");
	Label lbblank8 = new Label("");
	Label lbblank9 = new Label("");
	Label lbblank10 = new Label("");
	Label lbblank11 = new Label("");
	Label lbblank12 = new Label("");
	Label lbblank13 = new Label("");
	Label lbblank14 = new Label("");
	Label lbblank15 = new Label("");
	Label lbblank16 = new Label("");
	Label lbblank17 = new Label("");
	Label lbblank18 = new Label("");
	Label lbblank19 = new Label("");
	Label lbblank20 = new Label("");

	//////////////////////////////////////////////////////////////
	////// 1.
	Label �̸� = new Label("");
	Label �޴�2���� = new Label("");
	Label ������� = new Label("������:");
	TextField ���������� = new TextField("");
	Label ������ȣ�� = new Label("������ȣ:");
	TextField ������ȣ���� = new TextField("");
	Label ī�װ��� = new Label("ī�װ�(1��ȭ/2�Ҽ�");
	TextField ī�װ����� = new TextField("");
	Label �޴�1���� = new Label("");
	Button �޴�1�������ư = new Button("������");
	int gubun;
	TextArea ȸ���ؽ�Ʈ1 = new TextArea("");

	////////// 9ȸ������
	TextArea ȸ���ؽ�Ʈ = new TextArea("");
	Button ������ = new Button("������");

	///////////////////////////////////////////////////////////////

	/////////////////////////////
	// DB ���Ӱ��� ����
	String url;
	String id;
	String pass;
	String query;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String inputId;
	String inputPw;
	static String searchName;

	/////////////////////////////
	static boolean loginCheck = false; // �α��λ�������
	static int loginOK = 0; //

	int select;

	BooksManager() {
		super("�����뿩 ���α׷�");
		if (loginOK == 0)
			frametool_1();
		else if (loginOK == 1) {
			frametool_2();
		} else if (loginOK == 2) {
			framemanu1();
			select1(searchName);
		} else if (loginOK == 3) {
			framemanu2();
			select2(searchName);
		} else if (loginOK == 4) {
			framemanu3();
		} else if (loginOK == 5) {
			framemanu4();
		} else if (loginOK == 6) {
			framemanu5();
		} else if (loginOK == 7) {
			framemanu6();
		} else if (loginOK == 8) {
			framemanu7();
		} else if (loginOK == 9) {
			framemanu8();
			selectfulllist();
		} else if (loginOK == 10) {
			framemanu9();
		} else if (loginOK == 11) {
			framemanu10();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btlogin1) {
			inputId = textid1.getText().trim().toString();
			inputPw = textpw1.getText().trim().toString();
			select(inputId, inputPw);
		} else if (e.getSource() == btcancel1) {
			System.exit(1);
		} else if (e.getSource() == ���������̸���) {
			searchName = ���������̸�.getText().trim().toString();
			loginOK = 2;

			framemanu1();

		} else if (e.getSource() == �޴�1�������ư) {
			this.setVisible(false);
		} else if (e.getSource() == ��������ȸ����) {
			searchName = ��������ȸ��.getText().trim().toString();
			loginOK = 3;
			new BooksManager();
		} else if (e.getSource() == �����ݳ���) {
			minap_members();
		} else if (e.getSource() == �̳�ȸ����) {
			rentalList();
		} else if (e.getSource() == �뿩����å��Ϲ�) {
			members();
		} else if (e.getSource() == �뿩����å��Ϲ�) {
			config();
		} else if (e.getSource() == ȸ���߰���) {
			config();
		} else if (e.getSource() == ��üȸ����) {
			loginOK = 9;
			new BooksManager();
		} else if (e.getSource() == ������) {
			this.setVisible(false);
		} else if (e.getSource() == �뿩�ݾ׼�����) {
			config();
		} else if (e.getSource() == �űԵ����Է¹�) {
			config();
		} else if (e.getSource() == ������ü��Ϲ�) {
			config();
		} else if (e.getSource() == ����) {
			System.exit(1);
		}

	}

	void frametool_1() { // �α��� ���ӿ�

		GridLayout gr = new GridLayout(4, 2, 10, 10);
		this.setLayout(gr);
		this.add(lbid1);
		this.add(textid1);
		this.add(lbpw1);
		this.add(textpw1);
		this.add(lbresult1);
		this.add(lbblank1);
		this.add(btlogin1);
		this.add(btcancel1);
		btlogin1.addActionListener(this);
		btcancel1.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setSize(250, 150);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		xpos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		dbCon();// ����Ÿ���̽��� �����Ͽ� ����
	}

	void frametool_2() { // �޴������� Ŭ��â

		GridLayout gr = new GridLayout(15, 3, 5, 15);
		this.setLayout(gr);

		this.add(���������);
		this.add(lbblank2);
		this.add(lbblank3);
		this.add(�̸��Է¶�);
		this.add(���������̸�);
		this.add(���������̸���);
		this.add(ȸ����ȣ�Է¶�);
		this.add(��������ȸ��);
		this.add(��������ȸ����);
		this.add(�����ݳ���);
		this.add(lbblank4);
		this.add(lbblank5);
		this.add(�̸��Է¶�1);
		this.add(���������̸�1);
		this.add(�����ݳ���);
		this.add(�̳�ȸ����);
		this.add(lbblank6);
		this.add(lbblank7);
		this.add(�̸��Է¶�2);
		this.add(���������̸�2);
		this.add(�̳�ȸ����);
		this.add(�뿩����Ʈ��);
		this.add(lbblank8);
		this.add(lbblank9);
		this.add(�뿩����å��Ϲ�);
		this.add(�뿩����å��Ϲ�);
		this.add(lbblank19);
		this.add(ȸ��������);
		this.add(lbblank10);
		this.add(lbblank11);
		this.add(ȸ���߰���);
		this.add(��üȸ����);
		this.add(lbblank20);
		this.add(ȯ�漳����);
		this.add(lbblank12);
		this.add(lbblank13);
		this.add(�뿩�ݾ׼�����);
		this.add(�űԵ����Է¹�);
		this.add(������ü��Ϲ�);
		this.add(lbblank14);
		this.add(lbblank15);
		this.add(lbblank16);
		this.add(lbblank17);
		this.add(lbblank18);
		this.add(����);

		���������̸���.addActionListener(this);
		��������ȸ����.addActionListener(this);
		�����ݳ���.addActionListener(this);
		�̳�ȸ����.addActionListener(this);
		�뿩����å��Ϲ�.addActionListener(this);
		�뿩����å��Ϲ�.addActionListener(this);
		ȸ���߰���.addActionListener(this);
		��üȸ����.addActionListener(this);
		��üȸ����.addActionListener(this);
		�űԵ����Է¹�.addActionListener(this);
		������ü��Ϲ�.addActionListener(this);
		����.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(350, 600);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		xpos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		dbCon();// ����Ÿ���̽��� �����Ͽ� ����
	}

	void framemanu1() // �������� Ŭ���� �޴�
	{

		BorderLayout bt = new BorderLayout();
		this.setLayout(bt);
		this.add("North", �̸�);

		GridLayout gr = new GridLayout(4, 2);
		Panel p2 = new Panel(gr);

		p2.add(�������);
		p2.add(����������);
		p2.add(������ȣ��);
		p2.add(������ȣ����);
		p2.add(ī�װ���);
		p2.add(ī�װ�����);
		p2.add(ȸ���ؽ�Ʈ1);
		p2.add(�޴�1����);
		this.add("Center", p2);

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		Panel p1 = new Panel(flow);
		p1.add(�޴�1�������ư, "RIGHT");
		this.add("South", p1);

		�޴�1�������ư.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setSize(250, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		xpos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		dbCon();// ����Ÿ���̽��� �����Ͽ� ����

	}

	void framemanu2() // �����ݳ� Ŭ���� �޴�
	{
		BorderLayout bt = new BorderLayout();
		this.setLayout(bt);
		this.add("North", �̸�);

		GridLayout gr = new GridLayout(4, 2);
		Panel p2 = new Panel(gr);

		p2.add(�������);
		p2.add(����������);
		p2.add(������ȣ��);
		p2.add(������ȣ����);
		p2.add(ī�װ���);
		p2.add(ī�װ�����);
		p2.add(ȸ���ؽ�Ʈ1);
		p2.add(�޴�1����);
		this.add("Center", p2);

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		Panel p1 = new Panel(flow);
		p1.add(�޴�1�������ư, "RIGHT");
		this.add("South", p1);

		�޴�1�������ư.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setSize(250, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		xpos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		dbCon();// ����Ÿ���̽��� �����Ͽ� ����
	}

	void framemanu3() // �̳�ȸ�� Ŭ���� �޴�
	{

	}

	void framemanu4() // �뿩����Ʈ Ŭ���� �޴�
	{

	}

	void framemanu5() // ȸ������ Ŭ���� �޴�
	{

	}

	void framemanu6() // ȯ�漳�� Ŭ���� �޴�
	{

	}

	void framemanu7() // ȯ�漳�� Ŭ���� �޴�
	{

	}

	void framemanu8() // ��üȸ������
	{

		BorderLayout gr = new BorderLayout();
		this.setLayout(gr);
		this.add(ȸ���ؽ�Ʈ, "Center");
		Panel p = new Panel(new FlowLayout());
		p.add(������, "RIGHT");

		this.add("South", p);

		������.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(350, 150);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		xpos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		dbCon();// ����Ÿ���̽��� �����Ͽ� ����
	}

	void framemanu9() // ȯ�漳�� Ŭ���� �޴�
	{
	}

	void framemanu10() // ȯ�漳�� Ŭ���� �޴�
	{

	}

	//////////////////////////////////////////////////////////

	// 1.å�뿩
	void bookRental() {
		String retalName = "";
		String retalNumber = "";

		if (gubun == 1) {
			System.out.print("bookreltalname:�޼��� �Ϸ�Ż");
			retalName = sc.next();
			select(gubun, retalName);
		} else if (gubun == 2) {
			System.out.print("ȸ����ȣ:");
			retalNumber = sc.next();
			select(gubun, retalNumber);
		}
	}

	// 2.å�뿩
	void bookRentalEnd() {
		String retalName = "";
		String retalBookTitle = "";

		System.out.println("===========================");
		System.out.println("=====    2.�����ݳ�  ========");
		System.out.println("===========================");

		System.out.print("�����ڸ�:");
		retalName = sc.next();
		System.out.print("å����:");
		retalBookTitle = sc.next();

		minapCheck(retalName, retalBookTitle);

	}

	// 3.�̳�ȸ������
	void minap_members() {

		System.out.println("===========================");
		System.out.println("=====    3.�̳�����  ========");
		System.out.println("===========================");
		// �̳�ȸ������
		select("Y");

	}

	// 4.�뿩����Ʈ
	void rentalList() {

		System.out.println("===========================");
		System.out.println("=====    4.�뿩����Ʈ  ========");
		System.out.println("===========================");
		System.out.println("1.�뿩����å���");
		System.out.println("2.�뿩����å���");
		System.out.print("����:");
		int select = sc.nextInt();
		if (select == 1) {
			// �뿩������ å���
			retalBookSelect(1);
		} else if (select == 2) {
			// �뿩���� å���
			retalBookSelect(2);
		}

	}

	// 5.ȸ������
	void members() {

		System.out.println("===========================");
		System.out.println("=====    5.ȸ������  ========");
		System.out.println("===========================");

		System.out.println("1.ȸ���߰�");
		System.out.println("2.��üȸ������");
		System.out.print("����:");
		int select = sc.nextInt();
		if (select == 1) {
			System.out.print("ȸ����ȣ:");
			String inputNo = sc.next();
			System.out.print("�̸�:");
			String inputName = sc.next();
			System.out.print("����ó:");
			String inputTel = sc.next();
			System.out.print("�ּ�:");
			String inputAddr = sc.next();

			insert(inputNo, inputName, inputTel, inputAddr);

		} else if (select == 2) {
			// ��üȸ������
			select("A");
		}
	}

	// 6.ȯ�漳��
	void config() {
		// �ݾ׼����뺯��
		int bookMoneyUpdate = 0;
		String bookTitleUpdate = "";
		String bookNumberUpdate = "";
		// �����Է¿뺯��
		String bookTitle = "";
		int bookMoney = 0;
		int category = 1;
		String bookNumber = "10000";

		int sel = 0;

		System.out.println("===========================");
		System.out.println("=====    6.ȯ�漳��  ========");
		System.out.println("===========================");
		System.out.println("1.�뿩�ݾ׼���");
		System.out.println("2.�űԵ����Է�");
		System.out.println("3.������ü���");
		sel = sc.nextInt();
		if (sel == 1) {

			System.out.print("1.������ / 2.������ȣ : ");
			sel = sc.nextInt();
			if (sel == 1) {
				// ���������� ������� �ݾ�
				System.out.print("������:");
				bookTitleUpdate = sc.next();
				System.out.print("�뿩�ݾ׼���:");
				bookMoneyUpdate = sc.nextInt();
			} else if (sel == 2) {
				// ���������� ������ȣ�Է¿� �ݾ�
				System.out.print("������ȣ:");
				bookNumberUpdate = sc.next();
				System.out.print("�뿩�ݾ׼���:");
				bookMoneyUpdate = sc.nextInt();
			}

			update(sel, bookTitleUpdate, bookNumberUpdate, bookMoneyUpdate);

		} else if (sel == 2) {
			System.out.println("��������(1.��ȭå/2.�Ҽ�å):");
			category = sc.nextInt();
			System.out.println("������:");
			bookTitle = sc.next();
			System.out.println("�뿩�ݾ�:");
			bookMoney = sc.nextInt();
			System.out.println("������ȣ:");
			bookNumber = sc.next();
			// ī�װ� å���� �뿩���� ������ �μ�Ʈ ����
			insert(category, bookTitle, bookMoney, bookNumber);
		} else if (sel == 3) {
			System.out.println("<<<   ��ü ���� ��� ����Ʈ >>>");

			book_all_select();
		}
	}

	// �α���
	void login() // ������� �޼��� ���� ����
	{

		// System.out.print("���̵� : ");

		// System.out.print("�н����� : ");

		select(inputId, inputPw); // DB�����ؼ� üũ�Ҽ��ְ� ID������
	}

	// DB��������
	void dbCon() {

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.err.println("����̹��� ã���������ϴ�. ����!");
			System.exit(0);
		}

		conn = null;
		url = "jdbc:mysql://localhost:3306/books";
		id = "root";
		pass = "qwer";
		stmt = null;
		pstmt = null;
		rs = null;

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
			System.exit(0);
		}
	}

	// ������ü��� select
	void book_all_select() {

		query = "select * from tb_books";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("�뿩����=" + rs.getString("state") + ":" + "������ȣ=" + rs.getString("number") + ":"
						+ "����=" + rs.getString("title"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

	// �뿩���� å ����Ʈ
	void retalBookSelect(int gubun) {
		String query = "";
		if (gubun == 1) {
			// DB���� ������� ������� ���������� ������ɹ�
			query = "select * from tb_books where state='N';";
		} else if (gubun == 2) {
			query = "select * from tb_books where state='Y';";
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			int idx = 1;
			while (rs.next()) {

				System.out.println(idx + " :  " + "����:" + rs.getString("title"));

				idx++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	// �������� �� select
	void select1(String searchName) // ����� �̸��Է��ϸ� ���°�
	{
		String query = "";

		// DB���� ������� ������� ���������� ������ɹ�
		query = "select * from tb_members" + " where name='" + searchName + "'";

		�̸�.setText(searchName + "��");

		String tel = "";
		String name = "";
		String addr = "";
		String memberNumber = "";
		String state = "";

		System.out.println("dd" + searchName);

		String bookTitle = ����������.getText().trim().toString();
		System.out.println("������:" + bookTitle);
		String bookNumber = ������ȣ����.getText().trim().toString();
		System.out.println("������ȣ:" + bookNumber);
		int bookCategory = ī�װ�����.getColumns();
		System.out.println("ī�װ�(1.��ȭå/2.�Ҽ�):" + bookCategory);
		System.out.println("query1=" + query);

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// ��ȭ��ȣ / �̸� / ȸ����ȣ ����
				name = rs.getString("name");
				tel = rs.getString("tel");
				addr = rs.getString("addr");
				memberNumber = rs.getString("number");
				state = rs.getString("state");

				System.out.println(
						"name=" + name + "\n" + "tel=" + tel + "\n" + "addr=" + addr + "\n" + "state=" + state);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		insert(memberNumber, name, tel, addr, state, bookTitle, bookNumber, bookCategory);

	}

	void select2(String searchName) {
		String query = "";

		// DB���� ������� ������� ���������� ������ɹ�
		query = "select * from tb_members" + " where number='" + searchName + "'";

		String tel = "";
		String name = "";
		String addr = "";
		String memberNumber = "";
		String state = "";

		////////////////////////////////////////////////
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				name = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		�̸�.setText(name + "��");
		///////////////////////////////////////////////////

		String bookTitle = ����������.getText().trim().toString();
		System.out.println("������:" + bookTitle);
		String bookNumber = ������ȣ����.getText().trim().toString();
		System.out.println("������ȣ:" + bookNumber);
		int bookCategory = ī�װ�����.getColumns();
		System.out.println("ī�װ�(1.��ȭå/2.�Ҽ�):" + bookCategory);
		System.out.println("query1=" + query);

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// ��ȭ��ȣ / �̸� / ȸ����ȣ ����
				name = rs.getString("name");
				tel = rs.getString("tel");
				addr = rs.getString("addr");
				memberNumber = rs.getString("number");
				state = rs.getString("state");

				System.out.println(
						"name=" + name + "\n" + "tel=" + tel + "\n" + "addr=" + addr + "\n" + "state=" + state);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		insert(memberNumber, name, tel, addr, state, bookTitle, bookNumber, bookCategory);

	}

	void select(int gubun, String searchName) {
		String query = "";
		if (gubun == 1) {
			// DB���� ������� ������� ���������� ������ɹ�
			query = "select * from tb_members" + " where name='" + searchName + "'";
		} else if (gubun == 2) {
			// DB���� ������� ������� ���������� ������ɹ�
			query = "select * from tb_members" + " where number='" + searchName + "'";
		}

		String tel = "";
		String name = "";
		String addr = "";
		String memberNumber = "";
		String state = "";

		System.out.println("dd" + searchName);
		System.out.print("������:");
		String bookTitle = sc.next();
		System.out.print("������ȣ:");
		String bookNumber = sc.next();
		System.out.print("ī�װ�(1.��ȭå/2.�Ҽ�):");
		int bookCategory = sc.nextInt();
		System.out.println("query1=" + query);
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// ��ȭ��ȣ / �̸� / ȸ����ȣ ����
				name = rs.getString("name");
				tel = rs.getString("tel");
				addr = rs.getString("addr");
				memberNumber = rs.getString("number");
				state = rs.getString("state");

				System.out.println(
						"name=" + name + "\n" + "tel=" + tel + "\n" + "addr=" + addr + "\n" + "state=" + state);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		insert(memberNumber, name, tel, addr, state, bookTitle, bookNumber, bookCategory);

	}

	// ��üȸ������Ʈ ���� select
	void minapCheck(String name, String title) {
		// �̳��Ǽ� üũ
		int minapCount = 0;
		int minapMoney = 0;
		String query = "select * from tb_rental_member where" + " name ='" + name + "' AND" + " book_title ='" + title
				+ "' AND" + " minap_money > 0";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getInt("idx") + " :  " + "�̳���:" + rs.getString("minap_money") + " /  " + "ȸ����ȣ:"
						+ rs.getString("member_number") + " /  " + "�̸�:" + rs.getString("name") + " /  " + "����:"
						+ rs.getString("tel") + " /  " + "å����:" + rs.getString("book_title"));
				minapCount++;
				minapMoney += Integer.parseInt(rs.getString("minap_money"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		if (minapCount > 0) {
			System.out.println("��⳻������" + minapMoney + "�� �̳��ݾ��� �����մϴ�.");
			System.out.print("�����Ͻðڽ��ϱ�?(1.���� 2.���) : ");
			int minapOk = sc.nextInt();
			if (minapOk == 1) {
				System.out.println("name=" + name);
				System.out.println("title=" + title);
				System.out.println("minapMoney=" + minapMoney);

				// å�ݳ����� ���� ������Ʈ
				retalMemberUpdate(name, title, minapMoney);
				bookComeInUpdate(title);
				memberMinapUpdate(name);
			} else if (minapOk == 2) {
				System.out.println("������ �����ʰ� �������� ���ư��ϴ�!");
			}
		} else {
			bookComeInUpdate(title);
			memberMinapUpdate(name);
			System.out.println("���� �ݳ�ó���Ǿ����ϴ�!");
		}
	}

	// ��üȸ������Ʈ ���� select
	void select(String state) {
		String dd = "";
		String query = "";
		if (state.equals("Y")) {
			// DB���� ������� ������� ���������� ������ɹ�
			query = "select * from tb_members where state='Y';";
		} else if (state.equals("N")) {
			query = "select * from tb_members where state='N';";
		} else if (state.equals("A")) {
			query = "select * from tb_members;";
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getInt("idx") + " :  " + "�̳���:" + rs.getString("minap_money") + " /  " + "ȸ����ȣ:"
						+ rs.getString("number") + " /  " + "�̸�:" + rs.getString("name") + " /  " + "����:"
						+ rs.getString("tel") + " /  " + "�ּ�:" + rs.getString("addr"));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		ȸ���ؽ�Ʈ.setText(dd);
		/////// ���⼭ �ҷ����δ�!!!!!
	}

	void selectfulllist() {
		String dd = "";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_members;");

			while (rs.next()) {

				dd = rs.getInt("idx") + " :  " + "�̳���:" + rs.getString("minap_money") + " /  " + "ȸ����ȣ:"
						+ rs.getString("number") + " /  " + "�̸�:" + rs.getString("name") + " /  " + "����:"
						+ rs.getString("tel") + " /  " + "�ּ�:" + rs.getString("addr");

				ȸ���ؽ�Ʈ.setText(dd);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		ȸ���ؽ�Ʈ.setText(dd);
		/////// ���⼭ �ҷ����δ�!!!!!
	}

	// �α��� ��� �� select
	void select(String inputId, String inputPw) // �Ϸ�
	{

		String query = "select * from tb_admin";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (inputId.equals(rs.getString("id"))) {
					if (inputPw.equals(rs.getString("pw"))) {
						loginCheck = true;
						if (rs.getString("id").equals("admin")) {
							lbresult1.setText("������ �α��� ����!");
							loginOK = 1;

							try {
								Thread.sleep(1000);
								this.setVisible(false);
								new BooksManager();
							} catch (Exception e) {
							}
							loginOK = 1;
							break;

						}
						lbresult1.setText("�Ϲ� �α��� ����!");
						loginOK = 1;
						break;
					} else
						lbresult1.setText("�α��� ����! ���Է�!");
					loginCheck = false;
				} else
					lbresult1.setText("�α��� ����! ���Է�!");
				loginCheck = false;

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

	// �������� �� insert
	void insert(String memberNumber, String name, String tel, String addr, String state, String bookTitle,
			String bookNumber, int bookCategory) // ����
	{
		// DB�� ���� ����ݾ�
		int money = 0;
		// �ݾ׻���
		int retalMoeny = 0;
		int minapMoney = 0;
		// ������/�İ��� ����
		int gubun = 0;

		System.out.print("1.������ / 2.�İ��� : ");
		gubun = sc.nextInt();

		// ī�װ��� ���� �ݾ� ����
		if (bookCategory == 1) {
			retalMoeny = 500;
		} else if (bookCategory == 2) {
			retalMoeny = 1000;
		}

		// ������
		if (gubun == 1) { // ���п����� ����ó���Ϸ�
			minapMoney = 0;
			money = retalMoeny;
		}
		// �İ���
		else if (gubun == 2) {
			// �̳����°� Y
			state = "Y";
			minapMoney = retalMoeny;
			money = 0;
			// �̳��� �߻��� ȸ�������� ���� �̳��� ����������Ʈ
			minap_update(name, minapMoney);
		}
		// DB���� ������� ������� ���������� ������ɹ�
		query = "insert into tb_rental_member values (null" + "," + memberNumber + "," + "'" + name + "'" + "," + tel
				+ "," + minapMoney + "," + "'" + bookTitle + "'" + "," + bookNumber + "," + money + "," + "now());";

		System.out.println("query2=" + query);
		// conn������ ���ӻ��¸� �����Ͽ� ������ ����
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		// å ���� ���� ������Ʈ
		retal_update(bookTitle);

	}

	// ȸ�����Խ� insert
	void insert(String inputNo, String inputName, String inputTel, String inputAddr) // ����
	{
		String state = "N";
		int minap_money = 0;
		// DB���� ������� ������� ���������� ������ɹ�
		String query = "insert into tb_members values (null, ?,?,?,?,?,?)";

		// conn������ ���ӻ��¸� �����Ͽ� ������ ����
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputTel);
			pstmt.setString(3, inputAddr);
			pstmt.setString(4, inputNo);
			pstmt.setString(5, state);
			pstmt.setInt(6, minap_money);
			pstmt.executeUpdate();
			System.out.println("���༺��");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	// ���� �Է½� insert
	void insert(int category, String bookTitle, int bookMoney, String bookNumber) // ����
	{

		String state = "n";

		// DB���� ������� ������� ���������� ������ɹ�
		String query = "insert into tb_books values (null, ?,?,?,?,?)";

		// conn������ ���ӻ��¸� �����Ͽ� ������ ����
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			pstmt.setString(2, bookNumber);
			pstmt.setInt(3, category);
			pstmt.setInt(4, bookMoney);
			pstmt.setString(5, state);

			pstmt.executeUpdate();
			System.out.println("���༺��");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	void delete() // ����
	{
		System.out.print("�������̸�:  ");
		String inputName = sc.next();

		// DB���� ������� ������� ���������� ������ɹ�
		String query = "DELETE FROM tb_data Where name='" + inputName + "'";

		System.out.println(query);
		// conn������ ���ӻ��¸� �����Ͽ� ������ ����
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("\nȸ���� :" + inputName + "�� �����Ǿ����ϴ�.\n");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// ���� �ݾ׼���
	void update(int sel, String bookTitleUpdate, String bookNumberUpdate, int bookMoneyUpdate) // ����
	{
		String query = "";
		System.out.println("sel   :  " + sel);
		if (sel == 1) {
			// ������������� ������Ʈ
			query = "UPDATE tb_books SET " + "money='" + bookMoneyUpdate + "' " + "Where title='" + bookTitleUpdate
					+ "'";
		} else if (sel == 2) {
			// ������ȣ �������� ������Ʈ
			query = "UPDATE tb_books SET " + "money='" + bookMoneyUpdate + "' Where number='" + bookNumberUpdate + "'";
		}
		System.out.println("query: " + query);
		// System.out.println(query);
		// conn������ ���ӻ��¸� �����Ͽ� ������ ����
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// �̳��� ���� ������Ʈ
	void minap_update(String name, int minap_money) // ����
	{
		String query = "UPDATE tb_members SET " + "minap_money='" + minap_money + "', " + "state='Y' " + "Where name='"
				+ name + "'";
		System.out.println("�̳�������Ʈquery=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// ���� ���� ���� ������Ʈ
	void retal_update(String title) // ����
	{
		String query = "UPDATE tb_books SET " + "state='Y' " + "Where title='" + title + "'";
		System.out.println("å�뿩���¾�����Ʈ!=" + query);

		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// �ݳ����� ���� ������Ʈ
	void retalMemberUpdate(String name, String title, int money) {
		String query = "UPDATE tb_rental_member SET " + "minap_money='0', " + "money='" + money + "' "
				+ "Where book_title='" + title + "'";
		System.out.println("�ݳ���������=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// �ݳ����� ������ ������Ʈ
	void bookComeInUpdate(String retalBookTitle) {
		String query = "UPDATE tb_books SET " + "state='N' " + "Where title='" + retalBookTitle + "'";
		System.out.println("å�뿩���¾�����Ʈ!=" + query);

		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}

	// �ݳ����� ���� ��� �̳��� ó��
	void memberMinapUpdate(String name) {
		String query = "UPDATE tb_members SET " + "state='N', " + "minap_money='0' " + "Where name='" + name + "'";
		System.out.println("�̳�ó��!=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}
	}
}
