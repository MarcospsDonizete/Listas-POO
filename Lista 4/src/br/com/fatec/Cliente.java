package br.com.fatec;

import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Cliente {
	private Socket encaixeCliente;
	private Criptografia criptografia;

	public Cliente(String ip, int porta) throws Exception {
		System.out.println("Iniciando a conexão com o servidor...");
		encaixeCliente = new Socket(ip, porta);
	}
	
	public void enviar() throws Exception {
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream(), true);
		System.out.println("digite a msg");
		String msg="";
		
		while(!msg.contains("exit")) {
		msg="";
		LocalTime horario;
		Scanner scanner = new Scanner(System.in);
		
		horario = LocalTime.now();
		msg = scanner.nextLine();
		msg = criptografia.encriptar(3, msg);
		msg = msg + "\n" + "horário de envio:" + horario;
		escritor.write(msg);
		escritor.flush();
		}
		escritor.close();
	}
	
}