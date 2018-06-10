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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class No4_StudentScoreSaveFile {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Scoredd score = new Scoredd();
	  
	}
}

class Scoredd extends Frame implements ActionListener, FocusListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	/////////////////////////
	String score[][] = new String[100][6];// 0:����/1:����/2:����/3:����/4:���/5:�̸�
	static int count = 0;
	String strName = "";
	String strKor = "0";
	String strEng = "0";
	String strMat = "0";

	int tot = 0;
	double avg = 0.0;
	/////////////////////////
	
	File dir = new File("c:\\java");
	File file = new File(dir, "datafile.dat"); //������ ���� 
	Vector vc = new Vector();
	//////////////////////////
	Button btProc = new Button("����ϱ�");
	Button btAdd = new Button("�߰��ϱ�");
	Button btSearch = new Button("�˻��ϱ�");

	Label lbNo = new Label("1��:", Label.CENTER);
	Label lbTitle = new Label(" �л� ����", Label.CENTER);
	Label lbName = new Label("�̸�  :  ", Label.CENTER);
	Label lbKor = new Label("����  :  ", Label.CENTER);
	Label lbEng = new Label("����  :  ", Label.CENTER);
	Label lbMat = new Label("����  :  ", Label.CENTER);
	Label lbTot = new Label("����  :  ", Label.CENTER);
	Label lbAvg = new Label("���  :  ", Label.CENTER);
	Label lbSpace = new Label("");
	Label lbResultTot = new Label("");
	Label lbResultAvg = new Label("");

	TextField tfKor = new TextField();
	TextField tfEng = new TextField();
	TextField tfMat = new TextField();
	TextField tfName = new TextField();
	TextField tfSearch = new TextField();

	Scoredd() throws FileNotFoundException, ClassNotFoundException, IOException {
		super("����ó����");
		this.initFile();
		this.init();
		this.start();
		this.setSize(200, 300);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);

	}

	void initFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		// �����дºκ�...
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			vc = (Vector) ois.readObject();

			count = vc.size();
			lbNo.setText(count + 1 + "��:");
			ois.close();
		}
	}

	void init() {
		GridLayout grid = new GridLayout(9, 2, 10, 10);
		this.setLayout(grid);
		this.add(lbNo);
		this.add(lbTitle);
		this.add(lbName);
		this.add(tfName);
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
		this.add(btAdd);
		this.add(tfSearch);
		this.add(btSearch);

	}

	void start() {
		btProc.addActionListener(this);
		btAdd.addActionListener(this);
		btSearch.addActionListener(this);
		tfKor.addFocusListener(this);
		tfEng.addFocusListener(this);
		tfMat.addFocusListener(this);
		tfName.addFocusListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); //�����ư 
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ment = "������ �Է��Ͻÿ�!";

		if (e.getSource() == btProc) {
			strKor = tfKor.getText().trim();
			strEng = tfEng.getText().trim();
			strMat = tfMat.getText().trim();
			strName = tfName.getText().trim();
			///////////////////////////////////////
			if (strKor.equals("")) {
				tfKor.setText(""+ment);
				return;
			} else if (strEng.equals("")) {
				tfEng.setText(""+ment);
				return;
			} else if (strMat.equals("")) {
				tfMat.setText(""+ment);
				return;
			}
			// ��ȯ�۾�
			int kor = Integer.parseInt(strKor);
			int eng = Integer.parseInt(strEng);
			int mat = Integer.parseInt(strMat);

			tot = kor + eng + mat;
			avg = tot / 3.0;

			lbResultTot.setText(tot + "");
			lbResultAvg.setText(avg + "");
		} else if (e.getSource() == btAdd) {
			ObjectOutputStream oos;
			try {
				// ����Ÿ������ ���� Ŭ���� ���� ����
				DataFile df = new DataFile();
				df.kor = strKor;
				df.eng = strEng;
				df.mat = strMat;
				df.tot = tot + "";
				df.avg = avg + "";
				df.name = strName;
				vc.add(df);
				// �ε���....üũ
				count++;
				lbNo.setText(count + 1 + "��:");

				tfKor.setText("");
				tfEng.setText("");
				tfMat.setText("");
				lbResultTot.setText("");
				lbResultAvg.setText("");
				tfName.setText("");

				oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				oos.writeObject(vc);
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource() == btSearch) {
			String name = tfSearch.getText();

			for (int i = 0; i < vc.size(); i++) {
				DataFile dfTemp = (DataFile) vc.elementAt(i);
				if (name.equals(dfTemp.name)) {
					tfKor.setText(dfTemp.kor);
					tfEng.setText(dfTemp.eng);
					tfMat.setText(dfTemp.mat);
					lbResultTot.setText(dfTemp.tot);
					lbResultAvg.setText(dfTemp.avg);
					tfName.setText(dfTemp.name);
					lbNo.setText(i + 1 + "��:");
				}
			}
		}
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

class DataFile implements Serializable {
	String name;
	String kor;
	String eng;
	String mat;
	String tot;
	String avg;
}
