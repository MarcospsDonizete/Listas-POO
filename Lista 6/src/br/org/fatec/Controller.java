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

    
}


