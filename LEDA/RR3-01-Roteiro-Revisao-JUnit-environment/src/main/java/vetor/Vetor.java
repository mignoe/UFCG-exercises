package vetor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 *
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[indice + 1] = o;
		indice++;
	}

	// Remove um objeto do vetor
	public void remover(T o) {
		for (int i = 0; i <= indice; i++) {
			if (arrayInterno[i].equals(o)) {
				for (int j = i; j < indice; j++) {
					arrayInterno[j] = arrayInterno[j + 1];
				}

				arrayInterno[indice] = null;
				break;
			}
		}

		indice--;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		for (int i = 0; i <= indice; i++) {
			if (arrayInterno[i].equals(o)){
				return arrayInterno[i];
			}
		}

		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice == tamanho - 1;
	}

	public T maximo() {
		T maior = this.arrayInterno[0];
		for (int i = 0; i <= indice; i++) {
			if (this.comparadorMaximo.compare(maior, arrayInterno[i]) < 0) {
				maior = arrayInterno[i];
			}
		}

		return maior;
	}

	public T minimo() {
		T menor = this.arrayInterno[0];
		for (int i = 0; i <= indice; i++) {
			if (this.comparadorMinimo.compare(menor, arrayInterno[i]) < 0) {
				menor = arrayInterno[i];
			}
		}

		return menor;
	}
}

class ComparatorMaximo implements Comparator<Aluno> {
	public int compare(Aluno a1, Aluno a2) {
		return (int)  (a1.getMedia() - a2.getMedia());
	}
}

class ComparatorMinimo implements  Comparator<Aluno> {
	public int compare(Aluno a1, Aluno a2) {
		return (int)  (a2.getMedia() - a1.getMedia());
	}
}