package insereprimeiro;

import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
	public static void main(String[] args) {
	
		 Scanner sc = new Scanner(System.in);
	     String[] linha = sc.nextLine().split(" ");
	     int[] nums = new int[linha.length];
	     for (int i = 0; i < linha.length; i++) {
	    	 nums[i] = Integer.parseInt(linha[i]);
	     }
	     
	     inserePrimeiro(nums);
	     
	     System.out.println(Arrays.toString(nums));
	}
	
	
	
	public static void inserePrimeiro(int[] nums) {
		int primeiro = nums[0];
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || primeiro < nums[i]) {
				for (int k = 0; k < i - 1; k++) {
					nums[k] = nums[k + 1];
				}
				
				nums[i - 1] = primeiro;
				break;
			}
		}
	}
}
