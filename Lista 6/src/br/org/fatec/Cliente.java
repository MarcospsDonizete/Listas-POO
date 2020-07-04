package br.org.fatec;

import java.util.ArrayList;

public class Cliente {
	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	private String endereco;
	private ArrayList<Animais> animais = new ArrayList<Animais>();
	public ArrayList<Animais> getAnimais() {
		return animais;
	}
	
	public void setAnimais(ArrayList<Animais> animais) {
		this.animais = animais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String perfilCliente;
		perfilCliente =
				"========" + "\n" + 
						"\n" + " Nome: " + this.getNome() + 
						"\n" + " Telefone: " + this.getTelefone() +
						"\n" + " CPF: " + this.getCpf() + 
						"\n" + " Endereco: " + this.getEndereco() + 
						"\n" + " Quantidade de Pets: " + this.getAnimais().size();
		return perfilCliente;
	}

}
