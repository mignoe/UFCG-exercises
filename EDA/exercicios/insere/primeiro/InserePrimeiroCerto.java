package insere.primeiro;

import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiroCerto {
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
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				int aux = nums[i];
				
				nums[i] = nums[i + 1];
				nums[i + 1] = aux;
			} else {
				break;
			}
		}
	}
}
