class Palindromo {
    public static void main(String[] args) {
        char[] exemplo = {'a', 'n', 'a'};
        char[] exemplo2 = {'c', 'a', 's', 'a'};
        
        System.out.println(palindromo(exemplo)); // true
        System.out.println(palindromo(exemplo2)); // false
    }

    public static boolean palindromo(char[] palavra){
        boolean palindromo = true;
        for (int i = 0; i < palavra.length / 2; i ++) {
            if (palavra[i] != palavra[palavra.length - 1 - i]) {
                palindromo = false;
            }
        }

        return palindromo;
    }
}

// c1
// c2
// c3 * (n + 1) / 2 
// c4 * n / 2
// c5 * n / 2
// c6

// c1 + c2 + c3 * (n + 1) / 2 + c4 * n / 2 + c5 * n / 2 + c6

// n

// O(n)