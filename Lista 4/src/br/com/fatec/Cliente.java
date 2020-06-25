package br.com.fatec;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	private Socket encaixeCliente;

	public Cliente(String ip, int porta) throws Exception {
		System.out.println("Iniciando a conexão com o servidor...");
		encaixeCliente = new Socket(ip, porta);
	}
	
	public void enviar(String menssagem) throws Exception {
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream());
		escritor.write(menssagem);
		escritor.close();
	}
}
