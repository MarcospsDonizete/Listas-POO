package br.com.fatec;

import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Cliente {
	private Socket encaixeCliente;

	public Cliente(String ip, int porta) throws Exception {
		System.out.println("Iniciando a conexão com o servidor...");
		encaixeCliente = new Socket(ip, porta);
	}
	
	public void enviar(String menssagem) throws Exception {
		LocalTime horario;
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		System.out.println("digite a msg");
		horario = LocalTime.now();
		String msg = scanner.next();
		msg = msg + "\n" + "horário de envio:" + horario;
		escritor.write(msg);
		escritor.close();
	}
}