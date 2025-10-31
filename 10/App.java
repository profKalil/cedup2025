package org.example;

import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App extends JFrame {
    // Atributos da classe (input, botões, label)
    private JLabel lblNome, lblNovo, lblAntigo;
    private JTextField txtNome, txtNovo, txtAntigo;
    private JButton btnInserir, btnAlterar;
    private Conexao conexao;

    public Main () {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        conexao = context.getBean(Conexao.class); // Spring injeta a instância

        // Constroi a janela
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Incluir nome
        lblNome = new JLabel("Digite o nome: ");
        lblNome.setBounds(30, 30, 100, 25);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 200, 25);
        add(txtNome);

        // Botao inserir
        btnInserir = new JButton("Inserir");
        btnInserir.setBounds(240, 60, 100, 25);
        add(btnInserir);
        // btn...addActionListener(new ActionListener() { public... actionPerformed(ActionEvent e) {..} };
        btnInserir.addActionListener(e -> {
            String nome = txtNome.getText();
            conexao.inserir(nome);
            txtNome.setText(""); // limpa o campo
        });

        // Alterar nome antigo
        lblAntigo = new JLabel("Nome a alterar: ");
        lblAntigo.setBounds(30, 120, 100, 25);
        add(lblAntigo);
        txtAntigo = new JTextField();
        txtAntigo.setBounds(140, 120, 200, 25);
        add(txtAntigo);

        // Alterar nome novo
        lblNovo = new JLabel("Novo nome: ");
        lblNovo.setBounds(30, 150, 100, 25);
        add(lblNovo);
        txtNovo = new JTextField();
        txtNovo.setBounds(140, 150, 200, 25);
        add(txtNovo);

        // Botao alterar
        btnInserir = new JButton("Alterar");
        btnInserir.setBounds(240, 180, 100, 25);
        add(btnInserir);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
