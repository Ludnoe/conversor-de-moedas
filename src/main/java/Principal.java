import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Interface interfaceObj = new Interface();
        Servico servicoObj = new Servico();

        while (true) {

            int opcao = interfaceObj.exibirMenu();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {

                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "COP";
                    break;
                case 6:
                    moedaOrigem = "COP";
                    moedaDestino = "USD";
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println("Digite o valor a ser convertido:");
            double valor;
            while (true) {
                try {
                    valor = interfaceObj.lerValorDoUsuario();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro ao ler entrada do usuário. Tente novamente.");
                }
            }

            double taxaCambio;
            while (true) {
                try {
                    taxaCambio = servicoObj.getTaxaCambio(moedaOrigem, moedaDestino);
                    break;
                } catch (Exception e) {
                    System.out.println("Erro ao obter taxa de câmbio. Tente novamente.");
                }
            }

            double valorConvertido;
            while (true) {
                try {
                    valorConvertido = servicoObj.converter(valor, taxaCambio);
                    break;
                } catch (Exception e) {
                    System.out.println("Erro ao converter valor. Tente novamente.");
                }
            }

            System.out.println("Valor convertido: " + valorConvertido);

            System.out.println("Deseja continuar? (S/N)");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Saindo...");
                return;
            }
        }
    }
}