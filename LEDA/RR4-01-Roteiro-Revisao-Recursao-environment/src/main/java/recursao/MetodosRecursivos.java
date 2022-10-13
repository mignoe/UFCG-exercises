package recursao;

public class MetodosRecursivos {

	public static int calcularSomaArray(int[] array){
		
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY

		return calcularSomaArray(array, 0);
	}

	public static int calcularSomaArray(int[] array, int index) {
		if (index == array.length - 1) {
			return array[index];
		}

		return array[index] + calcularSomaArray(array, index + 1);
	}

	public static long calcularFatorial(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		
		if (n == 1) {
			System.out.println(1);
			return 1;
		}
		
		long result = n * calcularFatorial(n - 1);
		System.out.println(result);
		
		
		
		return result;
	}

	public static int calcularFibonacci(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		if (n == 1 || n == 2) {
			System.out.println(1);
			
			return 1;
		}
		
		int result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		
		System.out.println(result);
		
		return result;
	}

	public static int countNotNull(Object[] array, int indice) {
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		
		if (indice == array.length) {
			return 0;
		}
		
		int result = 0;
		
		if (array[indice] != null) {
			result =  1; 
		} 
		
		return result + countNotNull(array, indice + 1);
	}

	public static double potenciaDe2(int expoente) {
		if (expoente == 0) {
			return 1;
		}
		if (expoente > 0) {
			return 2 * potenciaDe2(expoente - 1);
		} else {
			return potenciaDe2(expoente + 1) / 2;
		}
	}

	public static double progressaoAritmetica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
	
		if (n == 1) return termoInicial;
		
		return razao + progressaoAritmetica(termoInicial, razao, n - 1);
	}

	public static double progressaoGeometrica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		
		if (n == 1)
			return termoInicial;
		
		
		return razao * progressaoGeometrica(termoInicial, razao, n - 1);
	}
	
	
}
