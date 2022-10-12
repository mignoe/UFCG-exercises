package selectionsort;

import java.util.Arrays;
import java.util.Scanner;

class SelectionSort {

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
		for (int i = 0; i < nums.length - 1; i++) {
			int indiceMenor = i;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] < nums[indiceMenor]) 
					indiceMenor = j;
			}
			
			if (indiceMenor != i) {
				int aux = nums[i];
				nums[i] = nums[indiceMenor];
				nums[indiceMenor] = aux;
				
				System.out.println(Arrays.toString(nums));
			}
		}
	}

}
