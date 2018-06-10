package kr.co.jkseo.java.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class No2_FriendRegist {

	public static void main(String[] args) {
		ListDialog ld = new ListDialog();

	}

}

class ListDialog extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	///////////////////////////////
	String info[][] = new String[100][3];
	int count = 0;// 사람수체크변수
	String taValue = "";
	///////////////////////////////
	Button btAdd = new Button("추가하기");
	Button btSearch = new Button("검색하기");
	Label lbName = new Label("이름:", Label.CENTER);
	Label lbAddr = new Label("이메일:", Label.CENTER);
	Label lbTel = new Label("전화번호:", Label.CENTER);
	TextField tfName = new TextField();
	TextField tfAddr = new TextField();
	TextField tfTel = new TextField();
	TextField tfSearch = new TextField();
	TextArea taList = new TextArea(50, 100);

	ListDialog() {

		super("친구추가관리");
		this.init();
		this.start();
		this.setSize(400, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	void init() {
		GridLayout grid = new GridLayout(2, 1, 5, 5);
		this.setLayout(grid);

		GridLayout gridPanel1 = new GridLayout(3, 3, 5, 5);
		Panel p1 = new Panel(gridPanel1);

		p1.add(lbName);
		p1.add(tfName);
		p1.add(btAdd);
		p1.add(lbAddr);
		p1.add(tfAddr);
		p1.add(tfSearch);
		p1.add(lbTel);
		p1.add(tfTel);
		p1.add(btSearch);

		BorderLayout bl = new BorderLayout();
		Panel p2 = new Panel(bl);

		p2.add(taList);

		this.add(p1);
		this.add(p2, "Center");
	}

	void start() {
		// 이벤트리스너등록
		btAdd.addActionListener(this);
		btSearch.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			// 저장
			info[count][0] = tfName.getText().trim();
			info[count][1] = tfAddr.getText().trim();
			info[count][2] = tfTel.getText().trim();

			taValue += count + 1 + " 번 : " + info[count][0] + " / " + info[count][1] + " / " + info[count][2] + "\n";
			count++;

			// 초기화
			tfName.setText("");
			tfAddr.setText("");
			tfTel.setText("");

			taList.setText(taValue);

		} else if (e.getSource() == btSearch) {
			taValue = "";
			for (int i = 0; i < count; i++) {
				taValue += i + 1 + " 번 : " + info[i][0] + " / " + info[i][1] + " / " + info[i][2] + "\n";
				if (tfSearch.getText().trim().equals(info[i][0])) {
					taList.setText("");
					tfName.setText("");
					tfAddr.setText("");
					tfTel.setText("");
					String taSearch = i + 1 + " 번 : " + info[i][0] + " / " + info[i][1] + " / " + info[i][2] + "\n";
					taList.setText(taSearch);
				}
			}
			if (tfSearch.getText().trim().equals("")) {
				tfName.setText("");
				tfAddr.setText("");
				tfTel.setText("");
				taList.setText(taValue);
			}
		}

	}

}
