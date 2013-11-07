import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestConverteNumeros {
	
	int num;
	String[]listaUmADez= {"zero","um", "dois", "tres","quatro","cinco","seis","sete","oito","nove","dez"};
	
	@Before
	public void setUp() {}

	@Test
	public void TestaDevolveNumeroPorExtenso(){
		/* 1� caso */
		 for (int num = 0; num < 11; num++){
			 
		 assertEquals(ConverteNumeros.devolveNumeroPorExtenso(num), listaUmADez[num]);
		 /* varre os n�meros de 0 a 10 para conferir se todos est�o cobertos*/} 
	}

}
