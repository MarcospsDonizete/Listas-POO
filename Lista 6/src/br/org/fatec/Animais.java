package br.org.fatec;

public class Animais {
	private String raca;
	private String genero;
	private int idade;
	private int id;

	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
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
		String perfilAnimal;
		perfilAnimal = 
			"========" + 
			"Raça: " + this.getRaca() + 
			"Gênero: " + this.getGenero() + 
			"Idade: " + this.getIdade() +
			"ID: " + this.getId();
		return perfilAnimal;
	}

}
