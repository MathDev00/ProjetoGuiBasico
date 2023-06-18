package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import banco.Conexao;
import model.Livro;
import model.Aluno;
import model.Emprestimo;

public class EmprestimoDao {
	private Connection conexao;

	public EmprestimoDao() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Emprestimo c) {
//		INSERT INTO tb_cliente (nome, idade, id_cidade) VALUES ("Fulano", 20, 1)
		String sql = "INSERT INTO emprestimo (id_aluno, id_livro, quantidade_livro, data_emprestimo) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, c.getId_aluno().getId());
			stmt.setInt(2, c.getId_livro().getId());
			stmt.setInt(3, c.getQuantidade_livro());
			stmt.setDate(4, c.getData_empretimo());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Emprestimo buscarPorId(int id) {
		String sql = "SELECT * FROM emprestimo WHERE id = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			AlunoDao alunoDao = new AlunoDao();
			Aluno aluno = alunoDao.buscarPorId(rs.getInt("id_aluno"));

			LivroDao livroDao = new LivroDao();
			Livro livro = livroDao.buscarPorId(rs.getInt("id_livro"));
			
			Emprestimo emprestimo = new Emprestimo(rs.getInt("id"), aluno, livro, rs.getInt("quantidade_livro"), rs.getDate("data_emprestimo"));
			
	



			return emprestimo;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<Emprestimo> listarTodos() {
		String sql = "SELECT * FROM emprestimo";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();
			ArrayList<Emprestimo> emprestimos = new ArrayList<>();
			while (resultados.next()) {
				Aluno aluno = new AlunoDao().buscarPorId(resultados.getInt("id"));
				Livro livro = new LivroDao().buscarPorId(resultados.getInt("id"));


				Emprestimo emprestimo = new Emprestimo(resultados.getInt("id"), aluno, livro, resultados.getInt("quantidade_livro"), 
						resultados.getDate("data_emprestimo"));

				emprestimos.add(emprestimo);
			}
			stmt.close();
			return emprestimos;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}