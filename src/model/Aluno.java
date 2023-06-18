package model;

public class Aluno {
	
	private int id;
	private String nome;
	
	
	
	public Aluno(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return this.nome;
	}
	
	
	
	

}
