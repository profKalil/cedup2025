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
