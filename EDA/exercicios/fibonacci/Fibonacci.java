package fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
	}
	
	public static int fibonacci(int n) {
		if (n == 1) 
			return 1;
		if (n == 2)
			return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
}

// (p -> (¬r or ¬s)) and ((p or ¬q) and (q or ¬p)) and (r and s) -> (¬(p or q))

// (a or b) and (¬a or c) and (b -> c) -> c

// (¬p or q) and (q -> ¬r and ¬p) and (p or r)

// (¬p -> q) and (p and q and r and ¬s) and (p and q or r and s) and (((p -> q) -> p) -> p)