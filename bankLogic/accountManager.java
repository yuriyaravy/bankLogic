package bankLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bankLogic.dataBaseUtility.AccountDAO;

public class accountManager {
	
	public static void accountCreator(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write your name: ");
		String newName = sc.nextLine(); 
		System.out.println("Put money into a bank account: ");
		double summa = (double)sc.nextInt();
		Currency.ñurrencyMenu();
		System.out.println("Select currency type: ");
		int choiceCur = Menu.getInput();
		Currency.typeCurrency(choiceCur);
		Account account = new Account(newName, summa, Currency.typeCurrency(choiceCur));
		try {
			AccountDAO.insert(account);
		} catch (SQLException e) {
			System.out.println("WE can't add new account");
		}
	 //	insaidAccount.add(account);
		//memoryWriter(insaidAccount);
	}
	
	public static Account accountSearch(int id){
		ArrayList<Account> accDTB = new ArrayList<Account>();
		try {
			accDTB = AccountDAO.read();
		} catch (SQLException e) {
			System.out.println(e);
		}
		for(Account ac : accDTB){
			if((ac.id) == id){
				return ac;
			}
		}
		return null;
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
	
}
