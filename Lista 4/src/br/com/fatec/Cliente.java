package br.com.fatec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private String ip;
	private int porta;
	private Socket encaixeCliente;
	private ServerSocket encaixe;
	private String nome;
	 

	public Cliente(String ip,int porta) throws Exception {
		this.ip=ip;
		this.porta=porta;		
	}
	
	public void enviar() throws Exception {
		System.out.println("Digite seu nome:");
		Scanner Nome = new Scanner(System.in);
		this.nome = Nome.nextLine();
		
		String msg="";
		System.out.println("Digite a msg");
		
		while(!msg.contains("exit")){
		Scanner scanner = new Scanner(System.in);
		msg = scanner.nextLine();
		encaixeCliente = new Socket(ip, porta);
		PrintWriter escritor = 
				new PrintWriter(encaixeCliente.getOutputStream(),true);
		String msgEncriptada;
		msg=nome +"->"+msg;
		msgEncriptada = encriptar(3, msg);
		escritor.write( msgEncriptada);
		escritor.close();
		}	
	}
	
	public void receber() throws Exception {
		encaixe = new ServerSocket(porta);
		while (true) {
		Socket conexaoCliente = encaixe.accept(); 
		InputStreamReader leitorFluxo = 
			new InputStreamReader(conexaoCliente.getInputStream());			
		BufferedReader buffer = new BufferedReader(leitorFluxo);
		String texto = buffer.readLine();
		System.out.println(decriptar(3,texto));
		buffer.close();
		}
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
		public void setPorta(int porta) {
			this.porta = porta;
		}
}