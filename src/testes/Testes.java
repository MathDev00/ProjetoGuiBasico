package testes;



import banco.Conexao;
import controller.EmprestimoController;
import controller.LivroController;
import dao.AlunoDao;
import dao.EmprestimoDao;

public class Testes {
	
	public static void main(String[] args) {
		
		
		Conexao conexaoBd = new Conexao();
		
		conexaoBd.getConexao();
		
		LivroController livroController = new LivroController();
		
		livroController.salvar("Harry Potter e as Reliquias da Morte", "JK");

		
		AlunoDao teste = new AlunoDao();
		EmprestimoDao teste2 = new EmprestimoDao();

		
		System.out.println(teste.listarTodas());
		System.out.println(teste2.listarTodos());
		
		EmprestimoController emprestimoDao = new EmprestimoController();


	} 
	
	

}
