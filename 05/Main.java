import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MENU PRINCIPAL === \n" +
                " 1 - Inserir nome \n" +
                " 2 - Alterar nome \n");

        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();

        if (opcao == 1) {
            new Inserir();
        } else if (opcao ==2) {
            new Alterar();
        } else {
            System.out.println("Opção inválida");
        }
        input.close();
    }
}