import java.util.Scanner;

public class Menu {
	Scanner scanner;
	
	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public executarMenu() {
		exibirMenu();
		option = getOption();
		executar(option)
		
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
	
}
