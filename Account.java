package bankLogic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Account {
	
	static ArrayList<Account> insaidAccount = new ArrayList<Account>();
	
//	Map<Integer , ArrayList> repositoryAccounts = new HashMap<Integer , ArrayList>();
	
	String name; 
	double summa;
	Currency currency;
	
	public Account() {}
	
	public Account(String name, double summa, Currency currency) {
		this.name = name;
		this.summa = summa;
		this.currency = currency;
	}
	
	public void transfer(double summa, Account acc){
		IConverter conv = new  ConverterInternetImplements();
		acc.summa  = acc.summa - conv.fromCarrencyToCarrency(summa, currency, acc.currency);
		this.summa = this.summa + summa;
	}
	
	public void accountCreator(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write your name: ");
		if(sc.hasNextInt()){
			System.out.println("only String");
		}else{
			String name = sc.nextLine(); 
			System.out.println("Put money into a bank account: ");
		}
		double summa = (double)sc.nextInt();
		Currency.ñurrencyMenu();
		System.out.println("Select currency type: ");
		int choiceCur = Menu.getInput();
		Currency.typeCurrency(choiceCur);
		Account account = new Account(name, summa, Currency.typeCurrency(choiceCur));
		insaidAccount.add(account);
	}
	
	public int createAccountNumber(){
		Scanner sc= new Scanner(System.in);
		int key = 0;
		System.out.println("Ñome up with a 4-digit account number if we alredy have account entry number of your account");
		if (sc.hasNextInt()){
			key = sc.nextInt();
		}else{
			System.out.println("we have big problem");
		}
		return key;
	}
	// depositAccount ne testiroval mogyt bit` ne dorobotki
	public void depositAccount(double summa, Account acc){
		IConverter conv = new  ConverterInternetImplements();
		acc.summa  = acc.summa + summa; // conv.fromCarrencyToCarrency(summa, currency, acc.currency);
	}
	// withdrowAccount ne testiroval mogyt bit` ne dorobotki
	public void withdrowAccount(double summa, Account acc){
		IConverter conv = new  ConverterInternetImplements();
		acc.summa  = acc.summa - summa; // conv.fromCarrencyToCarrency(summa, currency, acc.currency);
	}
	
	
	public static Account accountSearch(String name, ArrayList<Account> insAcc){
		for(Account ac : insAcc){
			if((ac.name) == name){
				System.out.println(ac);
				return ac;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", summa=" + summa + ", currency=" + currency + "]";
	}
	
}
