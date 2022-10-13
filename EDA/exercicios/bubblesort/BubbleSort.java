package bubblesort;

import java.util.Arrays;
import java.util.Scanner;

class BubbleSort {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		
		int[] nums = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			nums[i] = Integer.parseInt(linha[i]);
		}
		
		bubbleSort(nums);
		
		
	}
	
	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			boolean trocou = false;
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int aux = nums[j];
					
					nums[j] = nums[j + 1];
					nums[j + 1] = aux;
					
					trocou = true;
				}
			}
			
			if (trocou) {
				System.out.println(formataSaida(nums));
			}
		}
	}
	
	public static String formataSaida(int[] nums) {
		String saida = "";
		for (int num : nums) {
			saida += num + " "; 
		}
		
		return saida.trim();
	}
}
