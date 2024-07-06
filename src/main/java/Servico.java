import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class Servico {

    private static final Map<String, String> SIMBOLOS_MOEDAS = new HashMap<>();

    static {
        SIMBOLOS_MOEDAS.put("USD", "$");
        SIMBOLOS_MOEDAS.put("EUR", "€");
        SIMBOLOS_MOEDAS.put("JPY", "¥");
        SIMBOLOS_MOEDAS.put("GBP", "£");
        SIMBOLOS_MOEDAS.put("AUD", "A$");
        SIMBOLOS_MOEDAS.put("CAD", "C$");
        SIMBOLOS_MOEDAS.put("CHF", "Fr");
        SIMBOLOS_MOEDAS.put("CNY", "¥");
        SIMBOLOS_MOEDAS.put("SEK", "kr");
        SIMBOLOS_MOEDAS.put("NZD", "NZ$");
        // Adicione mais símbolos conforme necessário
    }

    public double getTaxaCambio(String moedaOrigem, String moedaDestino) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/2c322ca965bc4a51eef56225/latest/" + moedaOrigem);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                String jsonResponse = content.toString();

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
                return jsonObject.get("conversion_rates").getAsJsonObject().get(moedaDestino).getAsDouble();
            } else {
                System.out.println("Erro: Código de resposta da API: " + responseCode);
                return -1;
            }
        } catch (IOException e) {
            System.out.println("Erro ao conectar à API: " + e.getMessage());
            return -1;
        }
    }

    public double converter(double valor, double taxaCambio) {
        return valor * taxaCambio;
    }

    public String getSimboloMoeda(String codigoMoeda) {
        return SIMBOLOS_MOEDAS.getOrDefault(codigoMoeda, "");
    }
}
