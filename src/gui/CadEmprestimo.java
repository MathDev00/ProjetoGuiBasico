package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;

import dao.AlunoDao;
import model.Aluno;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;

public class CadEmprestimo {

	private JFrame frame;

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
		
		

		
	}

}
