package quicksort;

import java.util.Arrays;
import java.util.Scanner;

class QuickSortLomuto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		
		int[] nums = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			nums[i] = Integer.parseInt(linha[i]);
		}
		
		particiona(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void swap(int[] nums, int i, int j) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void particiona(int[] nums) {
		int pivot = nums[nums.length - 1];
		
		int i = nums.length - 1;
		for (int j = i - 1; j >= 0; j--) {
			if (nums[j] >= pivot) {
				i--;
				swap(nums, i, j);
			}
		}
		
		swap(nums, i, nums.length - 1);
	}
}
