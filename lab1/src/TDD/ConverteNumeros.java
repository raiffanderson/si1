package TDD;
import java.util.Scanner;

import junit.framework.Assert;


public class ConverteNumeros {

	static String[][] numeros = {{"space","um", "dois", "tres","quatro","cinco","seis","sete","oito","nove"},
							{"dez","onze","doze","treze","quatorze","quinze","dezesseis","dezessete","dezoito","dezenove"},
							{"space","space","vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"},
							{"space","cento","duzentos","trezentos","quatrocentos","quinhentos","seiscentos","setecentos","oitocentos","novecentos"}};
	

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
	/* caso do zero*/
	if( seletor == 0){
		resposta = "zero";
	}
	/*caso do mil*/
	else if (seletor == 1000){
		resposta = "mil";
	}
	/*caso do mil e cem*/
	else if (seletor == 1100){
		resposta = "mil e cem";
	}
	/*caso do cem*/
	else if (seletor == 100){
		resposta = "cem";
	}
	else if (seletor < 10){
		if (num.length() > 1){
			coluna = Integer.parseInt(numeroDividido[2]);
		}
		else{coluna = Integer.parseInt(numeroDividido[1]);}
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
	}else if (seletor > 100 && seletor < 1000){
		linha = numeroDividido.length-1;
		coluna = Integer.parseInt(numeroDividido[1]);	
		resposta = numeros[linha][coluna] + " e " + devolveNumeroPorExtenso(num.substring(1, 3));
		
	}
	else if  ( seletor > 1000 && seletor < 1100){
		linha = numeroDividido.length-1;
		coluna = Integer.parseInt(numeroDividido[1]);
		resposta = "mil e " + devolveNumeroPorExtenso(num.substring(2, 4));
	}else if (seletor >= 1100 && seletor < 1000000){
		linha = numeroDividido.length-1;
		coluna = Integer.parseInt(numeroDividido[1]);
		if ( seletor > 99999 ){
			resposta = devolveNumeroPorExtenso(num.substring(0,3))+" ";
		}else if (seletor < 100000){
			if ( num.length() > 4){
				resposta = devolveNumeroPorExtenso(num.substring(0,2))+" ";
			}else if (num.length() < 5){
				resposta = devolveNumeroPorExtenso(num.substring(0,1))+" ";}
		}
		if ("000000000".contains(num.substring(2,4))){
			resposta = resposta +"mil e " + devolveNumeroPorExtenso(num.substring(1, 4));
		}else{
		resposta = resposta + "mil " + devolveNumeroPorExtenso(num.substring(1, 4));
		}
		
	}else if(seletor > 9999){
		
	}
		
	if (resposta.contains("um mil")){
		resposta = resposta.substring(3);
	}
	if (resposta.endsWith("e zero")){
		resposta = resposta.substring(0, resposta.length() - 7);
	}
	return resposta;
}


	public static boolean EntradaEhValida(String testeDeEntrada){
		if ( testeDeEntrada == ""){
			return false;
		}
		String[] entradaDividida = testeDeEntrada.split("");
		int controle = 0;
		String zeroANove = "0123456789";
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