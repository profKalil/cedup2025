import java.io.*;
import java.util.Scanner;

public class Inserir {
    private static final String ARQUIVO = "nome.txt";

    public Inserir() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome a incluir: ");
        String nome = input.nextLine();
        input.close();

        boolean encontrado = false;

        try {
            // Lê o arquivo linha a linha
            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().equals(nome)) {
                    System.out.println("Nome já existe.");
                    encontrado = true;
                    break;
                }
            }
            leitor.close();

            // Se não encontrou, escreve o novo nome
            if (!encontrado) {
                FileWriter escritor = new FileWriter(ARQUIVO, true);
                escritor.write(nome + "\n");
                escritor.close();
                System.out.println("Nome '" + nome + "' incluído com sucesso!");
            }

        } catch (FileNotFoundException e) {
            // Se o arquivo não existir, cria um novo e adiciona o nome
            try {
                FileWriter escritor = new FileWriter(ARQUIVO, true);
                escritor.write(nome + "\n");
                escritor.close();
                System.out.println("Arquivo criado e nome '" + nome + "' incluído com sucesso!");
            } catch (IOException ex) {
                System.out.println("Erro ao criar o arquivo: " + ex.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
