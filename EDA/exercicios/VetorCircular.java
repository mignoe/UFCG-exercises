import java.util.Scanner;

public class VetorCircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");

        int[] nums = new int[linha.length];
        for (int i = 0; i < linha.length; i++) {
            nums[i] = Integer.parseInt(linha[i]);
        }

        int numero = Integer.parseInt(sc.nextLine());

        System.out.println(vetorCircular(nums, numero));
    }

    public static String vetorCircular(int[] vetor, int num){
        String resultado = "";
        for (int i = 0; i < num; i++) {
            resultado += vetor[i % vetor.length] + " ";
        }

        return resultado.trim();
    }
}

// Método analítico:
    // c1
    // c2 + c3 * (n + 1) + c4 * n
    // 

// O(n). n = quantidade de elementos (segundo parâmetro);
