package troca.vizinhos;
import java.util.*;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");
        int[] nums = new int[linha.length];
        for (int i = 0; i < linha.length; i++) {
            nums[i] = Integer.parseInt(linha[i]);
        }
        
        trocaVizinhos(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void trocaVizinhos(int[] nums){
        for (int i = 0; i < nums.length; i += 2){
            if(!((i + 1) > nums.length - 1)){ 
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
} 

// método analítico:
    // c1
    // c2 * ( (n + 1) /2)
    // c3 * n/2
    // C4 * n/2 

    // c1 + c2 * (n/2 + 1)  + c3 * n/2 + C4 * n/2 

    // n

// O(n)