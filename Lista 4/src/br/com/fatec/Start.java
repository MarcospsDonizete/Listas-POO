package br.com.fatec;

import br.com.fatec.Cliente;

public class Start {
	Cliente c = new Cliente("127.0.0.1",3000);
	c.enviar("to sem ideia");
}
