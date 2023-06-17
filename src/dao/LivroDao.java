package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import banco.Conexao;
import model.Livro;
import model.Livro;

public class LivroDao {
	private Connection conexao;

	public LivroDao() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Livro c) {
//		INSERT INTO tb_cliente (nome, idade, id_cidade) VALUES ("Fulano", 20, 1)
		String sql = "INSERT INTO livro (nome, autor) VALUES (?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getAutor());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}


	public Livro buscarPorId(int id) {
		String sql = "SELECT * FROM tb_cidade WHERE id = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			resultado.next();
			Livro c = new Livro(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("autor"));

			return c;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<Livro> listarTodas() {
		String sql = "SELECT * FROM tb_cidade";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();
			ArrayList<Livro> livros = new ArrayList<>();
			while (resultados.next()) {
				Livro c = new Livro(resultados.getInt("id"), resultados.getString("nome"),
						resultados.getString("autor"));
				livros.add(c);
			}
			stmt.close();
			return livros;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}