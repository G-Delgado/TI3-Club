package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	private Scanner in;
	private Club sapeClub;
	
	public Main() {
		in = new Scanner(System.in);
	}
	
	public static void main(String args[]) {
		Main ppal = new Main();
		int opt = 0;
		do {
			opt = ppal.showMenu();
			ppal.executeOperation(opt);
		} while (opt != 0);
		
	}
	
	public int showMenu() {
		int option = 0;
		System.out.println("\nQue quieres hacer?\n" +
		"(1)\n" +
		"(2)\n" +
		"(3)\n" +
		"(4)\n" +
		"(5)\n" +
		"(0) Para salir\n");
		option = in.nextInt();
		in.nextLine();
		return option;
	}
	
	public void executeOperation(int opt) {
		switch (opt) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}
}