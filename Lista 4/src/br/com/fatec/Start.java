package br.com.fatec;

import java.util.Scanner;

import br.com.fatec.Cliente;

public class Start {
	
	public void onStart() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Cliente c = new Cliente("127.0.0.1",3000);
		System.out.println("Digite a mensagem.");
		String msg = scanner.next();
		c.enviar(msg);
	}
}