// Projeto "projeto153", quinta-feira

import java.util.Scanner;
import java.sql.*;

public class Main {

    private Scanner input;

    public Main() {

        input = new Scanner(System.in);

        System.out.println("\n== MENU PRINCIPAL ==\n\n" +
                "1 - Inserir\n" +
                "2 - Alterar");

        int opcao = input.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o nome : ");
            String nome = input.nextLine();
            DriverManager.getConnection(URL, USUARIO, SENHA);
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
