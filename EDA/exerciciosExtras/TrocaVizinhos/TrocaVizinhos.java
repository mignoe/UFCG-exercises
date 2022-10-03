package TrocaVizinhos;
import java.util.*;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        trocaVizinhos(example);

        System.out.println(Arrays.toString(example));
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

// c1
// c2 * ( (n + 1) /2)
// c3 * n/2
// C4 * n/2 

// c1 + c2 * (n/2 + 1)  + c3 * n/2 + C4 * n/2 

// n

// O-(n)