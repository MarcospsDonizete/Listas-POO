package br.org.fatec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Servidor {
	private ServerSocket encaixe;
	private Socket encaixeCliente;
	private String ip;
	private int porta;
	//private (lista_servidores);

	public Servidor(int porta) throws Exception {
		System.out.println("Iniciando servidor...");
		encaixe = new ServerSocket(porta);
	}

	public void receber() throws Exception {
		LocalTime hora;
		
		while (true) {
			Socket conexaoCliente = encaixe.accept(); 
			InputStreamReader leitorFluxo = new InputStreamReader(conexaoCliente.getInputStream());
			
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String texto = buffer.readLine();
			hora = LocalTime.now();
			System.out.println(texto + "\n" + "horário chegada: " + hora);
	
			buffer.read();
			
		}
	}
	
	public void enviar(String msg) throws Exception {
		System.out.println("digite a msg");
		
		
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
		msgEncriptada = msgEncriptada + "\n" + "horário de envio:" + horario;
		escritor.write(msgEncriptada);
		escritor.flush();
		escritor.close();
		
		}
		
	}
}

