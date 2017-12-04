package bankLogic;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	
	private boolean exit;
	
	public void runMenu() throws SQLException{
		header();
		if(!exit){
			printMenu();
			int choice = getInput();
			mainMenuAction(choice);
		}
	}
	
	private void header(){
		System.out.println("\tBank menu:");
	}
	
	private void printMenu(){
		System.out.println("1 - Main account menu");
		System.out.println("2 - Information about your account ");
		System.out.println("3 - Transfer ");
		System.out.println("4 - Withdraw money ");
		System.out.println("0 - Exit ");
	}
	
	private void accountMenu(){
		System.out.println("1 - Create new account");
		System.out.println("2 - Deposit");
		System.out.println("3 - Add one more client");
		System.out.println("0 - Back");
	}
	
	private void infoMenu(){
		System.out.println("1 - Summa on your account");
		System.out.println("2 - Type of currency");
		System.out.println("0 - Back");
	}
	
	private void transferMenu(){
		System.out.println("1 -  If you want to transfer money from your to another account");
	}
	
	private void withdrawMenu(){
		System.out.println("1 - How much more do you want put in your pocket ");
	}
	
	protected static int getInput(){
		Scanner sc =  new Scanner(System.in);
		int choice = -1;
		System.out.print("\nEnter your choice: ");
		if(sc.hasNextInt()){
				while(choice < 0 || choice > 4){
					choice = sc.nextInt();
				}
		}else{
			System.out.print("it's not correct choice, only numbers");
		}
		return choice;
	}
	
	private void mainMenuAction(int choice) throws SQLException{
		switch(choice){
			case 0:
				exit = true;
				System.out.println("Thanks for useing our bank ");
				break;
			case 1:
				accountMenu();
				int choiceAct = getInput();
				accountMenuAction(choiceAct);
				break;
			case 2:
				infoMenu();
				choiceAct = getInput();
				infoMenuAction(choiceAct);
				break;
			case 3:
				transferMenu();
				choiceAct = getInput();
				transferMenuAction(choiceAct);
				break;
			case 4:
				withdrawMenu();
				break;
			default:
				System.out.println("\tError !!! ");
				printMenu();
				choice = getInput();
				mainMenuAction(choice);
		}
	}
	
	private void accountMenuAction(int choiceAct) throws SQLException{
		switch(choiceAct){
			case 0:
				printMenu();
				int choice = getInput();
				mainMenuAction(choice);
				break;
			case 1:
				accountManager.accountCreator();
				printMenu();
				choice = getInput();
				mainMenuAction(choice);
				break;
			case 2:
				System.out.println("Write your name for initialization");
				Scanner sc = new Scanner(System.in); 
				if(sc.hasNextInt()){
					System.out.println("Its not correct, try again.");
					int tr = 1;
					mainMenuAction(tr);
				}else{
					int id = sc.nextInt();
					Account acc = accountManager.accountSearch(id);
					System.out.println("How much money do you want put into your account ");
					if(sc.hasNextInt()){
						int sum = sc.nextInt();
						acc.depositAccount(sum);
					}else{
						System.out.println("Something wrong ");
					}
				}
				break;
			case 3:
				accountMenu();
				choiceAct = getInput();
				accountMenuAction(choiceAct);
				break;
			default:
				System.out.println("\tError !!! ");
				accountMenu();
				choiceAct = getInput();
				accountMenuAction(choiceAct);
		}
	}
	
	private void infoMenuAction(int choiceAct) throws SQLException{
		Account account = new Account();
		Scanner sc = new Scanner(System.in);
		switch(choiceAct){
			case 1:
				System.out.println("Your account id pls ");
				int id = sc.nextInt();
				Account acc = accountManager.accountSearch(id);
				System.out.println(acc.name);
				System.out.println(acc.summa);
				break;
			case 2:
				System.out.println("Your account id pls ");
				int id2 = sc.nextInt();
				Account acc2 = accountManager.accountSearch(id2);
				System.out.println(acc2.name);
				System.out.println(acc2.currency);
				break;
			case 0:
				printMenu();
				int choice = getInput();
				mainMenuAction(choice);
				break;
			default:
				System.out.println("\tError !!! ");
				infoMenu();
				choiceAct = getInput();
				infoMenuAction(choiceAct);
		}
	}

	private void transferMenuAction(int choiceAct) throws SQLException{
		switch(choiceAct){
			case 1:
				Scanner sc =  new Scanner(System.in);
				System.out.println("Your account id ");
				int idFrom = sc.nextInt();
				Account accFrom = accountManager.accountSearch(idFrom);
				System.out.println("How much do you want to transfer");
				int summa = sc.nextInt();
				System.out.println("Which account id do you want to transfer");
				int idTo = sc.nextInt();
				Account accTo = accountManager.accountSearch(idTo);
				accFrom.transfer(summa, accTo);
				break;
			default:
				System.out.println("\tError !!! ");
				transferMenu();
				choiceAct = getInput();
				transferMenuAction(choiceAct);
		}
	}
	
	private void withdrawMenuAction(int choiceAct) throws SQLException{
		switch(choiceAct){
			case 1:
				Scanner sc= new Scanner(System.in);
				System.out.println("Id of your account");
				int id = sc.nextInt();
				Account accWith = accountManager.accountSearch(id);
				System.out.println("How much money do you want withdraw");
				if(sc.hasNextInt()){
					int withdrawMoney = sc.nextInt();
					accWith.withdrowAccount(withdrawMoney);
				}else{
					System.out.println("only summa ");
				}
				break;
			default:
				System.out.println("\tError !!! ");
				withdrawMenu();
				choiceAct = getInput();
				withdrawMenuAction(choiceAct);
		}
	}
}
