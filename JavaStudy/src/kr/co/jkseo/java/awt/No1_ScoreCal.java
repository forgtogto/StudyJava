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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class No1_ScoreCal {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Score2 score = new Score2();
	}
}

@SuppressWarnings("serial")
class Score2 extends Frame implements ActionListener, FocusListener {
 
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	Button btProc = new Button("계산하기");

	Label lbKor = new Label("국어  :  ", Label.CENTER);
	Label lbEng = new Label("영어  :  ", Label.CENTER);
	Label lbMat = new Label("수학  :  ", Label.CENTER);
	Label lbTot = new Label("총점  :  ", Label.CENTER);
	Label lbAvg = new Label("평균  :  ", Label.CENTER);
	Label lbSpace = new Label("");
	Label lbResultTot = new Label("");
	Label lbResultAvg = new Label("");

	TextField tfKor = new TextField();
	TextField tfEng = new TextField();
	TextField tfMat = new TextField();

	Score2() {
		super("점수처리기");
		this.init();
		this.start();
		this.setSize(200, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);

	}

	void init() {
		GridLayout grid = new GridLayout(6, 2, 10, 10);
		this.setLayout(grid);
		this.add(lbKor);
		this.add(tfKor);
		this.add(lbEng);
		this.add(tfEng);
		this.add(lbMat);
		this.add(tfMat);
		this.add(lbTot);
		this.add(lbResultTot);
		this.add(lbAvg);
		this.add(lbResultAvg);
		this.add(btProc);
		this.add(lbSpace);

	}

	void start() {
		btProc.addActionListener(this);
		tfKor.addFocusListener(this);
		tfEng.addFocusListener(this);
		tfMat.addFocusListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strKor = tfKor.getText().trim();
		String strEng = tfEng.getText().trim();
		String strMat = tfMat.getText().trim();
		///////////////////////////////////////
		if (strKor.equals("")) {
			tfKor.setText("점수를입력하시오!");
			return;
		} else if (strEng.equals("")) {
			tfEng.setText("점수를입력하시오!");
			return;
		} else if (strMat.equals("")) {
			tfMat.setText("점수를입력하시오!");
			return;
		}

		// 변환작업
		int kor = Integer.parseInt(strKor);
		int eng = Integer.parseInt(strEng);
		int mat = Integer.parseInt(strMat);

		int tot = kor + eng + mat;
		double avg = tot / 3.0;

		lbResultTot.setText(tot + "");
		lbResultAvg.setText(avg + "");

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfKor) {
			tfKor.setText("");
		} else if (e.getSource() == tfEng) {
			tfEng.setText("");
		} else if (e.getSource() == tfMat) {
			tfMat.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
