package br.com.fatec;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private Socket encaixeCliente;

	public Cliente(String ip, int porta) throws Exception {
		System.out.println("Iniciando a conexão com o servidor...");
		encaixeCliente = new Socket(ip, porta);
	}
	
	public void enviar() throws Exception {
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream());
		System.out.println("digite a msg");
		String msg="";
		
		while(!msg.contains("exit")) {
		msg="";
		
		Scanner scanner = new Scanner(System.in);
		
		
		msg = scanner.nextLine();
		
		escritor.write(msg);
		
		escritor.close();
		}
	}
	
}