package br.org.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Controller {
	int ID = 1;
    private Scanner scan;
    private boolean execute;
    public ArrayList<Cliente> ListaClientes = new ArrayList<Cliente>();
    public ArrayList<Animais> TodosAnimais = new ArrayList<Animais>();
    public ArrayList<Profissional> Proficionais = new ArrayList<Profissional>();

    public void start() {
        scan = new Scanner(System.in);
        execute = true;
        System.out.println("\nBem-vindo!");

        while (execute) {
            String option = mainMenu();
            
            //Novo Cadastro
            if (option.equalsIgnoreCase("1")) {
            	String list = listMenuCad();
                     if (list.equalsIgnoreCase("1")) {
                    	 cadastrarCliente();
                     } else if (list.equalsIgnoreCase("2")) {
                    	 cadastrarAnimal();
                     } else if (list.equalsIgnoreCase("3")) {
                         // voltar para o inicio do programa
                     } else {
                         System.out.println("Favor digitar um número válido!!");
                     }
                
            } else if (option.equalsIgnoreCase("2")) {
                String list = listMenu();
                if (list.equalsIgnoreCase("1")) {
                	buscarClientes();
                } else if (list.equalsIgnoreCase("2")) {
                	buscarAnimais();
                } else if (list.equalsIgnoreCase("3")) {
                    // voltar para o inicio do programa
                } else {
                    System.out.println("Favor digitar um número válido!!");
                }

            }
        }
    }

    public String mainMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Listar Cadastros");
        System.out.println("3 - Agendamento de Revisões");
        System.out.println("4 - Troca de Datas de Agendamentos");
        System.out.println("5 - Cancelamentos");
        System.out.println("6 - Relátorios");
        System.out.println("7 - Sair");
        return scan.nextLine();
    }

    public String listMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Clientes");
        System.out.println("2 - Animais");
        System.out.println("3 - Voltar");
        return scan.nextLine();
    }
    
    public String listMenuCad() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Animal");
        System.out.println("3 - Voltar");
        return scan.nextLine();
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
    	for (Cliente cliente : ListaClientes) {
			System.out.println(cliente);
		}
    }
    
    private void removerCliente(String cpf) {
    	int cont = 0;
    	for(Cliente cliente: ListaClientes) {
    		 if(cliente.getCpf().equals(cpf)) {
    			 ListaClientes.remove(cont);
    		 }
    		 cont++;
    	}
    }
    
    private void buscarAnimais() {
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
                    animal.setId(ID);
                    ID+=1;
                    
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

    
	private String textInput(String label) {
        System.out.println(label);
        return scan.nextLine();
    }
	
	private int intInput(String string) {
		System.out.println(string);
		return scan.nextInt();
	}
    

    private void remove() {
    int id;
    boolean flag = false;
    boolean registering = true;
    while (registering) {
        System.out.println("\n ========Remover Cliente========");
        id = 0;
        String cpf= textInput("\n CPF: ");
           		removerCliente(cpf);
                    registering = false;
            break;

            };
        if(!flag) {
        	System.out.println("\nCPF não encontrado");
        }
        String newRegister = textInput("\nContinuar editando? (S/N)");
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

