package controller;

import dao.LivroDao;
import model.Livro;

public class LivroController {
	
	public void salvar(String nome, String autor) 
	{

		
		Livro livro = new Livro(0, nome,autor);
		LivroDao livroDao = new LivroDao();
		livroDao.inserir(livro);
	}

}
