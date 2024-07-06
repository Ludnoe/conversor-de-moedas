import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    private static final String[] MOEDAS_MAIS_USADAS = {
            "USD - Dólar Americano",
            "EUR - Euro",
            "JPY - Iene Japonês",
            "GBP - Libra Esterlina",
            "AUD - Dólar Australiano",
            "CAD - Dólar Canadense",
            "CHF - Franco Suíço",
            "CNY - Yuan Chinês",
            "SEK - Coroa Sueca",
            "NZD - Dólar Neozelandês"
    };

    public int exibirMenu() {
        try {
            System.out.println("*******************************************");
            System.out.println("Menu:");
            System.out.println("1. Converter moedas");
            System.out.println("2. Ver histórico de conversões");
            System.out.println("3. Sair");
            System.out.println("*******************************************");

            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro ao ler entrada do usuário. Tente novamente.");
            return -1;
        }
    }

    public void exibirMoedasMaisUsadas() {
        for (int i = 0; i < MOEDAS_MAIS_USADAS.length; i++) {
            System.out.println((i + 1) + ". " + MOEDAS_MAIS_USADAS[i]);
        }
        System.out.println((MOEDAS_MAIS_USADAS.length + 1) + ". Outra (Inserir manualmente)");
    }

    public String lerCodigoMoeda() {
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if (escolha >= 1 && escolha <= MOEDAS_MAIS_USADAS.length) {
            return MOEDAS_MAIS_USADAS[escolha - 1].substring(0, 3);
        } else if (escolha == MOEDAS_MAIS_USADAS.length + 1) {
            System.out.println("Digite o código da moeda:");
            return scanner.next().toUpperCase();
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return lerCodigoMoeda();
        }
    }

    public double lerValorDoUsuario() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Erro ao ler entrada do usuário. Tente novamente.");
            return -1;
        }
    }
}
