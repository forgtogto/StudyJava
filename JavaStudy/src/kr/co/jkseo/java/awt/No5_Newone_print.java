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

public class No5_Newone_print {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Newone neww = new Newone();
	}
}

@SuppressWarnings("serial")
class Newone extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	private Label lbId = new Label("아 이 디 : ");
	private Label lbPw = new Label("패스워드 : ");
	private Label lbName = new Label("이름 : ");
	private Label lbAge = new Label("나이 : ");
	private Label lbTel = new Label("연락처 : ");

	private TextField tfId = new TextField("");
	private TextField tfPw = new TextField("");
	private TextField tfName = new TextField("");
	private TextField tfAge = new TextField("");
	private TextField tfTel = new TextField("");

	private Button btOk = new Button("확인");
	private Button btCancel1 = new Button("취소");

	Newone() {
		super("회원가입");
		this.init();
		this.start();
		this.setSize(300, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	void init() {
		GridLayout grid = new GridLayout(6, 2, 5, 5);
		this.setLayout(grid);
		this.add(lbId);
		this.add(tfId);
		this.add(lbPw);
		this.add(tfPw);
		this.add(lbName);
		this.add(tfName);
		this.add(lbAge);
		this.add(tfAge);
		this.add(lbTel);
		this.add(tfTel);
		this.add(btOk);
		this.add(btCancel1);

	}

	void start() {
		btOk.addActionListener(this);
		btCancel1.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btOk) {
			System.out.println("회원가입 확인 ");
			System.out.println("아이디: " + tfId.getText().trim().toString());
			System.out.println("암호: " + tfPw.getText().trim().toString());
			System.out.println("이름: " + tfName.getText().trim().toString());
			System.out.println("나이: " + tfAge.getText().trim().toString());
			System.out.println("전화번호: " + tfTel.getText().trim().toString());

		} else if (e.getSource() == btCancel1) {
			System.out.println("취소하셨습니다. ");
		}

	}
}
