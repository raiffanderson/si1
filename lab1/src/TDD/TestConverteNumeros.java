package TDD;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestConverteNumeros {
	
	
	String[]listaUmADez= {"space","um", "dois", "tres","quatro","cinco","seis","sete","oito","nove","dez","onze","doze","treze","quatorze","quinze","dezesseis","dezessete","dezoito","dezenove"};
	String[]lista21A99Pulando9PorExtenso= {"vinte e um","trinta", "trinta e nove", "quarenta e oito","cinquenta e sete","sessenta e seis","setenta e cinco","oitenta e quatro","noventa e tres"};
	String[]lista21A99Pulando9 = {"21" , "30", "39", "48", "57", "66","75","84","93"};
	
	@Before
	public void setUp() {}
		String testeDeEntrada;
		
		
	@Test
	public void TestaDevolveNumeroPorExtenso(){
		/* 1� caso */
		for (int num = 1; num < 20; num++){
			 Assert.assertEquals(ConverteNumeros.devolveNumeroPorExtenso(Integer.toString(num)), listaUmADez[num]);
			 /* varre os n�meros de 0 a 10 para conferir se todos est�o cobertos*/
		} 
		
		for (int num = 0; num < lista21A99Pulando9.length; num++  ){
			 Assert.assertEquals( lista21A99Pulando9PorExtenso[num],ConverteNumeros.devolveNumeroPorExtenso(lista21A99Pulando9[num]));
			 /* varre os n�meros de 0 a 10 para conferir se todos est�o cobertos*/
		} 
		
	
		
	}
	
	public void  TestEntradaValida(){
		
		/* garante que n�o aceita string vazia na entrada */
		testeDeEntrada = "";
		Assert.assertFalse(ConverteNumeros.EntradaEhValida(testeDeEntrada));
		
		/*garante que n�o aceita palavras*/
		testeDeEntrada = "casa";
		Assert.assertFalse(ConverteNumeros.EntradaEhValida(testeDeEntrada));
	}
}
