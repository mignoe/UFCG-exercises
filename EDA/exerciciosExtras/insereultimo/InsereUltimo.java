package insereultimo;

import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
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
		int ultimo = nums[nums.length - 1];
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (ultimo < nums[i]) {
				for (int k = nums.length - 1; k > i; k--) {
					nums[k] = nums[k - 1];
				}
				
				nums[i] = ultimo;
				break;
			}
		}
		
	}
}
