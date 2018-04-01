package p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Selector {
	
	private String pol1;
	private String pol2;
	private String[] monoame1;
	private String[] monoame2;
	private Panel p; 
	private Polinom polinomFinal1 ;
	private Polinom polinomFinal2 ;
	
	public Selector(Panel p){
		this.p = p;
	}
	
	public void interpretareOperatii(){
	
	p.plus.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			
			crearePol();
			Polinom rAdun = polinomFinal1.adunarePol(polinomFinal2);
			Collections.reverse(rAdun.getP());
			
			for (Monom f : rAdun.getP()){
				if (f.getCoef() > 0){
					p.textAfis.setText(p.textAfis.getText()+ "+" +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
					}
					else{
						p.textAfis.setText(p.textAfis.getText() +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
					}
			}
			
		}
	});
	p.minus.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			crearePol();
			
			Polinom rScad = polinomFinal1.scaderePol(polinomFinal2);
			Collections.reverse(rScad.getP());
			for (Monom f : rScad.getP()){
				if (f.getCoef() > 0){
				p.textAfis.setText(p.textAfis.getText()+ "+" +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
				else{
					p.textAfis.setText(p.textAfis.getText() +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
			}
		}
	});
	
	p.inmultire.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			
			crearePol();
			Polinom rInmul = polinomFinal1.inmulPol(polinomFinal2);
			Collections.reverse(rInmul.getP());
			
			if (rInmul.getP().get(rInmul.getP().size() -1).getCoef() == 0){
				rInmul.getP().remove(rInmul.getP().size() -1);
			}
			for (Monom f : rInmul.getP()){
				if (f.getCoef() > 0){
				p.textAfis.setText(p.textAfis.getText()+ "+" +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
				else{
					p.textAfis.setText(p.textAfis.getText() +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
			}
		}
	});
	
	p.impartire.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			crearePol();
			
		}
	});
	
	p.der.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			
			crearePol();
			Polinom rDeriv = polinomFinal1.derivarePol();
			Collections.reverse(rDeriv.getP());
			
			if (rDeriv.getP().get(rDeriv.getP().size() -1).getCoef() == 0){
				rDeriv.getP().remove(rDeriv.getP().size() -1);
			}
			for (Monom f : rDeriv.getP()){
				if (f.getCoef() > 0){
				p.textAfis.setText(p.textAfis.getText()+ "+" +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
				else{
					p.textAfis.setText(p.textAfis.getText() +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
			}
			
		}
	});
	
	p.integ.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p.textAfis.setText("");
			pol1 = p.po1.getText();
			pol2 = p.po2.getText();
			
			crearePol();
			Polinom rDeriv = polinomFinal1.integPol();
			Collections.reverse(rDeriv.getP());
			
			if (rDeriv.getP().get(rDeriv.getP().size() -1).getCoef() == 0){
				rDeriv.getP().remove(rDeriv.getP().size() -1);
			}
			for (Monom f : rDeriv.getP()){
				if (f.getCoef() > 0){
				p.textAfis.setText(p.textAfis.getText()+ "+" +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
				else{
					p.textAfis.setText(p.textAfis.getText() +String.valueOf(f.getCoef())+ "x^" + String.valueOf(f.getPutere()) + " ");
				}
			}
			
		}
	});
	
	}
	
	public void crearePol(){
		
		polinomFinal1 = new Polinom();
		polinomFinal2 = new Polinom();
		pol1 = pol1.replace("-", "+-");
		pol2 = pol2.replace("-", "+-");
		
		pol1 = pol1.replaceAll("\\s" ,"");
		pol2 = pol2.replaceAll("\\s" ,"");
		
		int i ;
		String[] buff = null;
		String[] buff1 = null;
		
		monoame1 = pol1.split("[+]");
		monoame2 = pol2.split("[+]");
		
		int f = monoame1.length;
		int f1 = monoame2.length;
		
		for(i = 0;i < f;i++){
		monoame1[i] = monoame1[i].replaceAll("\\^", "");
			
		buff = monoame1[i].split("x");
		buff[1] = buff[1].replaceAll("\\^", "");
		
		polinomFinal1.polAdd(new Monom((Double.parseDouble(buff[0])),Integer.parseInt(buff[1])));
	
		}
		
		for(i = 0;i < f1;i++){
			monoame2[i] = monoame2[i].replaceAll("\\^", "");
				
			buff1 = monoame2[i].split("x");
			
			
			buff1[1] = buff1[1].replaceAll("\\^", "");
			
			polinomFinal2.polAdd(new Monom((Double.parseDouble(buff1[0])),Integer.parseInt(buff1[1])));
			}
		
		
	}
}
