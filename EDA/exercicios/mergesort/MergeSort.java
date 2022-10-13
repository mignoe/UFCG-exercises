package mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String[] linha = sc.nextLine().split(" ");
	     int[] nums = new int[linha.length];
	     for (int i = 0; i < linha.length; i++) {
	    	 nums[i] = Integer.parseInt(linha[i]);
	     }
	     
	     mergeSort(nums, 0, nums.length - 1);
	     
	     System.out.println(Arrays.toString(nums));
	}
	
	public static void mergeSort(int[] nums, int ini, int fim) {
		System.out.println();
		if ( ini < fim) {
			int meio = (ini + fim) / 2;
			mergeSort(nums, ini, meio);
			mergeSort(nums, meio + 1, fim);
			merge(nums, ini, fim);
		}
	}
	
	public static void merge(int[] nums, int ini, int fim) {
		int[] helper = new int[nums.length];
		for (int i = 0; i < nums.length; i++) 
			helper[i] = nums[i];
		
		int i = ini;
		int meio = (ini + fim) / 2;
		int j = meio + 1;
		int k = ini;
		while (i <= meio && j <= fim) {
			if (helper[i] <= helper[j]) {
				nums[k++] = helper[i++];
			} else {
				nums[k++] = helper[j++];
			}
		}
		
		while (i <= meio) nums[k++] = helper[i++];
		while (j <= fim) nums[k++] = helper[j++];
	}
}
