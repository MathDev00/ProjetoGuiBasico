package gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal window = new MenuPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMenu = new JLabel("MENU PRINCIPAL");
        lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMenu.setBounds(140, 10, 160, 22);
        frame.getContentPane().add(lblMenu);

        JButton btnCadEmprestimo = new JButton("Cadastro de Empréstimo");
        btnCadEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadEmprestimo cadEmprestimo = new CadEmprestimo();
                cadEmprestimo.show();
            }
        });
        btnCadEmprestimo.setBounds(120, 60, 200, 30);
        frame.getContentPane().add(btnCadEmprestimo);

        JButton btnLivroGui = new JButton("Cadastro de Livro");
        btnLivroGui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LivroGui livroGui = new LivroGui();
                livroGui.show();
            }
        });
        btnLivroGui.setBounds(120, 110, 200, 30);
        frame.getContentPane().add(btnLivroGui);
    }
}
