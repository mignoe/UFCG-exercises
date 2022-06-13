import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Agenda agenda = new Agenda();
		while (true) {
			exibirMenu();
			String option = getOption(scanner);

			executar(option, agenda, scanner);
		}
	}	
	
	private static void exibirMenu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air");
		System.out.println();
	}
	
	private static String getOption(Scanner scanner) {
		System.out.print("Opção> ");
		
		String option = scanner.nextLine();
		
		if (!"CLES".contains(option)) {
			System.out.println("OPÇÃO INVÁLIDA!" + "\n");
			exibirMenu();
			option = getOption(scanner);
		}
		
		return option;
	}
	
	private static void executar(String option, Agenda agenda, Scanner scanner) {
		if (option.equals("S")) {
			System.exit(0);
		} else if (option.equals("C")){
			cadastrar(agenda, scanner);
		}
	}
	
	private static void cadastrar(Agenda agenda, Scanner scanner) {
		System.out.print("Posição> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Nome> ");
		String nome = scanner.nextLine();
		
		System.out.print("Sobrenome> ");
		String sobreNome = scanner.nextLine();
		
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine();
		
		System.out.println("CADASTRO REALIZADO" + "\n");
		
		agenda.cadastrar(posicao, nome, sobreNome, telefone);
	}
	
	
}
