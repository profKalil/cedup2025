import java.util.*;

public class Alterar {

    public Alterar() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome a alterar: ");
        String antigo = input.nextLine();

        System.out.print("Digite o novo nome: ");
        String novo = input.nextLine();

        input.close();
        new Conexao().alterar(antigo, novo);

    }
}
