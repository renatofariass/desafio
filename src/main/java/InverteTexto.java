import java.util.Scanner;

public class InverteTexto {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        // Pede ao usuário para digitar uma string
        System.out.print("Digite uma string: ");
        // Lê a string digitada pelo usuário
        String str = scanner.nextLine();
        // Fecha o objeto Scanner
        scanner.close();

        // Converte a string em um array de caracteres
        char[] caracteres = str.toCharArray();

        // Inverte os caracteres da string
        for (int i = 0; i < caracteres.length / 2; i++) {
            // Armazena temporariamente o caractere atual
            char temporario = caracteres[i];
            // Troca o caractere atual pelo caractere correspondente do outro lado da string
            caracteres[i] = caracteres[caracteres.length - i - 1];
            // Coloca o caractere temporário no lugar do caractere correspondente do outro lado da string
            caracteres[caracteres.length - i - 1] = temporario;
        }

        // Cria uma nova string com os caracteres invertidos
        String strInvertida = new String(caracteres);
        // Imprime a string invertida
        System.out.println("Texto invertido: " + strInvertida);
    }
}