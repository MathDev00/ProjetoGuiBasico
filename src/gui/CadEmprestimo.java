package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.AlunoDao;
import dao.LivroDao;
import model.Aluno;
import model.Livro;
import controller.EmprestimoController;

public class CadEmprestimo {

    private JFrame frame;
    private JTextField textField;
    private JFormattedTextField formattedTextField;

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
    void initialize() {
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
            cbAluno.addItem(aluno);
        }

        frame.getContentPane().add(cbAluno);

        JLabel lblNewLabel_2 = new JLabel("Livros");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(302, 78, 45, 13);
        frame.getContentPane().add(lblNewLabel_2);

        JComboBox<Livro> cbLivro = new JComboBox<Livro>();
        cbLivro.setFont(new Font("Tahoma", Font.PLAIN, 8));
        cbLivro.setBounds(264, 99, 162, 21);

        List<Livro> livros = new LivroDao().listarTodas();
        for (Livro livro : livros) {
            cbLivro.addItem(livro);
        }

        frame.getContentPane().add(cbLivro);

        textField = new JTextField();
        textField.setBounds(27, 188, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        formattedTextField = new JFormattedTextField();
        formattedTextField.setBounds(264, 188, 162, 19);
        frame.getContentPane().add(formattedTextField);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            formattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(dateFormatter));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_3 = new JLabel("Quantidade");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(27, 148, 96, 30);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Data");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(302, 157, 45, 13);
        frame.getContentPane().add(lblNewLabel_4);

        JButton btnNewButton = new JButton("SALVAR");
        btnNewButton.setBounds(154, 232, 85, 21);
        frame.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Livro livro = (Livro) cbLivro.getSelectedItem();
                Aluno aluno = (Aluno) cbAluno.getSelectedItem();

                String quantidadeText = textField.getText();
                String dataText = formattedTextField.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataEmprestimo = null;

                try {
                    dataEmprestimo = new Date(sdf.parse(dataText).getTime());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                // Chamar o método "salvar" do controlador passando os parâmetros existentes e a data convertida
                new EmprestimoController().salvar(aluno, livro, Integer.parseInt(quantidadeText), dataEmprestimo);
                textField.setText(null);
                formattedTextField.setText(null);
            }
        });
    }
    
    public void show() {
        frame.setVisible(true);
    }

	
}
