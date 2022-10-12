package elementosobrando;
import java.util.Scanner;

class ElementoSobrando {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        String[] linha = sc.nextLine().split(" ");
        int[] nums = new int[linha.length];
        for (int i = 0; i < linha.length; i++) {
            nums[i] = Integer.parseInt(linha[i]);
        }
        
        String[] linha2 = sc.nextLine().split(" ");
        int[] nums2 = new int[linha2.length];
        for (int i = 0; i < linha2.length; i++) {
            nums2[i] = Integer.parseInt(linha2[i]);
        }
        
        System.out.println(elementoSobrando(nums, nums2));
	}
	
	public static int elementoSobrando(int[] nums, int[] nums2) {
		int sum1 = 0;
		for (int num : nums) {
			sum1 += num;
		}
		
		int sum2 = 0;
		for (int num : nums2) {
			sum2 += num;
		}
		
		return sum2 - sum1;
	}
}
