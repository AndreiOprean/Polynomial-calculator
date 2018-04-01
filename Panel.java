package p1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {

	public JFrame frame;
	public JPanel polinom1,polinom2,operatii,afis;
	public JButton plus,minus,impartire,inmultire,der,integ;
	public JTextField po1 = new JTextField(40);
	public JTextField po2 = new JTextField(40);
	public JTextField textAfis = new JTextField(40);
	public JLabel p1 = new JLabel("Polinomul 1");
	public JLabel p2 = new JLabel("Polinomul 2");
	public JLabel textAfis1 = new JLabel("Rezultatul operatiei");
	
	public Panel(){
		inceput();
	}
	public void inceput(){
	 
	frame = new JFrame("Calculator de polinoame");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600,400);
	frame.setLayout(new GridLayout(4,1));
	
	polinom1 = new JPanel();
	polinom2 = new JPanel();
	operatii = new JPanel();
	afis = new JPanel();
	
	polinom1.add(p1);
	polinom2.add(p2);
	
	polinom1.add(po1);
	polinom2.add(po2);
	
	plus = new JButton("+");
	minus = new JButton("-");
	impartire = new JButton("/");
	inmultire = new JButton("*");
	der = new JButton("Derivare");
	integ = new JButton("Integrare");
	
	operatii.add(plus);
	operatii.add(minus);
	operatii.add(impartire);
	operatii.add(inmultire);
	operatii.add(der);
	operatii.add(integ);
	
	afis.add(textAfis1);
	afis.add(textAfis);
	
	JPanel p = new JPanel();
	
	p.add(polinom1);
	p.add(polinom2);
	p.add(operatii);
	p.add(afis);
	
	p.setLayout(new GridLayout(4,1));
	
	frame.setContentPane(p);
	frame.setVisible(true);
	
	}
}
