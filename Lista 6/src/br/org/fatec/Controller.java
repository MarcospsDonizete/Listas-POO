package br.org.fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Controller {
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

            if (option.equalsIgnoreCase("1")) {
            	String list = listMenuCad();
                     if (list.equalsIgnoreCase("1")) {
                    	 register();
                     } else if (list.equalsIgnoreCase("2")) {
                    	 registerCar();
                     } else if (list.equalsIgnoreCase("3")) {
                         // voltar para o inicio do programa
                     } else {
                         System.out.println("Favor digitar um número válido!!");
                     }
                
            } else if (option.equalsIgnoreCase("2")) {
                String list = listMenu();
                if (list.equalsIgnoreCase("1")) {
                    showList();
                } else if (list.equalsIgnoreCase("2")) {
                	showCarsList();
                } else if (list.equalsIgnoreCase("3")) {
                    // voltar para o inicio do programa
                } else {
                    System.out.println("Favor digitar um número válido!!");
                }

            } else if (option.equalsIgnoreCase("3")) {
            	addRev();
            } else if (option.equalsIgnoreCase("4")) {
            	editRev();
            } else if (option.equalsIgnoreCase("5")) {
                remove();
            } else if (option.equalsIgnoreCase("6")) {
                relatorios();
            } else if (option.equalsIgnoreCase("7")) {
                execute = false;
            } else {
                System.out.println("Favor digitar um número válido!!");
            }
        }
    }

    public String mainMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Novo cadastro");
        System.out.println("2 - Listar cadastrados");
        System.out.println("3 - Agendamento de Revisões");
        System.out.println("4 - Troca de Datas de Agendamentos");
        System.out.println("5 - Cancelamentos");
        System.out.println("6 - Relátorios");
        System.out.println("7 - Sair");
        return scan.nextLine();
    }

    public String listMenu() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Todos os clientes cadastrados");
        System.out.println("2 - Carros cadastrados");
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
    public String listRev() {
        System.out.println("\nSelecione a opção: ");
        System.out.println("1 - Troca de óleo");
        System.out.println("2 - Calibragem dos pneus");
        System.out.println("3 - Troca de Bateria");
        System.out.println("4 - Lavagem");
        System.out.println("5 - Check-in completo");
        System.out.println("6 - Outros");
        System.out.println("7 - Voltar");
        return scan.nextLine();
    }

    private void register() {
        boolean registering = true;

        while (registering) {
            System.out.println("\nCadastro de Cliente");
            Cliente c = new Cliente();
            c.setNome(textInput("\nNome:"));
            c.setTelefone(textInput("\nTelefone:"));
            c.setEndereco(textInput("\nEndereço: "));
            c.setCpf(textInput("\nCPF "));

            String register = textInput("\nAdicionar cadastro (S/N) ?");
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
    
    private void registerCar() {
    	boolean flag = false;
        boolean registering = true;

        while (registering) {
            System.out.println("\nCadastro de veículo");
            Animais a = new Animais();
            String cpf= textInput("\nCPF do Proprietário:");
            for (Cliente x : ListaClientes) {
                if(x.getCpf().equals(cpf)) {
                	a.setProprietario(x.getNome());
                	a.setPlaca(textInput("\nPlaca:"));
                    a.setModelo(textInput("\nModelo: "));
                    a.setAno(Integer.parseInt((textInput("\nAno: "))));
                    a.setValor(Integer.parseInt(textInput("\nValor: ")));
                    x.setVeiculo(a);
                    
                    String register = textInput("\nAdicionar cadastro (S/N) ?");
                    if (register.equalsIgnoreCase("s")) {
                        System.out.println("Cadastro adicionado!!");
                        VeiculosList.cars.add(v);
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
    private void addRev() {
    	boolean flag = false;
        boolean registering = true;
        String aux;
        while (registering) {
            System.out.println("\nCadastro Revisão");
            String cpf= textInput("\nCPF do Proprietário:");
            for (Client x : clientList.clients) {
                if(x.getCpf().equals(cpf)) {
                	String list = listRev();
                    if (list.equalsIgnoreCase("1")) {
                    	x.veiculo.servicos.add(colocarRev("Troca de óleo"));
                    } else if (list.equalsIgnoreCase("2")) {
                    	x.veiculo.servicos.add(colocarRev("Calibragem dos pneus"));
                    } else if (list.equalsIgnoreCase("3")) {
                    	x.veiculo.servicos.add(colocarRev("Troca de Bateria"));
                    } else if (list.equalsIgnoreCase("4")) {
                    	x.veiculo.servicos.add(colocarRev("Lavagem"));
                    } else if (list.equalsIgnoreCase("5")) {
                    	x.veiculo.servicos.add(colocarRev("Check-in completo"));
                    } else if (list.equalsIgnoreCase("6")) {
                    	aux = textInput("\nDigite o servico: ");
                    	x.veiculo.servicos.add(colocarRev("Outros: "+aux));
                    } else if (list.equalsIgnoreCase("7")) {
                    	// voltar para o inicio do programa
                    } else {
                        System.out.println("Favor digitar um número válido!!");
                    }                	
                    String register = textInput("\nAdicionar cadastro (S/N) ?");
                    if (register.equalsIgnoreCase("s")) {
                        System.out.println("Cadastro adicionado!!");
                        
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
    	
    private Servicos colocarRev(String Rev) {
    	Servicos s = new Servicos();
    	s.setData(textInput("\nData do Serviço: "));
    	s.setRelatorios(Rev + "\n");
    	return s;
    }
    
    private void relatorios() {
    	boolean flag = false;
        boolean registering = true;
        while (registering) {
            System.out.println("\nServiços");
            String cpf= textInput("\nCPF do Cliente:");
            for (Client x : clientList.clients) {
                if(x.getCpf().equals(cpf)) {
                	System.out.println("Para o cliente "+x.getNome()+" serão prestados os seguintes serviços");
                	showListServicos(x);                	
                flag= true;
                break;
                };
            }
            if(!flag) {
            	System.out.println("\nCPF não encontrado");
            }
            String newRegister = textInput("\nContinuar neste menu? (S/N)");
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
    
    private void showListServicos(Client y) {
    	int i=1;
        if (y.veiculo.servicos.size() == 0) {
            System.out.println("\nNão existem serviços cadastros !!!\n");
        } else {
            System.out.println("\nLista de Serviços\n");
            for (Servicos x : y.veiculo.servicos) {
                System.out.println(i + " - " + x);
                i++;
            }
            System.out.println("\nFim da lista\n");
        }
    }
    
    private void showList() {
        sortList();
        if (clientList.clients.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Client x : clientList.clients) {
                System.out.println(x);
            }
            System.out.println("\nFim da lista\n");
        }
    }
    private void showCarsList() {
        sortCarsList();
        if (VeiculosList.cars.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (Veiculos x : VeiculosList.cars) {
            	System.out.println("Proprietário: "+x.proprietario+"\n"+x);
            			}
            	}
          System.out.println("\nFim da lista\n");
          }
    
	private String textInput(String label) {
        System.out.println(label);
        return scan.nextLine();
    }

    private void sortList() {
        Collections.sort(clientList.clients);
    }
    
    private void sortCarsList() {
        Collections.sort(VeiculosList.cars);
    }

    private void editRev() {
        int id;
        String aux;
        boolean flag = false;
        boolean registering = true;
        while (registering) {
            System.out.println("\nEditar Revisão");
            id = 0;
            aux="";
            String cpf= textInput("\nCPF do Proprietário:");
            for (Client y : clientList.clients) {
                if(y.getCpf().equals(cpf)) {
                	System.out.println("\nLista de Cadastros\n");
                    for (Servicos x : y.veiculo.servicos) {
                    	id += 1;
                    	System.out.println(id+" - "+ x);
                        }
                        String select = textInput("Digite o numero do serviço a ser editado, caso nao queira editar, digite exit\n");
                        if(select == "exit" || select == "Exit") {
                        } else {
                            int index = Integer.parseInt(select);
                            index -= 1;
                            String option = textInput("Selecione 1-Data / 2- Serviços prestados / 3 - Voltar");
                            if(option.equalsIgnoreCase("1")) {
                            	y.veiculo.servicos.get(index).setData(textInput("\nDigite a nova data"));
                            } else if(option.equalsIgnoreCase("2")) {
                            	String list = listRev();
                                if (list.equalsIgnoreCase("1")) {
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Troca de óleo");
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("2")) {
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Calibragem dos pneus");
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("3")) {
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Troca de Bateria");
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("4")) {
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Lavagem");
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("5")) {
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Check-in completo");
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("6")) {
                                	aux = textInput("\nDigite o serviço: ");
                                	y.veiculo.servicos.get(Integer.parseInt(select)-1).setRelatorios("Outros: "+aux);
                                	System.out.println("Revisão editada");
                                } else if (list.equalsIgnoreCase("7")) {
                                	registering = false;
                                } else {
                                    System.out.println("Favor digitar um número válido!!");
                                }
                            } else if(option.equalsIgnoreCase("3")) {
                            	registering = false;
                            } else {
                                System.out.println("Digite um número válido!!");
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
                flag= true;
                break;

                };
            }
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
        }
    

    private void remove() {
    int id;
    boolean flag = false;
    boolean registering = true;
    while (registering) {
        System.out.println("\nCancelamento Revisão");
        id = 0;
        String cpf= textInput("\nCPF do Proprietário:");
        for (Client y : clientList.clients) {
            if(y.getCpf().equals(cpf)) {
            	System.out.println("\nLista de Cadastros\n");
                for (Servicos x : y.veiculo.servicos) {
                	id += 1;
                	System.out.println(id+" - "+ x);
                    }
                    String select = textInput("Digite o numero do serviço a ser cancelado, caso nao queira cancelar, digite exit\n");
                    if(select == "exit" || select == "Exit") {
                    } else {
                    	y.veiculo.servicos.remove(Integer.parseInt(select)-1);
                    	System.out.println("Revisão cancelada");
                        
                String newRegister = textInput("\nContinuar editando? (S/N)");
                if (newRegister.equalsIgnoreCase("N")) {
                    registering = false;
                } else if (newRegister.equalsIgnoreCase("s")) {
                    // se for s sai do if e volta para o inicio do while
                } else {
                    System.out.println("\nOpção inválida, parando o cadastro!! \n");
                }
            flag= true;
            break;

            };
        }
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
    }
}
