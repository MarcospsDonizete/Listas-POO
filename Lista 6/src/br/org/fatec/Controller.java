package br.org.fatec;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	int idAnimal = 0;
	int idCliente = 0;
	int idProfissional = 0;
	int idAtendimento = 0;
    private Scanner scan;
    private boolean execute;
    public ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();
    public ArrayList<Animais> TodosAnimais = new ArrayList<Animais>();
    public ArrayList<Profissional> ListaProfissionais = new ArrayList<Profissional>();
    public ArrayList<Atendimento> ListaAtendimentos = new ArrayList<Atendimento>();

    public void start() {
        scan = new Scanner(System.in);
        execute = true;
        System.out.println("\nBem-vindo!");
        GerarPovo();

        while (execute) {
            String option = mainMenu();
            
            
            //Novo Cadastro
            if (option.equalsIgnoreCase("1")) {
            	String list = listMenuCad();
            		 //Cadastro Cliente
                     if (list.equalsIgnoreCase("1")) {
                    	 cadastrarCliente();
                     }
                     //Cadastro Animal
                     else if (list.equalsIgnoreCase("2")) {
                    	 cadastrarAnimal();
                     }
                     //Cadastro Profissional
                     else if (list.equalsIgnoreCase("3")) {
                        CadastrarProfissional();
                     }
                     //Cadastro Atendimento
                     else if (list.equalsIgnoreCase("4")){
                    	 cadastrarAtendimento();
                     }
                     //SAIR
                     else {
                    	 System.out.println("Favor digitar um número válido!!");
                     }
                
            }
            //Listar Cadastros
            else if (option.equalsIgnoreCase("2")) {
                String list = listMenu();
                
                //Clientes
                if (list.equalsIgnoreCase("1")) {
                	buscarClientes();
                }
                //Animais
                else if (list.equalsIgnoreCase("2")) {
                	buscarAnimais();
                }
                //Atendimentos
                else if (list.equalsIgnoreCase("3")) {
                	buscarAtendimentos();
                }
                //Remover Cliente
                else if (list.equalsIgnoreCase("4")) {
                	removerCliente();
                }
               //Remover Animal
                else if (list.equalsIgnoreCase("5")) {
                	removerAnimal();
                }
                //Remover Profissional
                else if (list.equalsIgnoreCase("6")) {
                	removerProfisional();
                }
                //Remover Atendimento
                else if (list.equalsIgnoreCase("6")) {
                	removerAtendimento();
                }
                else {
                    System.out.println("Favor digitar um número válido!!");
                }

            }
        }
    }

    public String mainMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Listar Cadastros");
        System.out.println("3 - Voltar");
        return scan.nextLine();
    }

    public String listMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Clientes");
        System.out.println("2 - Animais");
        System.out.println("3 - Atendimentos");
        System.out.println("4 - Remover Cliente");
        System.out.println("5 - Remover Animal");
        System.out.println("6 - Remover Profissional");
        System.out.println("7 - Remover Atendimento");
        System.out.println("8 - Sair");
        return scan.nextLine();
    }
    
    public String listMenuCad() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Animal");
        System.out.println("3 - Cadastrar Profissional");
        System.out.println("5 - Cadastrar Atendimento");
        System.out.println("5 - Sair");
        return scan.nextLine();
    }

    public void cadastrarAtendimento() {
    	
    	Cliente clienteAtendimento = null;
    	Animais animalAtendimento = null;
    	Profissional profissionalAtendimento = null;
    	
    	System.out.println("Id do Cliente: ");
    	int idClienteAtendimento = scan.nextInt();
    	
    	System.out.println("Id do animal");
    	int idAnimalAtendimento = scan.nextInt();
    	
    	System.out.println("Id do Petsister: ");
    	int idProfissionalAtendimento = scan.nextInt();
    	
    	for(Cliente cliente: ListaClientes) {
    		if (cliente.getId() == idClienteAtendimento ) {
    			clienteAtendimento = cliente;
    		}
    	}
    	
    	for (Animais animal: TodosAnimais) {
    		if (animal.getId() == idAnimalAtendimento) {
    			animalAtendimento = animal;
    		}
    	}
    	
    	for (Profissional profissional : ListaProfissionais) {
    		if (profissional.getId() == idProfissionalAtendimento) {
    			profissionalAtendimento = profissional;
    		}
    	}
    	
    	if (clienteAtendimento != null && animalAtendimento != null && profissionalAtendimento != null) {
    		Atendimento atendimento = new Atendimento(clienteAtendimento, animalAtendimento, profissionalAtendimento);
    		atendimento.setId(idAtendimento);
    		idAtendimento++;
    		ListaAtendimentos.add(atendimento);
    		
    	}
    	
    }
    
    private void buscarAtendimentos() {
    	System.out.println("Quantidade: " + ListaAtendimentos.size());
    	for (Atendimento atendimento: ListaAtendimentos) {
    		System.out.println(atendimento);
    	}
    }
    
    private void removerAtendimento() {
    	System.out.println("Insira o id: ");
    	int id = scan.nextInt();
    	for (Atendimento atendimento:  ListaAtendimentos) {
    		if (atendimento.getId() == id) {
    			ListaAtendimentos.remove(atendimento);
    		}
    	}
    }

    private void cadastrarCliente() {
        boolean registering = true;

        while (registering) {
            System.out.println("\nCadastro de Cliente");
            Cliente c = new Cliente();
            c.setNome(textInput("\n Nome:"));
            c.setTelefone(textInput("\n Telefone:"));
            c.setEndereco(textInput("\n Endereço: "));
            c.setCpf(textInput("\nCPF "));
            c.setId(idCliente);
            idCliente++;

            String register = textInput("\n Adicionar cadastro (S/N) ?");
            if (register.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado!!");
                ListaClientes.add(c);
            } else if (register.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida, favor digitar denovo!! \n");
            }
            String newRegister = textInput("\nContinuar cadastrando (S/N) ?");
            if (newRegister.equalsIgnoreCase("N")) {
                registering = false;
            } else if (newRegister.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida, parando o cadastro!! \n");
                registering = false;
            }
        }
    }
    
    private void buscarClientes() {
    	System.out.println("Quantidade: " + ListaClientes.size());
    	for (Cliente cliente : ListaClientes) {
			System.out.println(cliente);
		}
    }
    
    private void removerCliente() {
    	int cont = 0;
    	boolean removeu = false;
    	System.out.println("Insira o CPF: ");
    	String cpf = scan.nextLine();
    	for(Cliente cliente: ListaClientes) {
    		 if(cliente.getCpf().equals(cpf)) {
    			 ListaClientes.remove(cont);
    			 removeu = true;
    		 }
    		 cont++;
    	}
    	if (removeu) {
    		System.out.println("Removido.");
    	}
    	else {
    		System.out.println("Não foi possível remover.");
    	}
    }
    
    private void buscarAnimais() {
    	System.out.println("Quantidade: " + TodosAnimais.size());
    	for (Animais animal: TodosAnimais) {
    		System.out.println(animal);
    	}
    }
    
    private void cadastrarAnimal() {
    	boolean flag = false;
        boolean registering = true;

        while (registering) {
            System.out.println("\n========Cadastro de Pet========");
            
            String cpf= textInput("\nCPF do Dono:");
            
            for (Cliente cliente : ListaClientes) {
                if(cliente.getCpf().equals(cpf)) {
                	
                    String raca = textInput("\n Raça: ");
                    String genero = textInput("\n Gênero: ");
                    int idade = intInput("\n idade: ");
                    
                    Animais animal = new Animais();
                    
                    animal.setRaca(raca);
                    animal.setGenero(genero);
                    animal.setIdade(idade);
                    animal.setId(idAnimal);
                    idAnimal+=1;
                    
                    String register = textInput("\nAdicionar cadastro (S/N) ?");
                    if (register.equalsIgnoreCase("s")) {
                        System.out.println("Cadastro adicionado!!");
                        TodosAnimais.add(animal);             
                    } else if (register.equalsIgnoreCase("n")) {
                        System.out.println("Cadastro ignorado !!!");
                    } else {
                        System.out.println("\nOpção inválida, favor digitar denovo!! \n");
                    }
                flag= true;
                break;
                };
            }
            if(!flag) {
            	System.out.println("\nCPF não encontrado");
            }
            String newRegister = textInput("\nContinuar cadastrando (S/N) ?");
            if (newRegister.equalsIgnoreCase("N")) {
                registering = false;
            } else if (newRegister.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida, parando o cadastro!! \n");
                registering = false;
            }
        }
    }

    private void removerAnimal() {
    	System.out.println("Insira o id: ");
    	int id = scan.nextInt();
    	for (Animais animal:  TodosAnimais) {
    		if (animal.getId() == id) {
    			TodosAnimais.remove(animal);
    		}
    	}
    }
    
    private void CadastrarProfissional() {
        boolean registering = true;

        while (registering) {
            System.out.println("\nCadastro de Profissional");
            Profissional p = new Profissional();
            p.setNome(textInput("\n Nome:"));
            p.setTelefone(textInput("\n Telefone:"));
            p.setEndereco(textInput("\n Endereço: "));
            p.setCpf(textInput("\nCPF "));
            p.setId(idProfissional);
            idProfissional++;

            String register = textInput("\n Adicionar cadastro (S/N) ?");
            if (register.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado!!");
                ListaProfissionais.add(p);
            } else if (register.equalsIgnoreCase("n")) {
                System.out.println("Cadastro ignorado !!!");
            } else {
                System.out.println("\nOpção inválida, favor digitar denovo!! \n");
            }
            String newRegister = textInput("\nContinuar cadastrando (S/N) ?");
            if (newRegister.equalsIgnoreCase("N")) {
                registering = false;
            } else if (newRegister.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida, parando o cadastro!! \n");
                registering = false;
            }
        
        }
     }
    
    private void removerProfisional() {
    	System.out.println("Insira o id: ");
    	int id = scan.nextInt();
    	for (Profissional profissional:  ListaProfissionais) {
    		if (profissional.getId() == id) {
    			ListaProfissionais.remove(profissional);
    		}
    	}
    }

    private String textInput(String label) {
        System.out.println(label);
        return scan.nextLine();
    }
	
	private int intInput(String string) {
		System.out.println(string);
		return scan.nextInt();
	}

	public void GerarPovo(){
		Cliente c = new Cliente();
		Animais a1 = new Animais();
		Animais a2 = new Animais();
		Animais a3 = new Animais();
		Animais a4 = new Animais();
		Animais a5 = new Animais();
		ArrayList<Animais> list = new ArrayList <Animais>();
		
		c.setNome("Robson Silva Tche");
		c.setTelefone("3933-1687");
		c.setEndereco("Rua das Bahianas N 60");
		c.setCpf("490.890.168-31");
		
		a1.setGenero("Feminino");
		a1.setId(1);
		a1.setIdade(3);
		a1.setRaca("Poodle");
		
		a2.setGenero("Masculino");
		a2.setId(2);
		a2.setIdade(5);
		a2.setRaca("Pastor-Alemão");
		
		a3.setGenero("Feminino");
		a3.setId(3);
		a3.setIdade(5);
		a3.setRaca("Border Collie");
		
		a4.setGenero("Feminino");
		a4.setId(4);
		a4.setIdade(1);
		a4.setRaca("Beagle");

		a5.setGenero("Masculino");
		a5.setId(5);
		a5.setIdade(2);
		a5.setRaca("Poodle");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		TodosAnimais.add(a4);
		TodosAnimais.add(a5);
		
		ListaClientes.add(c);
		
		c.setAnimais(list);
		
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Tony Stark");
		c.setTelefone("1299744-2245");
		c.setEndereco("10880, Malibu Point, 90265");
		c.setCpf("350.678.890-x");
		
		a1.setGenero("Masculino");
		a1.setId(6);
		a1.setIdade(9);
		a1.setRaca("Boxer");
		
		a2.setGenero("Masculino");
		a2.setId(7);
		a2.setIdade(6);
		a2.setRaca("Pastor-Alemão");
		
		a3.setGenero("Feminino");
		a3.setId(8);
		a3.setIdade(3);
		a3.setRaca("Chow Chow");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		ListaClientes.add(c);
		
		c.setAnimais(list);
		
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Bruce Wayne");
		c.setTelefone("911");
		c.setEndereco("Gotham City");
		c.setCpf("760.182.450-x1");
		
		a1.setGenero("Feminino");
		a1.setId(9);
		a1.setIdade(3);
		a1.setRaca("Poodle");
		
		a2.setGenero("Masculino");
		a2.setId(10);
		a2.setIdade(5);
		a2.setRaca("Poodle");
		
		a3.setGenero("Feminino");
		a3.setId(11);
		a3.setIdade(5);
		a3.setRaca("Pastor-Alemão");
		
		a4.setGenero("Feminino");
		a4.setId(12);
		a4.setIdade(1);
		a4.setRaca("Pastor-Alemão");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		TodosAnimais.add(a4);
		ListaClientes.add(c);
		
		c.setAnimais(list);
		
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Bruce Banner");
		c.setTelefone("1 4145-1289");
		c.setEndereco("Rua Verdureiras N 144");
		c.setCpf("15.401.320-1");
		
		a1.setGenero("Feminino");
		a1.setId(12);
		a1.setIdade(15);
		a1.setRaca("Beagle");
		
		list.add(a1);
		TodosAnimais.add(a1);
		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Carol Danvers");
		c.setTelefone("12 98287-1519");
		c.setEndereco("Avenida Brasil N 1500");
		c.setCpf("67.789.192-0");
		
		a1.setGenero("Feminino");
		a1.setId(13);
		a1.setIdade(9);
		a1.setRaca("Pastor-Alemão");
		
		a2.setGenero("Masculino");
		a2.setId(14);
		a2.setIdade(8);
		a2.setRaca("Chow Chow");
		
		a3.setGenero("Feminino");
		a3.setId(15);
		a3.setIdade(12);
		a3.setRaca("Chihuahua");
			
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Betina da Empiricus");
		c.setTelefone("4003-3118");
		c.setEndereco("Rua dos Milhonários N 167");
		c.setCpf("89.671.590-0");
		
		a1.setGenero("Masculino");
		a1.setId(16);
		a1.setIdade(3);
		a1.setRaca("Pinscher");
		
		a2.setGenero("Masculino");
		a2.setId(17);
		a2.setIdade(5);
		a2.setRaca("Pinscher");
		
		a3.setGenero("Feminino");
		a3.setId(18);
		a3.setIdade(5);
		a3.setRaca("Golden Retriever");
				
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		
		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Cleiton Roberto Araujo");
		c.setTelefone("12 3354-1890");
		c.setEndereco("Avenida dos Soldados n 1893");
		c.setCpf("490.890.168-31");
		
		a1.setGenero("Masculino");
		a1.setId(19);
		a1.setIdade(10);
		a1.setRaca("Labrador");
		
		a2.setGenero("Masculino");
		a2.setId(20);
		a2.setIdade(4);
		a2.setRaca("Labrador");
		
		a3.setGenero("Feminino");
		a3.setId(21);
		a3.setIdade(5);
		a3.setRaca("Border Collie");
		
		a4.setGenero("Feminino");
		a4.setId(22);
		a4.setIdade(12);
		a4.setRaca("Beagle");

		a5.setGenero("Masculino");
		a5.setId(23);
		a5.setIdade(7);
		a5.setRaca("Chihuahua");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		TodosAnimais.add(a4);
		TodosAnimais.add(a5);
		
		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Clarissélia Bezerra Cabrita");
		c.setTelefone("12 98819-6789");
		c.setEndereco("Beco da Quebrada N 190");
		c.setCpf("19.911.123-x9");
		
		a1.setGenero("Feminino");
		a1.setId(24);
		a1.setIdade(14);
		a1.setRaca("Pinscher");
		
		a2.setGenero("Masculino");
		a2.setId(25);
		a2.setIdade(10);
		a2.setRaca("Pinscher");
		
		a3.setGenero("Feminino");
		a3.setId(26);
		a3.setIdade(9);
		a3.setRaca("Pastor-Alemão");
		
		a4.setGenero("Feminino");
		a4.setId(27);
		a4.setIdade(13);
		a4.setRaca("Beagle");

		a5.setGenero("Masculino");
		a5.setId(28);
		a5.setIdade(2);
		a5.setRaca("Labrador");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);
		TodosAnimais.add(a4);
		TodosAnimais.add(a5);
		
		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();		
		
		c.setNome("Bill Gates");
		c.setTelefone("(11) 4706 0900");
		c.setEndereco("Rua dos Programadores N 42");
		c.setCpf("420.167.829-1");
		
		a1.setGenero("Feminino");
		a1.setId(29);
		a1.setIdade(3);
		a1.setRaca("Beagle");
		
		a2.setGenero("Masculino");
		a2.setId(30);
		a2.setIdade(2);
		a2.setRaca("Beagle");
		
		a3.setGenero("Feminino");
		a3.setId(31);
		a3.setIdade(1);
		a3.setRaca("Border Collie");
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);

		ListaClientes.add(c);
		
		c.setAnimais(list);
		c = new Cliente();
		list = new ArrayList <Animais>();
		
		c.setNome("Sheldon Cooper");
		c.setTelefone("1 4242-0001");
		c.setEndereco("Rua das Cordas N 42");
		c.setCpf("980.192.124-x");
		
		a1.setGenero("Feminino");
		a1.setId(32);
		a1.setIdade(1);
		a1.setRaca("Labrador");
		
		a2.setGenero("Masculino");
		a2.setId(33);
		a2.setIdade(2);
		a2.setRaca("Golden Retriever");
		
		a3.setGenero("Feminino");
		a3.setId(34);
		a3.setIdade(3);
		a3.setRaca("Chihuahua");
				
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		TodosAnimais.add(a1);
		TodosAnimais.add(a2);
		TodosAnimais.add(a3);

		c.setAnimais(list);
		
		ListaClientes.add(c);
		
		
	}
}


