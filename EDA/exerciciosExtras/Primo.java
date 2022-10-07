import java.util.Scanner;

public class Primo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        int numero = Integer.parseInt(entrada);

        System.out.println(ehPrimo(numero));
    }

    public static boolean ehPrimo(int num) {
        if (num == 0) {
            return false;
        }

        boolean primo = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
            }
        }

        return primo;
    }
}

// O(n)