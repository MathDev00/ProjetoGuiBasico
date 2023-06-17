package model;

public class Livro {
	
	private int id;
	private String nome;
	private String autor;
	
	
	
	
	public Livro(int id, String nome, String autor) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
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
	public String getAutor() {
		return autor;
	}

}
