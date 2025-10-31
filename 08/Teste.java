// Aula prática. Projeto APP gerenciador-de-nomes-janela. Quinta-feira, 30/10

import javax.swing.*;

public class Teste extends JFrame {

    private JButton btnInserir, btnAlterar;
    private JTextField txtNome, txtAntigo, txtNovo;
    private JLabel lblNome, lblAntigo, lblNovo;
    private Conexao conexao;

    public Teste() {

        // JANELA PRINCIPAL
        setTitle("=== GERENCIADOR DE NOMES ===");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);


        // ÁREA PARA INSERIR O NOME
        lblNome = new JLabel("Digite o nome : ");
        lblNome.setBounds(10, 15, 100, 30);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(105, 15, 130, 30);
        add(txtNome);
        btnInserir = new JButton("INSERIR");
        btnInserir.setBounds(245, 15, 80, 30);
        btnInserir.addActionListener(e -> {
            String nome = txtNome.getText();
            conexao = new Conexao();
            conexao.inserir(nome);
            txtNome.setText("");
        });
        add(btnInserir);

        // ÁREA PARA ALTERAR O NOME



        setVisible(true);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
