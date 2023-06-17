package testes;



import banco.Conexao;
import controller.LivroController;

public class Testes {
	
	public static void main(String[] args) {
		
		
		Conexao conexaoBd = new Conexao();
		
		conexaoBd.getConexao();
		
		LivroController livroController = new LivroController();
		
		livroController.salvar("Harry Potter e as Reliquias da Morte", "JK");

	} 
	
	

}
