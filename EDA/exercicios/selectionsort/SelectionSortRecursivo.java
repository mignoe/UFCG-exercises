package selectionsort;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String[] linha = sc.nextLine().split(" ");
	     
	     int[] nums = new int[linha.length];
	     for (int i = 0; i < linha.length; i++) {
	    	 nums[i] = Integer.parseInt(linha[i]);
	     }
	     
	     selectionSort(nums);
	     
	     
	}
	public static void selectionSort(int[] nums) {
		selectionSort(nums, 0, 0, 0);
	}
	
	public static void selectionSort(int[] nums, int i, int j, int indiceMenor) {
		if (nums[j] < nums[indiceMenor]) indiceMenor = j;
		
		if (i == nums.length - 1) {		}
		
		else if (j == nums.length - 1) {
			int aux = nums[i];
			nums[i] = nums[indiceMenor];
			nums[indiceMenor] = aux;
			
			System.out.println(Arrays.toString(nums));
			
			selectionSort(nums, i + 1, i + 1, i + 1);
		}
		
		else { selectionSort(nums, i, j + 1, indiceMenor); }
	}
}
