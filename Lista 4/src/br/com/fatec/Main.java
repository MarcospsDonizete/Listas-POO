package br.com.fatec;


public class Main {
	

	public static void main(String[] args) throws Exception {		
		Thread t1 = new Thread() {
            @Override
            public void run() {
            	Cliente c;
				try {
					c = new Cliente("127.0.0.1", 3000);
					c.enviar();
				} catch (Exception e) {
					System.out.println("erro ao conectar");
					e.printStackTrace();
				}			
        		
            }
 
        };
		Thread t2 = new Thread() {
            @Override
            public void run() {
            	Cliente c;
				try {
					c = new Cliente("127.0.0.1",3000);
					c.receber();
				} catch (Exception e) {
					System.out.println("erro ao conectar");
					e.printStackTrace();
				}			
        		
            }
 
        };
        
        t1.start();
		t2.start();
	}

}
