import java.util.Scanner;

public class TemRepetido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");
        
        int[] nums = new int[linha.length];
        for (int i = 0; i < linha.length; i++) {
            nums[i] = Integer.parseInt(linha[i]);
        }

        System.out.println(temRepetido(nums));
    }

    public static boolean temRepetido(int[] nums) {
        boolean temRepetido = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    temRepetido = true;
                }
            }
        }

        return temRepetido;
    }
}

// O(n²)