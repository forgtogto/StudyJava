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
	// 중앙배치관련변수
	private Dimension dimen, dimen1;
	private int xpos, ypos;

	// 윈도우 컨트롤들..
	Button btSelectCoffee = new Button("선택");
	Button btSelectTea = new Button("선택");
	Button btSelectMilk = new Button("선택");
	Button bt100 = new Button("100");
	Button bt500 = new Button("500");
	Button bt1000 = new Button("1000");
	Button bt10000 = new Button("10000");
	Button btInCoin = new Button("동전투입");
	Button btOutCoin = new Button("꺼내기");

	Label lbSpace1 = new Label("");
	Label lbSpace2 = new Label("");
	Label lbSpace3 = new Label("");
	Label lbSpace4 = new Label("");

	Label lbTitle1 = new Label("자판기 프로그램", Label.CENTER);
	Label lbTitle2 = new Label("[ 현재 판매 수량 ]");
	Label lbNameCoffee = new Label("커   피 (500원)  :");
	Label lbNameTea = new Label("율 무 차(400원)  :");
	Label lbNameMilk = new Label("우   유 (300원)  :");

	Label lbCntCoffee = new Label("100 잔");
	Label lbCntTea = new Label("100 잔");
	Label lbCntMilk = new Label("100 잔");
	Label lbCoin = new Label("현재잔액 : 0원");
	Label lbMent = new Label("대기중..");
	Label lbInCoin = new Label("투입금액 :");
	Label lbOutCoin = new Label("배출된잔돈 :");
	Label lbOutCoin2 = new Label("0 원");

	TextField tfCoin = new TextField();

	// 변수설계 - 실제 값
	int coin = 0;// 현재잔액
	int goods[] = new int[3]; // 0:커피 1:율무 2:우유

	japangi() {
		super("자판기");
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
		// 상품수량 100개로 셋팅
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
		// 이벤트리스너등록
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
			lbCoin.setText("현재잔액:" + coin + " 원");
		} else if (e.getSource() == bt500) {
			coin += 500;
			lbCoin.setText("현재잔액:" + coin + " 원");
		} else if (e.getSource() == bt1000) {
			coin += 1000;
			lbCoin.setText("현재잔액:" + coin + " 원");
		} else if (e.getSource() == bt10000) {
			coin += 10000;
			lbCoin.setText("현재잔액:" + coin + " 원");
		} else if (e.getSource() == btInCoin) {
			if (tfCoin.getText().trim().equals("")) {
				lbMent.setText("금액을 입력해주세요.");
				return;
			}
			coin += Integer.parseInt(tfCoin.getText().trim());
			lbCoin.setText("현재잔액:" + coin + " 원");
			tfCoin.setText("");
		} else if (e.getSource() == btOutCoin) {
			lbOutCoin2.setText(coin + " 원");
			coin = 0;
			lbCoin.setText("현재잔액:" + coin + " 원");
			lbMent.setText("대기중..");
		}

	}

	void message(int gubun, int money) {
		if (gubun == 1 && (coin <= 0 || coin < money)) {
			lbMent.setText("커피 뽑기에 돈이 부족합니다.");
			return;
		} else if (gubun == 2 && (coin <= 0 || coin < money)) {
			lbMent.setText("율무 뽑기에 돈이 부족합니다.");
			return;
		} else if (gubun == 3 && (coin <= 0 || coin < money)) {
			lbMent.setText("우유 뽑기에 돈이 부족합니다.");
			return;
		}
		// 해당상품 처리 호출
		proc(gubun);

	}

	void proc(int gubun) {
		if (gubun == 1) {
			sleep("커피"); // 동작처리
			coin -= 500; // 상품값 차감
			goods[0]--; // 수량한개 차감
			lbCoin.setText("현재잔액:" + coin + " 원");
			lbCntCoffee.setText(goods[0] + " 잔");
		} else if (gubun == 2) {
			sleep("율무차"); // 동작처리
			coin -= 400; // 상품값 차감
			goods[1]--; // 수량한개 차감
			lbCoin.setText("현재잔액:" + coin + " 원");
			lbCntTea.setText(goods[1] + " 잔");
		} else if (gubun == 3) {
			sleep("우유"); // 동작처리
			coin -= 300; // 상품값 차감
			goods[2]--; // 수량한개 차감
			lbCoin.setText("현재잔액:" + coin + " 원");
			lbCntMilk.setText(goods[2] + " 잔");
		}
	}

	void sleep(String goodsName) {
		for (int i = 3; i >= 0; i--) {
			try {
				Thread.sleep(1000);
				lbMent.setText(goodsName + "를 뽑고있습니다....." + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		lbMent.setText(goodsName + "를 꺼내도 좋습니다.");
	}

}
