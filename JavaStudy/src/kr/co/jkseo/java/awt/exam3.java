package kr.co.jkseo.java.awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class exam3 {
	public static void main(String[] args) {
		LoginPg2 login = new LoginPg2();
	}
}

class LoginPg2 extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	private Label lbId = new Label("아 이 디 : ");
	private Label lbPw = new Label("패스워드 : ");
	private Label lbResult = new Label("로그인 대기중...");
	private Label lbSpace = new Label("");
	private Label lbSpace2 = new Label("");

	private TextField tfId = new TextField("");
	private TextField tfPw = new TextField("");

	private Button btLogin = new Button("로그인");
	private Button btCancel = new Button("종 료");
	private Button btNew = new Button("회원가입");

	////////////////////////////////////////////////

	private Label lbId1 = new Label("아 이 디 : ");
	private Label lbPw1 = new Label("패스워드 : ");
	private Label lbName = new Label("이름 : ");
	private Label lbAge = new Label("나이 : ");
	private Label lbTel = new Label("연락처 : ");
	private Label lbment = new Label("");
	private Label lbblack = new Label("");

	private TextField tfId1 = new TextField("");
	private TextField tfPw1 = new TextField("");
	private TextField tfName = new TextField("");
	private TextField tfAge = new TextField("");
	private TextField tfTel = new TextField("");

	private Button btOk = new Button("확인");
	private Button btCancel1 = new Button("취소");
	private Button btIdCheck = new Button("아이디중복체크");
	private Button btReinput = new Button("다시입력");

	static int loginOK = 0;
	static String newone[][] = new String[100][5];
	static int count = 0;
	static String inputid = "";
	static String inputpw = "";
	static String inputname = "";
	static String inputage = "0";
	static String inputtel = "0";

	LoginPg2() {
		super("로그인프로그램");
		if (loginOK == 0) {
			init();
		} else if (loginOK == 1) {
			init2();
		}
	}

	void init() {
		GridLayout grid = new GridLayout(5, 2, 5, 5);
		this.setLayout(grid);
		this.add(lbId);
		this.add(tfId);
		this.add(lbPw);
		this.add(tfPw);
		this.add(lbResult);
		this.add(lbSpace);
		this.add(lbSpace2);
		this.add(btLogin);
		this.add(btNew);
		this.add(btCancel);

		btLogin.addActionListener(this);
		btCancel.addActionListener(this);
		btNew.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(300, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	void init2() {
		GridLayout grid = new GridLayout(8, 2, 5, 5);
		this.setLayout(grid);
		this.add(lbId1);
		this.add(tfId1);
		this.add(btIdCheck);
		this.add(lbblack);
		this.add(lbPw1);
		this.add(tfPw1);
		this.add(lbName);
		this.add(tfName);
		this.add(lbAge);
		this.add(tfAge);
		this.add(lbTel);
		this.add(tfTel);
		this.add(lbment);
		this.add(btReinput);
		this.add(btOk);
		this.add(btCancel1);

		btOk.addActionListener(this);
		btCancel1.addActionListener(this);
		btIdCheck.addActionListener(this);
		btReinput.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setSize(300, 300);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inputid = tfId1.getText().trim().toString();
		inputpw = tfPw1.getText().trim().toString();
		inputname = tfName.getText().trim().toString();
		inputage = tfAge.getText().trim().toString();
		inputtel = tfTel.getText().trim().toString();

		if (e.getSource() == btLogin) {
			String inputId = tfId.getText().trim().toString();
			String inputPw = tfPw.getText().trim().toString();

			for (int i = 0; i < count; i++) {
				if (inputId.equals(newone[i][0]) && inputPw.equals(newone[i][1])) {
					lbResult.setText("로그인 성공!");
				} else {
					lbResult.setText("로그인 실패!");
				}
			}
		} else if (e.getSource() == btCancel) {
			System.exit(1);
		} else if (e.getSource() == btNew) {
			this.setVisible(false);
			System.out.println("dddd");
			loginOK = 1;
			new LoginPg2();

		} else if (e.getSource() == btIdCheck) {

			String idChack = tfId1.getText().trim().toString();
			for (int i = 0; i < count; i++) {
				if (idChack.equals(newone[i][0])) {
					lbblack.setText("아이디 중복 다시입력");
					try {
						Thread.sleep(1000);
						lbblack.setText(" ");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else if (idChack != newone[i][0]) {
					lbblack.setText("아이디 생성 가능 ");
					try {
						Thread.sleep(1000);
						lbblack.setText(" ");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else if (e.getSource() == btReinput) {
			tfId1.setText("");
			tfPw1.setText("");
			tfName.setText("");
			tfAge.setText("");
			tfTel.setText("");

		} else if (e.getSource() == btOk) {

			newone[count][0] = inputid;
			newone[count][1] = inputpw;
			newone[count][2] = inputname;
			newone[count][3] = inputage;
			newone[count][4] = inputtel;
			count++;

			lbment.setText("회원가입 되었습니다.");
			try {
				Thread.sleep(1000);
				lbment.setText(" ");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == btCancel1) {
			this.setVisible(false);
			loginOK = 0;
			new LoginPg2();
		}

	}
}
