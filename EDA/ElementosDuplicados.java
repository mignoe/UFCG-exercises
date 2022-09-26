import java.util.*;

class ElementosDuplicados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");

        boolean resultado = false;

        for (String num : line) {
            int ammount = 0;
            for (String num2 : line) {
                if (num2.equals(num)) {
                    ammount += 1;
                }
            }

            if (ammount == 2) {
                resultado = true;
            }
        } 

        System.out.println(resultado);
    }
}
