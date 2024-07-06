import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Interface interfaceObj = new Interface();
        Servico servicoObj = new Servico();
        List<String> historico = new ArrayList<>();

        while (true) {

            int opcao = interfaceObj.exibirMenu();

            String moedaOrigem = "";
            String moedaDestino = "";

            switch (opcao) {

                case 1:
                    // Seleção de moeda de origem
                    System.out.println("Selecione o código da moeda de origem ou digite 'outra' para inserir manualmente:");
                    interfaceObj.exibirMoedasMaisUsadas();
                    moedaOrigem = interfaceObj.lerCodigoMoeda();

                    // Seleção de moeda de destino
                    System.out.println("Selecione o código da moeda de destino ou digite 'outra' para inserir manualmente:");
                    interfaceObj.exibirMoedasMaisUsadas();
                    moedaDestino = interfaceObj.lerCodigoMoeda();
                    break;
                case 2:
                    System.out.println("Histórico de conversões:");
                    for (String item : historico) {
                        System.out.println(item);
                    }
                    continue;
                case 3:
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
                    if (valor <= 0) {
                        System.out.println("Valor deve ser positivo. Tente novamente.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro ao ler entrada do usuário. Tente novamente.");
                }
            }

            double taxaCambio;
            while (true) {
                try {
                    taxaCambio = servicoObj.getTaxaCambio(moedaOrigem, moedaDestino);
                    if (taxaCambio <= 0) {
                        System.out.println("Taxa de câmbio inválida. Tente novamente.");
                        continue;
                    }
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

            String simboloOrigem = servicoObj.getSimboloMoeda(moedaOrigem);
            String simboloDestino = servicoObj.getSimboloMoeda(moedaDestino);
            String resultado = String.format("Convertido %s%.2f %s para %s%.2f %s", simboloOrigem, valor, moedaOrigem, simboloDestino, valorConvertido, moedaDestino);
            System.out.println("Valor convertido: " + simboloDestino + String.format("%.2f", valorConvertido));
            historico.add(resultado);

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
