package br.org.fatec;

public class Animais {
	public String raca;
	public String genero;
	public int idade;
	
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String perfilAnimal;
		perfilAnimal = 
			"========" + 
			"Ra�a: " + this.getRaca() + 
			"G�nero: " + this.getGenero() + 
			"Idade: " + this.getIdade();
		return perfilAnimal;
	}

}
