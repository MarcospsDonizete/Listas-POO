package br.org.fatec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket encaixe;
	private Socket encaixeCliente;
	private String ip;
	private int porta;

	public Servidor(int porta) throws Exception {
		System.out.println("Iniciando servidor...");
		encaixe = new ServerSocket(porta);
		this.ip="127.0.0.1";
		this.porta=3001;
	}

	public void receber() throws Exception {
		while (true) {
		Socket conexaoCliente = encaixe.accept(); 
		InputStreamReader leitorFluxo = 
			new InputStreamReader(conexaoCliente.getInputStream());			
		BufferedReader buffer = new BufferedReader(leitorFluxo);
		String texto = buffer.readLine();
		enviar(texto);
		buffer.close();
		}
	}
	
	public void enviar(String msg) throws Exception {
		encaixeCliente = new Socket(ip, porta);
		PrintWriter escritor = new PrintWriter(encaixeCliente.getOutputStream(), true);
		escritor.write(msg);
		escritor.flush();
		escritor.close();
	}
}

