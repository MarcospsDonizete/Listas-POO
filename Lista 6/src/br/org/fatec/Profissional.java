package br.org.fatec;

public class Profissional {
	
	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	private String endereco;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		String perfilProfissional;
		perfilProfissional = 
				"========" + "\n" +  
						"\n" + " Nome: " + this.getNome() + 
						"\n" + " Telefone: " + this.getTelefone() + 
						"\n" + " CPF: " + this.getCpf() + 
						"\n" + " Endereco: " + this.getEndereco();
		return perfilProfissional;
	}
	

}
