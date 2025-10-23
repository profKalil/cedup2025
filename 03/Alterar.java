import java.io.*;
import java.util.*;

public class Alterar {
    private static final String ARQUIVO = "nome.txt";

    public Alterar() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome a alterar: ");
        String antigo = input.nextLine();

        System.out.print("Digite o novo nome: ");
        String novo = input.nextLine();

        input.close();

        try {
            // 1️⃣ Lê todas as linhas do arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO));
            List<String> linhas = new ArrayList<>();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
            leitor.close();

            // 2️⃣ Procura e substitui
            boolean alterado = false;
            for (int i = 0; i < linhas.size(); i++) {
                if (linhas.get(i).trim().equals(antigo)) {
                    linhas.set(i, novo);
                    alterado = true;
                    break;
                }
            }

            // 3️⃣ Regrava o arquivo
            if (alterado) {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO));
                for (String l : linhas) {
                    escritor.write(l + "\n");
                }
                escritor.close();
                System.out.println("Nome '" + antigo + "' alterado para '" + novo + "'.");
            } else {
                System.out.println("Nome não encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        }
    }
}
