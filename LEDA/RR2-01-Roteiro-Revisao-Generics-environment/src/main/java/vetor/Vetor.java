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
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	public T maximo() {
		if (this.isVazio()) return null;
		
		T biggest = this.arrayInterno[0];
		for (T object : arrayInterno) {
			if(object.compareTo(biggest) > 0) {
				biggest = object;
			}
		}

		return biggest;
	}

	public T minimo() {
		if (this.isVazio()) return null;
		
		T smallest = this.arrayInterno[0];
		for (T object : arrayInterno) {
			if(object.compareTo(smallest) < 0) {
				smallest = object;
			}
		}

		return smallest;
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

}
