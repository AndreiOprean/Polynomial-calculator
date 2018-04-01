package p1;

import java.util.ArrayList;
import java.util.Collections;

public class Polinom {

	private ArrayList<Monom> p = new ArrayList<Monom>();
	
	
	public Polinom() {
		
	}
	
	public ArrayList<Monom> getP(){
		return this.p;
	}
	
	public void polAdd(Monom m){
		p.add(m);
		Collections.sort(p);
	}
	
	
	
	private int getIndexPutere(int putere) {
		for(int i=0;i<p.size();i++) {
			Monom mon = p.get(i);
			if(putere == mon.getPutere()) 
				return i;
		}
		return -1;
	}
	
	private void clean() {
		for(int i=0;i<p.size();i++) {
			if(p.get(i).getCoef() == 0) p.remove(i);
		}
	}
	
	public Polinom adunarePol(Polinom pol){
		Polinom aux = new Polinom();
		for(int i=0;i<this.p.size();i++) {
			int p1 = this.p.get(i).getPutere();
			double c1 = this.p.get(i).getCoef();
			
			int ipow = pol.getIndexPutere(p1);
			if(ipow == -1) {
				
				aux.p.add(new Monom(c1, p1));
			} else {
				
				int p3 = pol.p.get(ipow).getPutere();
				double c3 = pol.p.get(ipow).getCoef();
				aux.p.add(new Monom(c1+c3, p3));
				
				pol.p.remove(ipow);
			}
		}
		
		for(int j=0;j<pol.p.size();j++) {
			int p2 = pol.p.get(j).getPutere();
			double c2 = pol.p.get(j).getCoef();
			aux.p.add(new Monom(c2, p2));
		}
		aux.clean();
	return aux;
	}
	
	public Polinom scaderePol(Polinom pol) {
		Polinom aux;
		
		for(int i=0;i<pol.p.size();i++) {
			pol.p.get(i).setCoef(pol.p.get(i).getCoef()*(-1)) ;
		}
		
		aux = this.adunarePol(pol);
		aux.clean();
		return aux;
	}
	
	public Polinom derivarePol() {
		for(int i=0;i<this.p.size();i++) {
			this.p.get(i).deriv();
		}
		
		return this;
	}
	
	public Polinom integPol() {
		for(int i=0;i<this.p.size();i++) {
			this.p.get(i).integ();
		}
		this.clean();
		return this;
	}
	
	public Polinom inmulPol(Polinom poli) {
		Polinom aux = new Polinom();
		
		for(int i=0;i<this.p.size();i++) {
			Monom m1 = this.p.get(i);
			for(int j=0;j<poli.p.size();j++) {
				Monom m2 = poli.p.get(j);
				Monom m3 = m1.times(m2);
				aux.p.add(m3);
			}
		}
		
		return aux;
	}
	
}
