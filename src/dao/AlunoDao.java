package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import banco.Conexao;
import model.Aluno;


public class AlunoDao {
	private Connection conexao;

	public AlunoDao() {
		this.conexao = Conexao.getConexao();
	}

	public void inserir(Aluno c) {
//		INSERT INTO tb_cliente (nome, idade, id_cidade) VALUES ("Fulano", 20, 1)
		String sql = "INSERT INTO aluno (nome) VALUES (?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}


	public Aluno buscarPorId(int id) {
		String sql = "SELECT * FROM aluno WHERE id = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			resultado.next();
			Aluno c = new Aluno(resultado.getInt("id"), resultado.getString("nome"));

			return c;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<Aluno> listarTodas() {
		String sql = "SELECT * FROM aluno";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery();
			ArrayList<Aluno> alunos = new ArrayList<>();
			while (resultados.next()) {
				Aluno c = new Aluno(resultados.getInt("id"), resultados.getString("nome"));
				alunos.add(c);
			}
			stmt.close();
			return alunos;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	
	
	
	
}