package controller;

import dao.AlunoDao;
import model.Aluno;

public class AlunoController {
	
	
	public void salvar(String nome) 
	
	{


		
		Aluno aluno = new Aluno(0, nome);
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.inserir(aluno);
	}

}
