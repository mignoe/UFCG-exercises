public class Palindromo {
    public static void main(String[] args) {
        String exemplo = "casa";

        System.out.println(palindromo(exemplo));
    }

    public static boolean palindromo(String str){
        boolean palindromo = true;
        for (int i = 0; i < str.length() / 2; i ++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
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