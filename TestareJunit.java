package p1;

import static org.junit.Assert.*;
import org.junit.*;

public class TestareJunit {

	public static  Polinom pol1 = new Polinom();
	private static Polinom pol2 = new Polinom();
	
	public TestareJunit(){
		
	}
	
	
	@Test
	public void testAdun(){
		pol1.polAdd(new Monom(5,2));
		pol1.polAdd(new Monom(3,1));
		pol1.polAdd(new Monom(-4,0));
		pol2.polAdd(new Monom(7,4));
		pol2.polAdd(new Monom(-2,2));
		pol2.polAdd(new Monom(4,1));
		pol2.polAdd(new Monom(8,0));
		Polinom rez = pol1.adunarePol(pol2);
		assertNotNull(rez);
	}


	@Test
	public void testScad(){
		pol1.polAdd(new Monom(5,2));
		pol1.polAdd(new Monom(3,1));
		pol1.polAdd(new Monom(-4,0));
		pol2.polAdd(new Monom(7,4));
		pol2.polAdd(new Monom(-2,2));
		pol2.polAdd(new Monom(4,1));
		pol2.polAdd(new Monom(8,0));
		Polinom rez = pol1.scaderePol(pol2);
		assertNotNull(rez);
	}
	
	@Test
	public void testInmul(){
		pol1.polAdd(new Monom(5,2));
		pol1.polAdd(new Monom(3,1));
		pol1.polAdd(new Monom(-4,0));
		pol2.polAdd(new Monom(7,4));
		pol2.polAdd(new Monom(-2,2));
		pol2.polAdd(new Monom(4,1));
		pol2.polAdd(new Monom(8,0));
		Polinom rez = pol1.inmulPol(pol2);
		assertNotNull(rez);
	}

	@Test
	public void testDeriv(){
		pol1.polAdd(new Monom(5,2));
		pol1.polAdd(new Monom(3,1));
		pol1.polAdd(new Monom(-4,0));
		Polinom rez = pol1.derivarePol();
		assertNotNull(rez);
	}

	@Test
	public void testInteg(){
		pol1.polAdd(new Monom(5,2));
		pol1.polAdd(new Monom(3,1));
		pol1.polAdd(new Monom(-4,0));
		Polinom rez = pol1.integPol();
		assertNotNull(rez);
	}
	
	}