import java.util.HashMap;
import java.util.Map;

public class FaturamentoPorEstado {
    public static void main(String[] args) {
        // Inicializa a variável que armazenará o faturamento total
        double faturamentoTotal = 0;
        // Cria um map para armazenar o faturamento por estado
        Map<String, Double> faturamentoPorEstado = new HashMap<>();

        // Adiciona os valores de faturamento por estado ao mapa
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        // Calcula o faturamento total
        for (double valor : faturamentoPorEstado.values()) {
            faturamentoTotal += valor;
        }

        // Calcula e imprime o percentual de faturamento por estado
        for (String estado : faturamentoPorEstado.keySet()) {
            double percentual = faturamentoPorEstado.get(estado) / faturamentoTotal * 100;
            System.out.println(estado + ": " + String.format("%.2f", percentual) + "%");
        }
    }
}