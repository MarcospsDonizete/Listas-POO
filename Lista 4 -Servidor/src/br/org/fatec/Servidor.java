package br.org.fatec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class Servidor {
	private ServerSocket encaixe;

	public Servidor(int porta) throws Exception {
		System.out.println("Iniciando servidor...");
		encaixe = new ServerSocket(porta);
	}

	public void receber() throws Exception {
		LocalTime hora;
		// Thread - ainda falta o processamento paralelo
		while (true) {
			Socket conexaoCliente = encaixe.accept(); // aceita a conexão
			InputStreamReader leitorFluxo = // a entra de dados
					new InputStreamReader(conexaoCliente.getInputStream());
			// transformando o fluxo de dados em texto.
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String texto = buffer.readLine();
			hora = LocalTime.now();
			System.out.println(texto + "\n" + "horário chegada: " + hora);
	
			buffer.close();
		}
	}
}

