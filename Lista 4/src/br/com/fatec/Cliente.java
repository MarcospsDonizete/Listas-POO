package br.com.fatec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Cliente {
	private String ip;
	private int porta;
	private Socket encaixeCliente;
	private Socket testePorta;
	 

	public Cliente(String ip) throws Exception {
		System.out.println("Iniciando a conex�o com o servidor...");
		this.ip=ip;
	}
	
	public void enviar() throws Exception {
		System.out.println("digite a msg");
		String msg="";
		
		while(!msg.contains("exit")) {
		encaixeCliente = new Socket(ip, porta);
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream(), true);
		msg="";
		LocalTime horario;
		Scanner scanner = new Scanner(System.in);
		
		horario = LocalTime.now();
		msg = scanner.nextLine();
		
		
		String msgEncriptada;
		
		//msgEncriptada = encriptar(3, msg);
		msgEncriptada= msg;
		msgEncriptada = msgEncriptada + "\n" + "hor�rio de envio:" + horario;
		escritor.write(msgEncriptada);
		escritor.flush();
		escritor.close();
		
		}
		
	}
	
	public void receber() throws Exception {
		 BufferedReader entrada = new BufferedReader(new InputStreamReader(encaixeCliente.getInputStream()));
		 String msgRecebida="";
		 msgRecebida = decriptar(3, entrada.readLine());
		 System.out.println(msgRecebida);
	}

	public String encriptar(int chave, String texto){
	      StringBuilder textoCifrado = new StringBuilder();
	      int tamanhoTexto = texto.length();
	      for(int c=0; c < tamanhoTexto; c++){
	         int letraCifradaASCII = ((int) texto.charAt(c)) + chave;
	         while(letraCifradaASCII > 126)
	            letraCifradaASCII -= 94;
	         textoCifrado.append( (char)letraCifradaASCII );
	      }
	      return textoCifrado.toString();
	   }
	
	   public String decriptar(int chave, String textoCifrado){
		      StringBuilder texto = new StringBuilder();
		      int tamanhoTexto = textoCifrado.length();
		      
		      for(int c=0; c < tamanhoTexto; c++){
		         int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;
		         
		         while(letraDecifradaASCII < 32)
		            letraDecifradaASCII += 94;

		         texto.append( (char)letraDecifradaASCII );
		      }
		      
		      return texto.toString();
	}
	   
		
		public int definirPorta() throws Exception {
			
			int porta = 0;
			int portas[] = {3000, 3002, 3004, 3006, 3008};
			
			for (int i = 0; i < portas.length; i++) {
				testePorta = new Socket("127.0.0.1",portas[i]);
				if (testePorta.isConnected()) {
					porta = portas[i];
				}
			}
			
			return porta;
		};
		public void setPorta(int porta) {
			this.porta = porta;
		}
}
