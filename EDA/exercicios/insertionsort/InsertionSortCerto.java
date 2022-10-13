package insertionsort;

public class InsertionSortCerto {
	
	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j] < nums[j - 1]) {
					int aux = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = aux;
				} else {
					break;
				}
			}
		}
	}
}
