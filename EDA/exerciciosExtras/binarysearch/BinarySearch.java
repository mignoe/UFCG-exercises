package binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 6, 199, 230};
		
		binarySearch(nums, 0);
	}
	
	public static int binarySearch(int[] v, int k) {
		if (v.length == 0) return -1;
		
		return binarySearch(v, k, 0, v.length - 1);
	}
	
	public static int binarySearch(int[] v, int k, int start, int end) {
		int mid = (start + end) / 2;
		System.out.println(mid);
		
		if (v[mid] == k) return mid;
		
		if (start >= end) return -1;
		
		if (k < v[mid]) { 
			return binarySearch(v, k, start, mid - 1); 
		}
		else { return binarySearch(v, k, mid + 1, end); }
	}
}
