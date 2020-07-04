package br.org.fatec;


public class Atendimento {
	
	private int id;
	private Cliente cliente;
	private Animais animal;
	private Profissional profissional;
	
	public Atendimento(Cliente cliente, Animais animal, Profissional profissional) {
		super();
		this.cliente = cliente;
		this.animal = animal;
		this.profissional = profissional;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Animais getAnimal() {
		return animal;
	}
	public void setAnimal(Animais animal) {
		this.animal = animal;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	@Override
	public String toString() {
		String perfilAtendimento;
		perfilAtendimento = 
				"========" + "\n" +
				"ID do Atndimento: " + this.getId() + 
				"\n" + " Cliente: " + this.getCliente().getNome() + " ID - " + this.getCliente().getId() + 
				"\n" + "Animal: " + this.getAnimal().getId() + 
				"\n" + "PetSister: " + this.getProfissional().getNome() + " ID = " + this.getProfissional().getId();
		
		return perfilAtendimento;
	}
}
