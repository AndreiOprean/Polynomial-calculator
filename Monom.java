package p1;



public class Monom implements Comparable<Monom>{

	private double coef;
	private int putere;
	
	public Monom(double coef,int putere){
		this.coef = coef;
		this.putere = putere;
	}
	
	public double getCoef(){
		return this.coef;
	}
	
	public int getPutere(){
		return this.putere;
	}
	
	public void setCoef(double coef){
		this.coef = coef;
	}
	
	public void setPutere(int putere){
		this.putere = putere;
	}
	
	public void deriv() {
		if (putere != 0) {
			coef = coef * putere;
			putere-=1;
		}
		else if (putere == 0){
		coef = 0;
		}
	}
	
	public void integ() {
		putere++;
		coef = coef / putere;
	}
	
	public Monom times(Monom mon1) {
		Monom ret;
		
		double c = this.getCoef() * mon1.getCoef();
		int p = this.getPutere() + mon1.getPutere();
		ret = new Monom(c,p);
		
		return ret;
	}
	
	public Monom adunareMonom(Monom m){
		double temp;
		
		temp = this.getCoef() + m.getCoef();
		
		return (new Monom(temp,this.getPutere()));
	}
	
	public Monom scadereMonom(Monom m){
		double temp;
		
		temp = this.getCoef() - m.getCoef();
		
		return (new Monom(temp,this.getPutere()));
	}
	
	
	
	public int compareTo(Monom m){
		if (this.getPutere() == m.getPutere()){
			return 0;
		}
		else if (this.getPutere() < m.getPutere()){
			return -1;
		}
			else {
			return 1;
			}
	}
	
}
