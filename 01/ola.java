import java.io.*;
import java.util.Scanner;

public class Ola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Seu nome: ");
        String nome = sc.nextLine();
        sc.close();

        boolean encontrado = false;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader("nome.txt"));
            String linha;

            while (true) {
                linha = leitor.readLine();  // lê uma linha
                if (linha == null) {        // chegou ao fim do arquivo
                    break;
                }

                if (linha.trim().equals(nome)) {
                    System.out.println("Bem-vindo de volta " + nome);
                    encontrado = true;
                    break;
                }
            }

            leitor.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Se o nome não foi encontrado, escreve no arquivo
        if (!encontrado) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter("nome.txt", true));
                escritor.write(nome);
                escritor.newLine();
                escritor.close();
                System.out.println("Olá, " + nome);
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }
    }
}
