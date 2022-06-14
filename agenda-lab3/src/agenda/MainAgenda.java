package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(R)Remover Contato\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		// **Modificado next para nextLine!!
		return scanner.nextLine().toUpperCase();

	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			exibirFavoritos(agenda);
			break;
		case "A":
			adicionarFavorito(agenda, scanner);
			break;
		case "T":
			adicionarTag(agenda, scanner);
			break;
		case "R":
			removerContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}
	
	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nPosição na agenda> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.print("Nome> ");
		String nome = scanner.nextLine();
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine();

		boolean operacaoValida = true;
		String mensagemErros = "";
		if (posicao < 1 || posicao > 100) {
			operacaoValida = false;
			mensagemErros += "POSIÇÃO INVÁLIDA\n";
		}
		if (nome.equals("") || telefone.equals("")) {
			operacaoValida = false;
			mensagemErros += "CONTATO INVALIDO\n";
		}
		if (agenda.contatoJaCadastrado(nome, sobrenome)) {
			operacaoValida = false;
			mensagemErros += "CONTATO JA CADASTRADO\n";
		}
	
		if (operacaoValida) {
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.print("CADASTRO REALIZADO\n");
		} else {
			System.out.print(mensagemErros);
		}
	}
	
	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		String contato = agenda.getContato(posicao);
		System.out.println("Dados do contato:\n" + contato);
	}


	
	private static void exibirFavoritos(Agenda agenda) {
		String[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
	}
	
	private static void adicionarFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("\nContato> ");
		int contato = Integer.parseInt(scanner.nextLine());
		System.out.println("\nPosição> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		
		if (agenda.ehFavorito(contato)) {
			System.out.println("CONTATO JA É FAVORITO");
		}else {
			agenda.adicionaFavorito(contato, posicao);
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
		}
	}
	
	private static void adicionarTag(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String[] linhaDeContatos = scanner.nextLine().split(" ");
		System.out.print("Tag> ");
		String tag = scanner.nextLine();
		System.out.print("Posição> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		
		// Passando String para inteiros.
		int[] contatos = new int[linhaDeContatos.length];
		for (int i = 0; i < contatos.length; i++) {
			contatos[i] = Integer.parseInt(linhaDeContatos[i]);
		}
		
		agenda.adicionaTag(contatos, tag, posicao);
	}
	
	private static void removerContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		String[] linhaDeContatos = scanner.nextLine().split(" ");
		
		// Passando String para inteiros.
		int[] contatos = new int[linhaDeContatos.length];
		for (int i = 0; i < contatos.length; i++) {
			contatos[i] = Integer.parseInt(linhaDeContatos[i]);
		}
		
		agenda.removeContatos(contatos);
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
