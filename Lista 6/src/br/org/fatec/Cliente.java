package br.org.fatec;

import java.util.ArrayList;

public class Cliente {
	public String nome;
	public String telefone;
	public String cpf;
	public String endereco;
	public ArrayList<Animais> animais = new ArrayList<Animais>();
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String perfilCliente;
		perfilCliente =
				"========" + 
				"Nome: " + this.getNome() + 
				"Telefone: " + this.getTelefone() +
				"CPF: " + this.getCpf() + 
				"Endereco: " + this.getEndereco() + 
				"Quantidade de Pets: " + this.getAnimais().size();
		return perfilCliente;
	}

}
