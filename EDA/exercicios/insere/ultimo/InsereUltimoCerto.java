package insere.ultimo;

import java.util.Arrays;
import java.util.Scanner;

class InsereUltimoCerto {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String[] linha = sc.nextLine().split(" ");
	     
	     int[] nums = new int[linha.length];
	     for (int i = 0; i < linha.length; i++) {
	    	 nums[i] = Integer.parseInt(linha[i]);
	     }
	     
	     insereUltimo(nums);
	     
	     System.out.println(Arrays.toString(nums));
		
	}
	
	public static void insereUltimo(int[] nums) {
		for (int j = nums.length - 1; j > 0; j--) {
			if (nums[j] < nums[j - 1]) {
				int aux = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = aux;
			} else {
				break;
			}
		}
	}
}
