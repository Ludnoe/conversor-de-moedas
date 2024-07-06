import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    public int exibirMenu() {
        try {
            System.out.println("*******************************************");
            System.out.println("Menu:");
            System.out.println("1. Dólar (USD) para Peso argentino (ARS)");
            System.out.println("2. Peso argentino (ARS) para Dólar (USD)");
            System.out.println("3. Dólar (USD) para Real brasileiro (BRL)");
            System.out.println("4. Real brasileiro (BRL) para Dólar (USD)");
            System.out.println("5. Dólar (USD) para Peso colombiano (COP)");
            System.out.println("6. Peso colombiano (COP) para Dólar (USD)");
            System.out.println("7. Sair");
            System.out.println("*******************************************");

            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro ao ler entrada do usuário. Tente novamente.");
            return -1;
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