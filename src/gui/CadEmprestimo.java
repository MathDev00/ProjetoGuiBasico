package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;

import dao.AlunoDao;
import dao.LivroDao;
import model.Aluno;
import model.Livro;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class CadEmprestimo {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadEmprestimo window = new CadEmprestimo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPRESTIMO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(130, 10, 230, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aluno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 76, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<Aluno> cbAluno = new JComboBox<Aluno>();
		cbAluno.setBounds(37, 99, 83, 21);

		List<Aluno> alunos = new AlunoDao().listarTodas();
		for (Aluno aluno : alunos) {
//			cbAluno.addItem(aluno.getNome());
			cbAluno.addItem(aluno);
		}
//		cbCidade.addItem(new CidadeDao().listarTodas());
		
		frame.getContentPane().add(cbAluno);
		
		JLabel lblNewLabel_2 = new JLabel("Livros");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(302, 78, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox cbLivro = new JComboBox<Livro>();
		cbLivro.setFont(new Font("Tahoma", Font.PLAIN, 8));
		cbLivro.setBounds(264, 99, 162, 21);
		
		List<Livro> livros = new LivroDao().listarTodas();
		for (Livro livro : livros) {
//			cbAluno.addItem(aluno.getNome());
			cbLivro.addItem(livro);
		}
		
		frame.getContentPane().add(cbLivro);
		
		textField = new JTextField();
		textField.setBounds(37, 217, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(264, 217, 162, 19);
		frame.getContentPane().add(formattedTextField);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(27, 177, 96, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(315, 186, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		
		

		
	}

}
