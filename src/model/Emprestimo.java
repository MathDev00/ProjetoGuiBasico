package model;

import java.sql.Date;
import java.util.Calendar;

public class Emprestimo {
	
	private int id;
	private Aluno id_aluno;	
	private Livro id_livro;	
	private int quantidade_livro;
	private Date data_empretimo;
	
	
	
	
	
	public Emprestimo(int id, Aluno id_aluno, Livro id_livro, int quantidade_livro, Date data_empretimo) {

		this.id = id;
		this.id_aluno = id_aluno;
		this.id_livro = id_livro;
		this.quantidade_livro = quantidade_livro;
		this.data_empretimo = data_empretimo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getId_aluno() {
		return id_aluno;
	}
	public Livro getId_livro() {
		return id_livro;
	}
	public int getQuantidade_livro() {
		return quantidade_livro;
	}
	public Date getData_empretimo() {
		return data_empretimo;
	}


	@Override
	public String toString() {
		return  "\nAluno:" + id_aluno.getNome() + " \nLivro:" + id_livro.getNome() + "\nQtde:" + this.quantidade_livro+ "\nData: " +this.data_empretimo;
	}
	
	
	
	
	
	
	

}
