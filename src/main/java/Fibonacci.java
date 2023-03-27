import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicita ao usuário um número da sequência de Fibonacci
        System.out.print("Digite um número da sequência de Fibonacci: ");
        int num = scanner.nextInt();
        // Fecha o objeto Scanner
        scanner.close();
        // Inicializa os primeiros valores da sequência de Fibonacci
        int a = 0;
        int b = 1;

        // Variável para indicar se o número informado pertence à sequência de Fibonacci
        boolean pertence = false;

        // Exibe os valores da sequência de Fibonacci até o número máximo
        System.out.println("Sequência de Fibonacci até " + num + ":");

        // Imprime os primeiros dois valores da sequência
        System.out.print(a + " " + b + " ");

        // Itera até chegar ao número máximo da sequência de Fibonacci
        while (b < num) {
            // Calcula e imprime o próximo valor da sequência de Fibonacci
            int proximoValor = a + b;

            System.out.print(proximoValor + " ");

            // Atualiza os valores da sequência de Fibonacci
            a = b;
            b = proximoValor;

            // Se o próximo valor da sequência de Fibonacci for igual ao número informado pelo usuário,
            // define a variável pertence como verdadeira
            if (proximoValor == num) {
                pertence = true;
                break;
            }
        }

        // Exibe uma mensagem indicando se o número informado pertence à sequência de Fibonacci
        if (pertence) {
            System.out.println("\n\n" + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("\n\n" +num + " não pertence à sequência de Fibonacci.");
        }
    }
}
