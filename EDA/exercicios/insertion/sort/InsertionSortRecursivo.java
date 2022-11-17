package insertion.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String[] linha = sc.nextLine().split(" ");
	     
	     int[] nums = new int[linha.length];
	     for (int i = 0; i < linha.length; i++) {
	    	 nums[i] = Integer.parseInt(linha[i]);
	     }
	     
	     insertionSort(nums);	
	}
	
	public static void insertionSort(int[] nums) {
		controlaIndice(1, nums);
	}
	
	public static void controlaIndice(int i, int[] nums) {
		if (i < nums.length) { 
			insertionSort(i, nums);
			System.out.println(Arrays.toString(nums));
			controlaIndice(i + 1, nums);
		} else {
			
		}
	}
	
	public static void insertionSort(int i, int[] nums) {
		if (i == 0) { }
		else if (nums[i] < nums[i - 1]) {
			int aux = nums[i];
			nums[i] = nums[i - 1];
			nums[i - 1] = aux;
			
			insertionSort(i - 1, nums);
		}	
	}
}
