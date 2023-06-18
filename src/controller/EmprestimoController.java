package controller;

import java.sql.Date;

import dao.AlunoDao;
import dao.EmprestimoDao;
import model.Aluno;
import model.Emprestimo;
import model.Livro;

public class EmprestimoController {
	
	
public void salvar(Aluno id_aluno, Livro id_livro, int quantidade_livro, Date data_empretimo) 
	
	{


		
	Emprestimo emprestimo = new Emprestimo(0, id_aluno,id_livro, quantidade_livro, data_empretimo );
	EmprestimoDao emprestimoDao = new EmprestimoDao();
	emprestimoDao.inserir(emprestimo);
	}


}
