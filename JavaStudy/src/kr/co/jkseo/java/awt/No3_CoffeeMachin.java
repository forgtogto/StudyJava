package kr.co.jkseo.java.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class No3_CoffeeMachin {

	public static void main(String[] args) {
		japangi jp = new japangi();

	}

}

class japangi extends Frame implements ActionListener {
	// �߾ӹ�ġ���ú���
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	// ������ ��Ʈ�ѵ�..
	Button btSelectCoffee = new Button("����");
	Button btSelectTea = new Button("����");
	Button btSelectMilk = new Button("����");
	Button bt100 = new Button("100");
	Button bt500 = new Button("500");
	Button bt1000 = new Button("1000");
	Button bt10000 = new Button("10000");
	Button btInCoin = new Button("��������");
	Button btOutCoin = new Button("������");

	Label lbSpace1 = new Label("");
	Label lbSpace2 = new Label("");
	Label lbSpace3 = new Label("");
	Label lbSpace4 = new Label("");

	Label lbTitle1 = new Label("���Ǳ� ���α׷�", Label.CENTER);
	Label lbTitle2 = new Label("[ ���� �Ǹ� ���� ]");
	Label lbNameCoffee = new Label("Ŀ   �� (500��)  :");
	Label lbNameTea = new Label("�� �� ��(400��)  :");
	Label lbNameMilk = new Label("��   �� (300��)  :");

	Label lbCntCoffee = new Label("100 ��");
	Label lbCntTea = new Label("100 ��");
	Label lbCntMilk = new Label("100 ��");
	Label lbCoin = new Label("�����ܾ� : 0��");
	Label lbMent = new Label("�����..");
	Label lbInCoin = new Label("���Աݾ� :");
	Label lbOutCoin = new Label("������ܵ� :");
	Label lbOutCoin2 = new Label("0 ��");

	TextField tfCoin = new TextField();

	// �������� - ���� ��
	int coin = 0;// �����ܾ�
	int goods[] = new int[3]; // 0:Ŀ�� 1:���� 2:����

	japangi() {
		super("���Ǳ�");
		this.init();
		this.start();
		this.setSize(300, 400);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	void init() {
		// ��ǰ���� 100���� ����
		goods[0] = 100;
		goods[1] = 100;
		goods[2] = 100;

		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.add(lbTitle1, "North");

		GridLayout grid1 = new GridLayout(4, 3, 5, 5);
		GridLayout grid2 = new GridLayout(2, 1, 1, 1);
		GridLayout grid3 = new GridLayout(5, 2, 5, 5);

		GridLayout g = new GridLayout(3, 1, 5, 5);
		Panel outPanel = new Panel(g);

		Panel p1 = new Panel(grid1);
		p1.add(lbTitle2);
		p1.add(lbSpace1);
		p1.add(lbSpace2);
		p1.add(lbNameCoffee);
		p1.add(lbCntCoffee);
		p1.add(btSelectCoffee);
		p1.add(lbNameTea);
		p1.add(lbCntTea);
		p1.add(btSelectTea);
		p1.add(lbNameMilk);
		p1.add(lbCntMilk);
		p1.add(btSelectMilk);

		Panel p2 = new Panel(grid2);
		p2.add(lbCoin);
		p2.add(lbMent);
		Panel p3 = new Panel(grid3);
		p3.add(bt100);
		p3.add(bt500);
		p3.add(bt1000);
		p3.add(bt10000);
		p3.add(lbInCoin);
		p3.add(tfCoin);
		p3.add(btInCoin);
		p3.add(btOutCoin);
		p3.add(lbOutCoin);
		p3.add(lbOutCoin2);

		outPanel.add(p1);
		outPanel.add(p2);
		outPanel.add(p3);

		this.add(outPanel, "Center");

	}

	void start() {
		// �̺�Ʈ�����ʵ��
		btSelectCoffee.addActionListener(this);
		btSelectTea.addActionListener(this);
		btSelectMilk.addActionListener(this);
		bt100.addActionListener(this);
		bt500.addActionListener(this);
		bt1000.addActionListener(this);
		bt10000.addActionListener(this);
		btInCoin.addActionListener(this);
		btOutCoin.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btSelectCoffee) {
			message(1, 500);

		} else if (e.getSource() == btSelectTea) {
			message(2, 400);

		} else if (e.getSource() == btSelectMilk) {
			message(3, 300);

		} else if (e.getSource() == bt100) {
			coin += 100;
			lbCoin.setText("�����ܾ�:" + coin + " ��");
		} else if (e.getSource() == bt500) {
			coin += 500;
			lbCoin.setText("�����ܾ�:" + coin + " ��");
		} else if (e.getSource() == bt1000) {
			coin += 1000;
			lbCoin.setText("�����ܾ�:" + coin + " ��");
		} else if (e.getSource() == bt10000) {
			coin += 10000;
			lbCoin.setText("�����ܾ�:" + coin + " ��");
		} else if (e.getSource() == btInCoin) {
			if (tfCoin.getText().trim().equals("")) {
				lbMent.setText("�ݾ��� �Է����ּ���.");
				return;
			}
			coin += Integer.parseInt(tfCoin.getText().trim());
			lbCoin.setText("�����ܾ�:" + coin + " ��");
			tfCoin.setText("");
		} else if (e.getSource() == btOutCoin) {
			lbOutCoin2.setText(coin + " ��");
			coin = 0;
			lbCoin.setText("�����ܾ�:" + coin + " ��");
			lbMent.setText("�����..");
		}

	}

	void message(int gubun, int money) {
		if (gubun == 1 && (coin <= 0 || coin < money)) {
			lbMent.setText("Ŀ�� �̱⿡ ���� �����մϴ�.");
			return;
		} else if (gubun == 2 && (coin <= 0 || coin < money)) {
			lbMent.setText("���� �̱⿡ ���� �����մϴ�.");
			return;
		} else if (gubun == 3 && (coin <= 0 || coin < money)) {
			lbMent.setText("���� �̱⿡ ���� �����մϴ�.");
			return;
		}
		// �ش��ǰ ó�� ȣ��
		proc(gubun);

	}

	void proc(int gubun) {
		if (gubun == 1) {
			sleep("Ŀ��"); // ����ó��
			coin -= 500; // ��ǰ�� ����
			goods[0]--; // �����Ѱ� ����
			lbCoin.setText("�����ܾ�:" + coin + " ��");
			lbCntCoffee.setText(goods[0] + " ��");
		} else if (gubun == 2) {
			sleep("������"); // ����ó��
			coin -= 400; // ��ǰ�� ����
			goods[1]--; // �����Ѱ� ����
			lbCoin.setText("�����ܾ�:" + coin + " ��");
			lbCntTea.setText(goods[1] + " ��");
		} else if (gubun == 3) {
			sleep("����"); // ����ó��
			coin -= 300; // ��ǰ�� ����
			goods[2]--; // �����Ѱ� ����
			lbCoin.setText("�����ܾ�:" + coin + " ��");
			lbCntMilk.setText(goods[2] + " ��");
		}
	}

	void sleep(String goodsName) {
		for (int i = 3; i >= 0; i--) {
			try {
				Thread.sleep(1000);
				lbMent.setText(goodsName + "�� �̰��ֽ��ϴ�....." + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		lbMent.setText(goodsName + "�� ������ �����ϴ�.");
	}

}
