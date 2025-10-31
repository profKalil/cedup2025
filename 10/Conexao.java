package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Conexao {
    private static final String ARQUIVO = "nome.txt";

    public void inserir(String nome){
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

            if (!encontrado) {
                FileWriter escritor = new FileWriter(ARQUIVO, true);
                escritor.write(nome + "\n");
                escritor.close();
                System.out.println("Nome '" + nome + "' incluído com sucesso!");
            }

        } catch (FileNotFoundException e) {

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

    public void alterar(String antigo, String novo) {
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
            for (int i = 0; i < linhas.size(); i++) { // for (int i; i < linha.length; i++)
                if (linhas.get(i).trim().equals(antigo)) {  // linhas[i].equals(antigo)
                    linhas.set(i, novo);
                    alterado = true;
                    break;
                }
            }

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
