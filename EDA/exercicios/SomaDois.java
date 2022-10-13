import java.util.*;

class SomaDois {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");
        int target = Integer.parseInt(sc.nextLine());

        int[] nums = new int[linha.length];
        for (int i = 0; i < linha.length; i++) {
            nums[i] = Integer.parseInt(linha[i]);
        }

        System.out.println(somaDois(nums, target));
    }

    public static String somaDois(int[] nums, int target) {
        int numeroPares = 0;
        String par = "-1";
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target && nums[i] != nums[j]) {
                    par = nums[i] + " " + nums[j];
                    break;
                }
            }
        }

        return par;
    }

}

// O(n)