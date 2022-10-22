package quicksort;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		
		int[] nums = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			nums[i] = Integer.parseInt(linha[i]);
		}
		
		quickSort(nums);
		
	}
	
	public static void swap(int i, int j, int[] nums) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
	}
	
	public static int particiona(int[] nums, int left, int right) {
		int pivot = nums[left];

		
		int i = left;
		for (int j = i + 1; j <= right; j++) {
			if (nums[j] <= pivot) {
				i++;
				swap(i, j, nums);
			}
		}
		
		swap(left, i, nums);		
		
		
		
		return i;
	}
	
	public static void quickSort(int[] nums, int left, int right) {
		if (left < right) {
			int pontoParticao = particiona(nums, left, right);
			
			int len = Arrays.toString(nums).length();
			System.out.println(Arrays.toString(nums).substring(1, len - 1).replaceAll(", "," "));
			
			quickSort(nums, left, pontoParticao - 1);
			quickSort(nums, pontoParticao + 1, right);
		}
	}
	
	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
}
