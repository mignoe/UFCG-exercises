package insertion.sort;

import java.util.Arrays;

public class InsertionSortCagado {
	public static void main(String[] args) {
		int[] example = {5, 4, 3, 2, 1, 10, 9};
		// 5 6 3 2 1 10 9
	    //   
		// 1 2 3 4 5 11 12 13 10 
		// 
		//
		
		insertionSort(example);
		
		System.out.println(Arrays.toString(example));
	}
	
	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= -1; j--) {
				if (j == -1 || nums[i] > nums[j])  {
					int aux = nums[i];
					
					for (int k = i; k > j + 1; k--) {
						nums[k] = nums[k - 1];
					}
					
					nums[j + 1] = aux;
					break;
				}	
			}
		}
	}
}
