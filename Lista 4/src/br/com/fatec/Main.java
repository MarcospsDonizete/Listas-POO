package br.com.fatec;


public class Main {
	

	public static void main(String[] args) throws Exception {	
		
		Thread t1 = new Thread() {
            @Override
            public void run() {
				try {
					Cliente clienteEnviar = new Cliente("127.0.0.1");
					int porta = clienteEnviar.definirPorta();
					clienteEnviar.setPorta(3000);
					clienteEnviar.enviar();
				} catch (Exception e) {
					System.out.println(e);
				}			
            }
 
        };
		Thread t2 = new Thread() {
            @Override
            public void run() {
				try {
					Cliente clienteReceber = new Cliente("127.0.0.1");
					int porta = clienteReceber.definirPorta();
					clienteReceber.setPorta(porta + 1);
					clienteReceber.receber();
				} catch (Exception e) {
					System.out.println(e);
				}			
            }
 
        };
        
        t1.start();
		//t2.start();
	}

}
