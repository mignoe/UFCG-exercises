package BinaryHeap;

import java.util.Scanner;

class Heap2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] line = sc.nextLine().split(" ");
		int[] inteiros = new int[line.length];
		
		int index = 0;
		for (String num : line) {
			inteiros[index++] = Integer.parseInt(num);
		}
		
		
		System.out.println(isHeap(inteiros, 0));
		
	}
	
	private static boolean isHeap(int[] array, int pos) {
		boolean isHeap = true;
		int n = array.length - 1;
		
		if (pos <= n) {
			int left = 2 * pos + 1;
			int right = 2 * (pos + 1);




			if (left <= n ) {
				if (array[pos] < array[left]) {
					isHeap = false;
				}
				
				isHeap = isHeap && isHeap(array, left);
			}
			
			if (right <= n ) {
				if (array[pos] < array[right]) {
					isHeap = false;
				}
				
				isHeap = isHeap && isHeap(array, right);
			}

		}
		return isHeap;
	}

}
