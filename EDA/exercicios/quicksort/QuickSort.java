package quicksort;

import java.util.Arrays;
import java.util.Iterator;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = {10, 2, 5, 6, 3, 1, -50, -60, 23, 23, 90, 2000, -2000};
		
		quickSort(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void swap(int i, int j, int[] nums) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
	}
	
	public static int particiona(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		int[] numerosMediana = {nums[left], nums[mid], nums[right]};
		
		Arrays.sort(numerosMediana);
		int pivot = numerosMediana[1];
		
		int indexPivot = left;
		if (pivot == nums[mid])
			indexPivot = mid;
		if (pivot == nums[right])
			indexPivot = right;
		
		swap(left, indexPivot, nums);
		
		int i = left + 1;
		for (int j = i; j < nums.length; j++) {
			if (nums[j] < pivot)
				swap(i++, j, nums);
		}

		swap(left, i - 1, nums);		
		
		return i - 1;
	}
	
	public static void quickSort(int[] nums, int left, int right) {
		if (left < right) {
			int pontoParticao = particiona(nums, left, right);
			quickSort(nums, left, pontoParticao - 1);
			quickSort(nums, pontoParticao + 1, right);
		}
	}
	
	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
}
