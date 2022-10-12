package insertionsortrecursivo;

class InsertionSortRecursivo {
	public static void main(String[] args) {
		
	}
	
	public static void insertionSortRecursivo(int[] nums) {
		insertionSortRecursivo(2, new int[2]);
	}
	
	public static void insertionSortRecursivo(int indexAtual, int[] nums) {
		
	}
	
	public static boolean empurraParaDireita(int k, int[] nums, int end) {
		return empurraParaDireita(k, nums, end, nums[k]);
	}
	
	
	public static boolean empurraParaDireita(int k, int[] nums, int end, int aux) {
		if (k != end) {
			nums[k] = nums[k - 1];
			return empurraParaDireita(k - 1, nums, end, aux);
		} else {
			nums[end] = aux;
			return true;
		}
	}
	
	public static int encontraIndiceMenor(int indiceTeste, int[] nums, int valor) {
		if (indiceTeste == -1) 
			return -1;
		
		if (!(valor > nums[indiceTeste])) {
			
			return encontraIndiceMenor(indiceTeste - 1, nums, valor);
			
		} else {
			return indiceTeste;
		}
	}
}
