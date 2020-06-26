package br.com.fatec;

public class Main {

	public static void main(String[] args) throws Exception {
		Cliente c = new Cliente("127.0.0.1",3000);
		c.enviar("to sem ideia");  
	}

}
