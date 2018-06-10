package kr.co.jkseo.java.swing;
import java.awt.*;
import java.io.*;
import java.util.Vector;
import javax.swing.*;


public class Ex1_SwingSamples extends JFrame	{
	public Ex1_SwingSamples() {
		//image icon //
		JLabel jl1 = new JLabel("ImageIcon");
		ImageIcon ic = new ImageIcon("pho\\aaa.gif");
		JButton jb = new JButton("JButton", ic);
		// label //
		JLabel jl2 = new JLabel("JLabel");
		JLabel jlabel = new JLabel("This is JLabel");
		JLabel jl3 = new JLabel("JTextField");
		JTextField jtf = new JTextField("JTextField");
		JLabel jl4 = new JLabel("JTextArea");
		JTextArea jta = new JTextArea();
		JLabel jl5 = new JLabel("JButton");
		JButton jb1 = new JButton("JButton");
		JLabel jl6 = new JLabel("JCheckBox");
		JCheckBox jcb1 = new JCheckBox("CheckBox1");
		JCheckBox jcb2 = new JCheckBox("CheckBox2");
		JCheckBox jcb3 = new JCheckBox("CheckBox3");
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(jcb1);
		jp.add(jcb2);
		jp.add(jcb3);
		JLabel jl7 = new JLabel("JRadioButton");
		JRadioButton jrb1 = new JRadioButton("Radio1");
		JRadioButton jrb2 = new JRadioButton("Radio2");
		JRadioButton jrb3 = new JRadioButton("Radio3");
		ButtonGroup gb = new ButtonGroup();
		gb.add(jrb1);
		gb.add(jrb2);
		gb.add(jrb3);
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		JLabel jl8 = new JLabel("JComboBox");
		JComboBox jcb = new JComboBox();
		jcb.addItem("item1");
		jcb.addItem("item2");
		jcb.addItem("item3");
		JLabel jl9 = new JLabel("JList");
		String[] fruitlist = {"fruit1","fruit2","fruit3"};
		JList jlist = new JList(fruitlist);
		JLabel jl10 = new JLabel("JScrollPane");
		JPanel jp3 = new JPanel();
		for(int i=0; i<10; i++)
			jp3.add(new JButton("button"+i));
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane jsp = new JScrollPane(jp3, v, h);
		JLabel jl11 = new JLabel("JTabbedPane");
		/* 
		jl11.setBackground(Color.gray);
		jl11.setOpaque(true);
		jl9.setBackground(Color.gray);
		jl9.setOpaque(true);
		jl7.setBackground(Color.gray);
		jl7.setOpaque(true);
		jl5.setBackground(Color.gray);
		jl5.setOpaque(true);
		jl3.setBackground(Color.gray);
		jl3.setOpaque(true);
		jl1.setBackground(Color.gray);
		jl1.setOpaque(true);
		 */
		
	 
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("tap1", new JButton("tap1"));
		jtp.addTab("tap2", new JButton("tap2"));
		/*
		for(int i=0; i<12; i++) {JLabel a = new JLabel("jl"+i);
		a.setBackground(Color.cyan); a.setOpaque(true); }
		*/
		JLabel[] labelArray = {jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11};
		for(JLabel label : labelArray) {
			label.setText(" " + label.getText());
			label.setFont(new Font("³ª´®°íµñ",1,15));
			label.setOpaque(true);	}
		/*
		JLabel[] labelArr = new JLabel[11];
		for(int i=0; i<11; i++) {
			labelArr[i] = new JLabel("Test");
			labelArr[i].setBackground(Color.white);
			labelArr[i].setOpaque(true);	}
		*/
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(11,2));
		ct.add(jl1);	ct.add(jb);	
		ct.add(jl2);	ct.add(jlabel);	
		ct.add(jl3);	ct.add(jtf);	
		ct.add(jl4);	ct.add(jta);	
		ct.add(jl5);	ct.add(jb1);	
		ct.add(jl6);	ct.add(jp);	
		ct.add(jl7);	ct.add(jp2);	
		ct.add(jl8);	ct.add(jcb);	
		ct.add(jl9);	ct.add(jlist);	
		ct.add(jl10);	ct.add(jsp);	
		ct.add(jl11);	ct.add(jtp);		
	}
	
	public static void main(String[] args) {
		Ex1_SwingSamples hel = new Ex1_SwingSamples();
		hel.setTitle("Swing Test");
		hel.setSize(400, 700);
		hel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hel.setVisible(true);
	}
}
