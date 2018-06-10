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

	/////////////////// 로그인용/////////////////////////
	private Label lbid1 = new Label("아 이 디:");
	private Label lbpw1 = new Label("패스워드:");
	private Label lbresult1 = new Label("로그인 입력...");
	private Label lbblank1 = new Label("");
	private TextField textid1 = new TextField("");
	private TextField textpw1 = new TextField("");
	private Button btlogin1 = new Button("로그인");
	private Button btcancel1 = new Button("취소");
	/////////////////////////////////////////////////////////

	/////////////////// 메인선택 버튼//////////////////////////////
	private Label 도서대출라 = new Label("1. 도 서 대 출");
	private Label 이름입력라 = new Label("이름입력");
	private Label 이름입력라1 = new Label("이름입력");
	private Label 이름입력라2 = new Label("이름입력");
	private Label 회원번호입력라 = new Label("회원번호입력");
	private Label 도서반납라 = new Label("2. 도 서 반 납");
	private Label 미납회원라 = new Label("3. 미 납 회 원");
	private Label 대여리스트라 = new Label("4. 대 여 리 스 트");
	private Label 회원관리라 = new Label("5. 회 원 관 리");
	private Label 환경설정라 = new Label("6. 환 경 설 정 ");
	private Button 도서대출이름버 = new Button("확인");
	private Button 도서대출회원버 = new Button("확인");
	private Button 도서반납버 = new Button("확인");
	private Button 미납회원버 = new Button("확인");
	private Button 대여가능책목록버 = new Button("대여가능책목록");
	private Button 대여중인책목록버 = new Button("대여가능책목록");
	private Button 회원추가버 = new Button("회원추가");
	private Button 전체회원버 = new Button("전체회원보기");
	private Button 대여금액설정버 = new Button("대여금액설정");
	private Button 신규도서입력버 = new Button("신규도서입력");
	private Button 도서전체목록버 = new Button("도서전체목록");
	private Button 종료 = new Button(" ===종 료=== ");
	private TextField 도서대출이름 = new TextField("");
	private TextField 도서대출이름1 = new TextField("");
	private TextField 도서대출이름2 = new TextField("");
	private TextField 도서대출회원 = new TextField("");
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
	Label 이름 = new Label("");
	Label 메뉴2공란 = new Label("");
	Label 도서명라벨 = new Label("도서명:");
	TextField 도서명텍필 = new TextField("");
	Label 도서번호라벨 = new Label("도서번호:");
	TextField 도서번호텍필 = new TextField("");
	Label 카테고리라벨 = new Label("카테고리(1만화/2소설");
	TextField 카테고리텍필 = new TextField("");
	Label 메뉴1공란 = new Label("");
	Button 메뉴1나가기버튼 = new Button("나가기");
	int gubun;
	TextArea 회원텍스트1 = new TextArea("");

	////////// 9회원보기
	TextArea 회원텍스트 = new TextArea("");
	Button 나가기 = new Button("나가기");

	///////////////////////////////////////////////////////////////

	/////////////////////////////
	// DB 접속관련 변수
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
	static boolean loginCheck = false; // 로그인상태제어
	static int loginOK = 0; //

	int select;

	BooksManager() {
		super("도서대여 프로그램");
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
		} else if (e.getSource() == 도서대출이름버) {
			searchName = 도서대출이름.getText().trim().toString();
			loginOK = 2;

			framemanu1();

		} else if (e.getSource() == 메뉴1나가기버튼) {
			this.setVisible(false);
		} else if (e.getSource() == 도서대출회원버) {
			searchName = 도서대출회원.getText().trim().toString();
			loginOK = 3;
			new BooksManager();
		} else if (e.getSource() == 도서반납버) {
			minap_members();
		} else if (e.getSource() == 미납회원버) {
			rentalList();
		} else if (e.getSource() == 대여가능책목록버) {
			members();
		} else if (e.getSource() == 대여중인책목록버) {
			config();
		} else if (e.getSource() == 회원추가버) {
			config();
		} else if (e.getSource() == 전체회원버) {
			loginOK = 9;
			new BooksManager();
		} else if (e.getSource() == 나가기) {
			this.setVisible(false);
		} else if (e.getSource() == 대여금액설정버) {
			config();
		} else if (e.getSource() == 신규도서입력버) {
			config();
		} else if (e.getSource() == 도서전체목록버) {
			config();
		} else if (e.getSource() == 종료) {
			System.exit(1);
		}

	}

	void frametool_1() { // 로그인 접속용

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
		dbCon();// 데이타베이스에 접속하여 셋팅
	}

	void frametool_2() { // 메뉴페이지 클릭창

		GridLayout gr = new GridLayout(15, 3, 5, 15);
		this.setLayout(gr);

		this.add(도서대출라);
		this.add(lbblank2);
		this.add(lbblank3);
		this.add(이름입력라);
		this.add(도서대출이름);
		this.add(도서대출이름버);
		this.add(회원번호입력라);
		this.add(도서대출회원);
		this.add(도서대출회원버);
		this.add(도서반납라);
		this.add(lbblank4);
		this.add(lbblank5);
		this.add(이름입력라1);
		this.add(도서대출이름1);
		this.add(도서반납버);
		this.add(미납회원라);
		this.add(lbblank6);
		this.add(lbblank7);
		this.add(이름입력라2);
		this.add(도서대출이름2);
		this.add(미납회원버);
		this.add(대여리스트라);
		this.add(lbblank8);
		this.add(lbblank9);
		this.add(대여가능책목록버);
		this.add(대여중인책목록버);
		this.add(lbblank19);
		this.add(회원관리라);
		this.add(lbblank10);
		this.add(lbblank11);
		this.add(회원추가버);
		this.add(전체회원버);
		this.add(lbblank20);
		this.add(환경설정라);
		this.add(lbblank12);
		this.add(lbblank13);
		this.add(대여금액설정버);
		this.add(신규도서입력버);
		this.add(도서전체목록버);
		this.add(lbblank14);
		this.add(lbblank15);
		this.add(lbblank16);
		this.add(lbblank17);
		this.add(lbblank18);
		this.add(종료);

		도서대출이름버.addActionListener(this);
		도서대출회원버.addActionListener(this);
		도서반납버.addActionListener(this);
		미납회원버.addActionListener(this);
		대여가능책목록버.addActionListener(this);
		대여중인책목록버.addActionListener(this);
		회원추가버.addActionListener(this);
		전체회원버.addActionListener(this);
		전체회원버.addActionListener(this);
		신규도서입력버.addActionListener(this);
		도서전체목록버.addActionListener(this);
		종료.addActionListener(this);

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
		dbCon();// 데이타베이스에 접속하여 셋팅
	}

	void framemanu1() // 도서대출 클릭시 메뉴
	{

		BorderLayout bt = new BorderLayout();
		this.setLayout(bt);
		this.add("North", 이름);

		GridLayout gr = new GridLayout(4, 2);
		Panel p2 = new Panel(gr);

		p2.add(도서명라벨);
		p2.add(도서명텍필);
		p2.add(도서번호라벨);
		p2.add(도서번호텍필);
		p2.add(카테고리라벨);
		p2.add(카테고리텍필);
		p2.add(회원텍스트1);
		p2.add(메뉴1공란);
		this.add("Center", p2);

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		Panel p1 = new Panel(flow);
		p1.add(메뉴1나가기버튼, "RIGHT");
		this.add("South", p1);

		메뉴1나가기버튼.addActionListener(this);

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
		dbCon();// 데이타베이스에 접속하여 셋팅

	}

	void framemanu2() // 도서반납 클릭시 메뉴
	{
		BorderLayout bt = new BorderLayout();
		this.setLayout(bt);
		this.add("North", 이름);

		GridLayout gr = new GridLayout(4, 2);
		Panel p2 = new Panel(gr);

		p2.add(도서명라벨);
		p2.add(도서명텍필);
		p2.add(도서번호라벨);
		p2.add(도서번호텍필);
		p2.add(카테고리라벨);
		p2.add(카테고리텍필);
		p2.add(회원텍스트1);
		p2.add(메뉴1공란);
		this.add("Center", p2);

		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		Panel p1 = new Panel(flow);
		p1.add(메뉴1나가기버튼, "RIGHT");
		this.add("South", p1);

		메뉴1나가기버튼.addActionListener(this);

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
		dbCon();// 데이타베이스에 접속하여 셋팅
	}

	void framemanu3() // 미납회원 클릭시 메뉴
	{

	}

	void framemanu4() // 대여리스트 클릭시 메뉴
	{

	}

	void framemanu5() // 회원관리 클릭시 메뉴
	{

	}

	void framemanu6() // 환경설정 클릭시 메뉴
	{

	}

	void framemanu7() // 환경설정 클릭시 메뉴
	{

	}

	void framemanu8() // 전체회원보기
	{

		BorderLayout gr = new BorderLayout();
		this.setLayout(gr);
		this.add(회원텍스트, "Center");
		Panel p = new Panel(new FlowLayout());
		p.add(나가기, "RIGHT");

		this.add("South", p);

		나가기.addActionListener(this);

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
		dbCon();// 데이타베이스에 접속하여 셋팅
	}

	void framemanu9() // 환경설정 클릭시 메뉴
	{
	}

	void framemanu10() // 환경설정 클릭시 메뉴
	{

	}

	//////////////////////////////////////////////////////////

	// 1.책대여
	void bookRental() {
		String retalName = "";
		String retalNumber = "";

		if (gubun == 1) {
			System.out.print("bookreltalname:메서드 북렌탈");
			retalName = sc.next();
			select(gubun, retalName);
		} else if (gubun == 2) {
			System.out.print("회원번호:");
			retalNumber = sc.next();
			select(gubun, retalNumber);
		}
	}

	// 2.책대여
	void bookRentalEnd() {
		String retalName = "";
		String retalBookTitle = "";

		System.out.println("===========================");
		System.out.println("=====    2.도서반납  ========");
		System.out.println("===========================");

		System.out.print("대출자명:");
		retalName = sc.next();
		System.out.print("책제목:");
		retalBookTitle = sc.next();

		minapCheck(retalName, retalBookTitle);

	}

	// 3.미납회원관리
	void minap_members() {

		System.out.println("===========================");
		System.out.println("=====    3.미납관리  ========");
		System.out.println("===========================");
		// 미납회원보기
		select("Y");

	}

	// 4.대여리스트
	void rentalList() {

		System.out.println("===========================");
		System.out.println("=====    4.대여리스트  ========");
		System.out.println("===========================");
		System.out.println("1.대여가능책목록");
		System.out.println("2.대여중인책목록");
		System.out.print("선택:");
		int select = sc.nextInt();
		if (select == 1) {
			// 대여대기상태 책목록
			retalBookSelect(1);
		} else if (select == 2) {
			// 대여중인 책목록
			retalBookSelect(2);
		}

	}

	// 5.회원관리
	void members() {

		System.out.println("===========================");
		System.out.println("=====    5.회원관리  ========");
		System.out.println("===========================");

		System.out.println("1.회원추가");
		System.out.println("2.전체회원보기");
		System.out.print("선택:");
		int select = sc.nextInt();
		if (select == 1) {
			System.out.print("회원번호:");
			String inputNo = sc.next();
			System.out.print("이름:");
			String inputName = sc.next();
			System.out.print("연락처:");
			String inputTel = sc.next();
			System.out.print("주소:");
			String inputAddr = sc.next();

			insert(inputNo, inputName, inputTel, inputAddr);

		} else if (select == 2) {
			// 전체회원보기
			select("A");
		}
	}

	// 6.환경설정
	void config() {
		// 금액설정용변수
		int bookMoneyUpdate = 0;
		String bookTitleUpdate = "";
		String bookNumberUpdate = "";
		// 도서입력용변수
		String bookTitle = "";
		int bookMoney = 0;
		int category = 1;
		String bookNumber = "10000";

		int sel = 0;

		System.out.println("===========================");
		System.out.println("=====    6.환경설정  ========");
		System.out.println("===========================");
		System.out.println("1.대여금액설정");
		System.out.println("2.신규도서입력");
		System.out.println("3.도서전체목록");
		sel = sc.nextInt();
		if (sel == 1) {

			System.out.print("1.도서명 / 2.도서번호 : ");
			sel = sc.nextInt();
			if (sel == 1) {
				// 설정변경할 도서명과 금액
				System.out.print("도서명:");
				bookTitleUpdate = sc.next();
				System.out.print("대여금액설정:");
				bookMoneyUpdate = sc.nextInt();
			} else if (sel == 2) {
				// 설정변경할 도서번호입력와 금액
				System.out.print("도서번호:");
				bookNumberUpdate = sc.next();
				System.out.print("대여금액설정:");
				bookMoneyUpdate = sc.nextInt();
			}

			update(sel, bookTitleUpdate, bookNumberUpdate, bookMoneyUpdate);

		} else if (sel == 2) {
			System.out.println("도서선택(1.만화책/2.소설책):");
			category = sc.nextInt();
			System.out.println("도서명:");
			bookTitle = sc.next();
			System.out.println("대여금액:");
			bookMoney = sc.nextInt();
			System.out.println("도서번호:");
			bookNumber = sc.next();
			// 카테고리 책제목 대여금을 가지고 인서트 전달
			insert(category, bookTitle, bookMoney, bookNumber);
		} else if (sel == 3) {
			System.out.println("<<<   전체 도서 목록 리스트 >>>");

			book_all_select();
		}
	}

	// 로그인
	void login() // 쓸모없는 메서드 추후 삭제
	{

		// System.out.print("아이디 : ");

		// System.out.print("패스워드 : ");

		select(inputId, inputPw); // DB접속해서 체크할수있게 ID보내기
	}

	// DB접속정보
	void dbCon() {

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.err.println("드라이버를 찾을수없습니다. 종료!");
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

	// 도서전체목록 select
	void book_all_select() {

		query = "select * from tb_books";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("대여상태=" + rs.getString("state") + ":" + "도서번호=" + rs.getString("number") + ":"
						+ "제목=" + rs.getString("title"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

	// 대여중인 책 리스트
	void retalBookSelect(int gubun) {
		String query = "";
		if (gubun == 1) {
			// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
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

				System.out.println(idx + " :  " + "제목:" + rs.getString("title"));

				idx++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	// 도서대출 시 select
	void select1(String searchName) // 대출시 이름입력하면 들어가는곳
	{
		String query = "";

		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
		query = "select * from tb_members" + " where name='" + searchName + "'";

		이름.setText(searchName + "님");

		String tel = "";
		String name = "";
		String addr = "";
		String memberNumber = "";
		String state = "";

		System.out.println("dd" + searchName);

		String bookTitle = 도서명텍필.getText().trim().toString();
		System.out.println("도서명:" + bookTitle);
		String bookNumber = 도서번호텍필.getText().trim().toString();
		System.out.println("도서번호:" + bookNumber);
		int bookCategory = 카테고리텍필.getColumns();
		System.out.println("카테고리(1.만화책/2.소설):" + bookCategory);
		System.out.println("query1=" + query);

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// 전화번호 / 이름 / 회원번호 저장
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

		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
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
		이름.setText(name + "님");
		///////////////////////////////////////////////////

		String bookTitle = 도서명텍필.getText().trim().toString();
		System.out.println("도서명:" + bookTitle);
		String bookNumber = 도서번호텍필.getText().trim().toString();
		System.out.println("도서번호:" + bookNumber);
		int bookCategory = 카테고리텍필.getColumns();
		System.out.println("카테고리(1.만화책/2.소설):" + bookCategory);
		System.out.println("query1=" + query);

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// 전화번호 / 이름 / 회원번호 저장
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
			// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
			query = "select * from tb_members" + " where name='" + searchName + "'";
		} else if (gubun == 2) {
			// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
			query = "select * from tb_members" + " where number='" + searchName + "'";
		}

		String tel = "";
		String name = "";
		String addr = "";
		String memberNumber = "";
		String state = "";

		System.out.println("dd" + searchName);
		System.out.print("도서명:");
		String bookTitle = sc.next();
		System.out.print("도서번호:");
		String bookNumber = sc.next();
		System.out.print("카테고리(1.만화책/2.소설):");
		int bookCategory = sc.nextInt();
		System.out.println("query1=" + query);
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// 전화번호 / 이름 / 회원번호 저장
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

	// 전체회원리스트 사용시 select
	void minapCheck(String name, String title) {
		// 미납건수 체크
		int minapCount = 0;
		int minapMoney = 0;
		String query = "select * from tb_rental_member where" + " name ='" + name + "' AND" + " book_title ='" + title
				+ "' AND" + " minap_money > 0";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getInt("idx") + " :  " + "미납금:" + rs.getString("minap_money") + " /  " + "회원번호:"
						+ rs.getString("member_number") + " /  " + "이름:" + rs.getString("name") + " /  " + "전번:"
						+ rs.getString("tel") + " /  " + "책제목:" + rs.getString("book_title"));
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
			System.out.println("상기내용으로" + minapMoney + "원 미납금액이 존재합니다.");
			System.out.print("정산하시겠습니까?(1.정산 2.취소) : ");
			int minapOk = sc.nextInt();
			if (minapOk == 1) {
				System.out.println("name=" + name);
				System.out.println("title=" + title);
				System.out.println("minapMoney=" + minapMoney);

				// 책반납으로 인한 업데이트
				retalMemberUpdate(name, title, minapMoney);
				bookComeInUpdate(title);
				memberMinapUpdate(name);
			} else if (minapOk == 2) {
				System.out.println("정산을 하지않고 메인으로 돌아갑니다!");
			}
		} else {
			bookComeInUpdate(title);
			memberMinapUpdate(name);
			System.out.println("정상 반납처리되었습니다!");
		}
	}

	// 전체회원리스트 사용시 select
	void select(String state) {
		String dd = "";
		String query = "";
		if (state.equals("Y")) {
			// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
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

				System.out.println(rs.getInt("idx") + " :  " + "미납금:" + rs.getString("minap_money") + " /  " + "회원번호:"
						+ rs.getString("number") + " /  " + "이름:" + rs.getString("name") + " /  " + "전번:"
						+ rs.getString("tel") + " /  " + "주소:" + rs.getString("addr"));

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		회원텍스트.setText(dd);
		/////// 여기서 불러들인다!!!!!
	}

	void selectfulllist() {
		String dd = "";

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_members;");

			while (rs.next()) {

				dd = rs.getInt("idx") + " :  " + "미납금:" + rs.getString("minap_money") + " /  " + "회원번호:"
						+ rs.getString("number") + " /  " + "이름:" + rs.getString("name") + " /  " + "전번:"
						+ rs.getString("tel") + " /  " + "주소:" + rs.getString("addr");

				회원텍스트.setText(dd);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		회원텍스트.setText(dd);
		/////// 여기서 불러들인다!!!!!
	}

	// 로그인 사용 시 select
	void select(String inputId, String inputPw) // 완료
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
							lbresult1.setText("관리자 로그인 성공!");
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
						lbresult1.setText("일반 로그인 성공!");
						loginOK = 1;
						break;
					} else
						lbresult1.setText("로그인 실패! 재입력!");
					loginCheck = false;
				} else
					lbresult1.setText("로그인 실패! 재입력!");
				loginCheck = false;

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

	// 도서대출 시 insert
	void insert(String memberNumber, String name, String tel, String addr, String state, String bookTitle,
			String bookNumber, int bookCategory) // 삽입
	{
		// DB에 넣은 매출금액
		int money = 0;
		// 금액산전
		int retalMoeny = 0;
		int minapMoney = 0;
		// 선결제/후결제 선택
		int gubun = 0;

		System.out.print("1.선결제 / 2.후결제 : ");
		gubun = sc.nextInt();

		// 카테고리에 따른 금액 설정
		if (bookCategory == 1) {
			retalMoeny = 500;
		} else if (bookCategory == 2) {
			retalMoeny = 1000;
		}

		// 선결제
		if (gubun == 1) { // 구분에따라서 결제처리완료
			minapMoney = 0;
			money = retalMoeny;
		}
		// 후결제
		else if (gubun == 2) {
			// 미납상태가 Y
			state = "Y";
			minapMoney = retalMoeny;
			money = 0;
			// 미납금 발생시 회원정보로 가서 미납금 누적업데이트
			minap_update(name, minapMoney);
		}
		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
		query = "insert into tb_rental_member values (null" + "," + memberNumber + "," + "'" + name + "'" + "," + tel
				+ "," + minapMoney + "," + "'" + bookTitle + "'" + "," + bookNumber + "," + money + "," + "now());";

		System.out.println("query2=" + query);
		// conn변수로 접속상태를 생성하여 저장할 변수
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		// 책 대출 상태 업데이트
		retal_update(bookTitle);

	}

	// 회원가입시 insert
	void insert(String inputNo, String inputName, String inputTel, String inputAddr) // 삽입
	{
		String state = "N";
		int minap_money = 0;
		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
		String query = "insert into tb_members values (null, ?,?,?,?,?,?)";

		// conn변수로 접속상태를 생성하여 저장할 변수
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
			System.out.println("실행성공");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	// 도서 입력시 insert
	void insert(int category, String bookTitle, int bookMoney, String bookNumber) // 삽입
	{

		String state = "n";

		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
		String query = "insert into tb_books values (null, ?,?,?,?,?)";

		// conn변수로 접속상태를 생성하여 저장할 변수
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
			System.out.println("실행성공");

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	void delete() // 삭제
	{
		System.out.print("삭제할이름:  ");
		String inputName = sc.next();

		// DB에서 명령으로 결과값을 가져오게할 쿼리명령문
		String query = "DELETE FROM tb_data Where name='" + inputName + "'";

		System.out.println(query);
		// conn변수로 접속상태를 생성하여 저장할 변수
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("\n회원명 :" + inputName + "가 삭제되었습니다.\n");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 도서 금액설정
	void update(int sel, String bookTitleUpdate, String bookNumberUpdate, int bookMoneyUpdate) // 수정
	{
		String query = "";
		System.out.println("sel   :  " + sel);
		if (sel == 1) {
			// 도서명기준으로 업데이트
			query = "UPDATE tb_books SET " + "money='" + bookMoneyUpdate + "' " + "Where title='" + bookTitleUpdate
					+ "'";
		} else if (sel == 2) {
			// 도서번호 기준으로 업데이트
			query = "UPDATE tb_books SET " + "money='" + bookMoneyUpdate + "' Where number='" + bookNumberUpdate + "'";
		}
		System.out.println("query: " + query);
		// System.out.println(query);
		// conn변수로 접속상태를 생성하여 저장할 변수
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 미납금 누적 업데이트
	void minap_update(String name, int minap_money) // 수정
	{
		String query = "UPDATE tb_members SET " + "minap_money='" + minap_money + "', " + "state='Y' " + "Where name='"
				+ name + "'";
		System.out.println("미납업데이트query=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 서적 대출 상태 업데이트
	void retal_update(String title) // 수정
	{
		String query = "UPDATE tb_books SET " + "state='Y' " + "Where title='" + title + "'";
		System.out.println("책대여상태업데이트!=" + query);

		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 반납으로 인한 업데이트
	void retalMemberUpdate(String name, String title, int money) {
		String query = "UPDATE tb_rental_member SET " + "minap_money='0', " + "money='" + money + "' "
				+ "Where book_title='" + title + "'";
		System.out.println("반납상태쿼리=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 반납으로 대출자 업데이트
	void bookComeInUpdate(String retalBookTitle) {
		String query = "UPDATE tb_books SET " + "state='N' " + "Where title='" + retalBookTitle + "'";
		System.out.println("책대여상태업데이트!=" + query);

		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}

	// 반납으로 인한 멤버 미납금 처리
	void memberMinapUpdate(String name) {
		String query = "UPDATE tb_members SET " + "state='N', " + "minap_money='0' " + "Where name='" + name + "'";
		System.out.println("미납처리!=" + query);
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
	}
}
