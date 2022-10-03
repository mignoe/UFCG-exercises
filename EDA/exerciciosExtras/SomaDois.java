public class SomaDois {
    public static void main(String[] args) {
        int[] exemplo = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(somaDois(exemplo, 10));
    }

    public static String somaDois(int[] nums, int target) {
        int numeroPares = 0;
        String pares = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target && nums[i] != nums[j]) {
                    pares += "[" + nums[i] + ", " + nums[j] + "] ";
                }
            }
        }

        return pares;
    }
}
