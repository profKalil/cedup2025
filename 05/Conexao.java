//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//// String[] nome = new String[8];
//
//
//public class Conexao {
//    private static final String ARQUIVO = "nome.txt";
//
//    public void inserir(String nome){
//        boolean encontrado = false;
//
//        try {
//            // Lê o arquivo linha a linha
//            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
//            String linha;
//
//            while ((linha = leitor.readLine()) != null) {
//                if (linha.trim().equals(nome)) {
//                    System.out.println("Nome já existe.");
//                    encontrado = true;
//                    break;
//                }
//            }
//            leitor.close();
//
//            if (!encontrado) {
//                FileWriter escritor = new FileWriter(ARQUIVO, true);
//                escritor.write(nome + "\n");
//                escritor.close();
//                System.out.println("Nome '" + nome + "' incluído com sucesso!");
//            }
//
//        } catch (FileNotFoundException e) {
//
//            try {
//                FileWriter escritor = new FileWriter(ARQUIVO, true);
//                escritor.write(nome + "\n");
//                escritor.close();
//                System.out.println("Arquivo criado e nome '" + nome + "' incluído com sucesso!");
//            } catch (IOException ex) {
//                System.out.println("Erro ao criar o arquivo: " + ex.getMessage());
//            }
//
//        } catch (IOException e) {
//            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
//        }
//    }
//
//    public void alterar(String antigo, String novo) {
//        try {
//            // 1️⃣ Lê todas as linhas do arquivo
//            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
//            List<String> linhas = new ArrayList<>();
//            String linha;
//
//            while ((linha = leitor.readLine()) != null) {
//                linhas.add(linha);
//            }
//            leitor.close();
//
//            // 2️⃣ Procura e substitui
//            boolean alterado = false;
//            for (int i = 0; i < linhas.size(); i++) { // for (int i; i < linha.length; i++)
//                if (linhas.get(i).trim().equals(antigo)) {  // linhas[i].equals(antigo)
//                    linhas.set(i, novo);
//                    alterado = true;
//                    break;
//                }
//            }
//
//            if (alterado) {
//                BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO));
//                for (String l : linhas) {
//                    escritor.write(l + "\n");
//                }
//                escritor.close();
//                System.out.println("Nome '" + antigo + "' alterado para '" + novo + "'.");
//            } else {
//                System.out.println("Nome não encontrado.");
//            }
//
//        } catch (IOException e) {
//            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
//        }
//    }
//}

import java.sql.*;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/nome";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    // Cria a conexão com o banco
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conexão estabelecida com sucesso!");
            return conexao;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver do MySQL não encontrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        return null;
    }

    // Inserir novo nome na tabela
    public void inserir(String nome) {
        String sql = "INSERT INTO nomes (nome) VALUES (?)";
        try (Connection con = conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("✅ Nome '" + nome + "' incluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    // Alterar nome existente
    public void alterar(String antigo, String novo) {
        String sql = "UPDATE nomes SET nome = ? WHERE nome = ?";
        try (Connection con = conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, novo);
            stmt.setString(2, antigo);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("✅ Nome '" + antigo + "' alterado para '" + novo + "'.");
            } else {
                System.out.println("⚠️ Nome não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
        }
    }
}


