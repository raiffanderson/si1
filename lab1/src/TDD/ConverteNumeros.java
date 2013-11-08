package TDD;
import java.util.Scanner;

import junit.framework.Assert;


public class ConverteNumeros {

	static String[][] numeros = {{"space","um", "dois", "tres","quatro","cinco","seis","sete","oito","nove"},
							{"dez","onze","doze","treze","quatorze","quinze","dezesseis","dezessete","dezoito","dezenove"},
							{"space","space","vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"},
							{"space","cento","duzentos","trezentos","quatrocentos","quinhentos","seiscentos","setecentos","oitocentos","novecentos"}};
	
	//static String[][] 

	public static void main(String[] args) throws Exception {
		String input = "", desejaReiniciar = "y";
		int inputNumber;
		while(desejaReiniciar.equals("y") || desejaReiniciar.equals("Y")){
			System.out.print("Qual o numero que voc� deseja converter ? ");
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			try {
				EntradaEhValida(input);
				System.out.println("O numero escolhido foi: " + devolveNumeroPorExtenso(input));
			}catch (Exception e){
				System.out.println("Entrada Invalida.");
				e.getMessage();
			}finally{
				
				System.out.println("Deseja converter novamente ? (y/n) ");
				desejaReiniciar = scanner.nextLine();
				if (desejaReiniciar == "n" || desejaReiniciar == "N"){
					break;
				}
			}
			
		}
		System.out.println("Programa Finalizado.");
	}
	
public static String devolveNumeroPorExtenso(String num) {
	String resposta = "";
	int seletor = Integer.parseInt(num);
	String[] numeroDividido = num.split("");
	int linha = 0;
	int coluna = 0;
	if (seletor < 10){
		coluna = Integer.parseInt(numeroDividido[1]);
		resposta = numeros[linha][coluna];
	}else if(9 < seletor && seletor <= 19){
		linha = numeroDividido.length - 2;
		coluna = Integer.parseInt(numeroDividido[2]);
		resposta = numeros[linha][coluna];
	}else if (seletor > 19 && seletor < 100){
		linha = numeroDividido.length - 1;
		coluna = Integer.parseInt(numeroDividido[1]);
		resposta = numeros[linha][coluna];
		if (!numeroDividido[2].equals("0")){
			resposta = resposta +" e "+ devolveNumeroPorExtenso(numeroDividido[2]);
		}
	}
	//System.out.println("seletor " + seletor + " linha:" +linha+ " coluna:" + coluna);
//	for (int i = 0; i < numeroDividido.length; i++ ){
//		 System.out.println("elemento: "+ numeroDividido[i]);
//		 /* varre os n�meros de 0 a 10 para conferir se todos est�o cobertos*/
//	} 
//	System.out.println("tamanho: " + numeroDividido.length);
	return resposta;
}


	public static boolean EntradaEhValida(String testeDeEntrada){
		if ( testeDeEntrada == ""){
			return false;
		}
		String[] entradaDividida = testeDeEntrada.split("");
		int controle = 0;
		String zeroANove = "0123456789";//{"1","2","3","4","5","6","7","8","9","0"};
		for (int elemento = 0; elemento < testeDeEntrada.length(); elemento++){
				if (zeroANove.contains(entradaDividida[elemento])){
					controle++;
			}
		}
		if (controle == testeDeEntrada.length()){
			return true;
		}else{
			return false;
		}
	}	
}