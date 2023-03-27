import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        // Criação de um objeto da classe JSONParser para fazer a análise do arquivo JSON
        JSONParser parser = new JSONParser();
        // Criação de uma lista de valores de faturamento diário (ArrayList) e uma variável para armazenar a soma total
        List<Double> faturamento = new ArrayList<>();
        // variável para armazenar a soma do faturamento
        double somaFaturamento = 0;
        // Variável para armazenar o número de dias no mês
        int diasNoMes = 0;

        try {
            // Leitura do arquivo JSON com os dados de faturamento diário
            Object obj = parser.parse(new FileReader("src/main/java/faturamento.json"));
            JSONArray faturamentoJsonArray = (JSONArray) obj;

            // for para armazenar o valor de faturamento diário em um ArrayList e calcular a soma total
            for (Object o : faturamentoJsonArray) {
                JSONObject faturamentoJsonObject = (JSONObject) o;
                Double valor = Double.parseDouble(faturamentoJsonObject.get("valor").toString());
                String data = faturamentoJsonObject.get("data").toString();
                // Se o valor de faturamento for maior que zero, adiciona à lista e atualiza a soma e o número de dias
                if (valor > 0) {
                    faturamento.add(valor);
                    somaFaturamento += valor;
                    diasNoMes++;
                }
            }

            // Calcula o menor e o maior valor de faturamento diário
            double menorFaturamento = faturamento.get(0);
            double maiorFaturamento = faturamento.get(0);
            for (int i = 1; i < faturamento.size(); i++) {
                double valor = faturamento.get(i);
                if (valor < menorFaturamento) {
                    menorFaturamento = valor;
                }
                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }
            }

            // Calcula a média mensal de faturamento diário
            double mediaFaturamento = somaFaturamento / diasNoMes;

            // Calcula o número de dias no mês em que o faturamento diário foi superior à média mensal
            int diasAcimaDaMedia = 0;
            for (double valor : faturamento) {
                if (valor > mediaFaturamento) {
                    diasAcimaDaMedia++;
                }
            }

            // Imprime os resultados
            System.out.println("Menor valor de faturamento diário: " + menorFaturamento);
            System.out.println("Maior valor de faturamento diário: " + maiorFaturamento);
            System.out.println("Número de dias no mês com faturamento diário acima da média: " + diasAcimaDaMedia);

        } catch (org.json.simple.parser.ParseException e) {
            // Exceção lançada se houver algum erro na análise do arquivo JSON
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Exceção lançada se houver algum erro na leitura do arquivo JSON
            e.printStackTrace();
        }
    }
}


