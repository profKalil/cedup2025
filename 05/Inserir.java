
import java.util.Scanner;

public class Inserir {

    public Inserir() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome a incluir: ");
        String nome = input.nextLine();
        input.close();
        new Conexao().inserir(nome);
    }
}
