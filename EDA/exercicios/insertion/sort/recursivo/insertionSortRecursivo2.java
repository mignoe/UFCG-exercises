package insertion.sort.recursivo;

class insertionSortRecursivo2 {
	
	
	public static void insertionSortRecursivo(int[] nums, int currentIndex) {
		if (nums[currentIndex] < nums[currentIndex - 1]) {
			int aux = nums[currentIndex - 1];
			nums[currentIndex - 1] = nums[currentIndex];
			nums[currentIndex] = aux;
		}
	}
	
}
