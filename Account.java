package bankLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Account implements Serializable{
	
	ArrayList<Account> insaidAccount = new ArrayList<Account>();
	
//	Map<Integer , ArrayList> repositoryAccounts = new HashMap<Integer , ArrayList>();
	
	public String name; 
	public double summa;
	public Currency currency;
	
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
		memoryWriter(insaidAccount);
	}
	
	public void accountCreator(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Write your name: ");
		String newName = sc.nextLine(); 
		System.out.println("Put money into a bank account: ");
		double summa = (double)sc.nextInt();
		Currency.�urrencyMenu();
		System.out.println("Select currency type: ");
		int choiceCur = Menu.getInput();
		Currency.typeCurrency(choiceCur);
		Account account = new Account(newName, summa, Currency.typeCurrency(choiceCur));
		insaidAccount.add(account);
		//memoryWriter(insaidAccount);
	}
	//we does not use this method
	/*
	public int createAccountNumber(){
		Scanner sc= new Scanner(System.in);
		int key = 0;
		System.out.println("�ome up with a 4-digit account number if we alredy have account entry number of your account");
		if (sc.hasNextInt()){
			key = sc.nextInt();
		}else{
			System.out.println("we have big problem");
		}
		return key;
	}
	*/
	public void depositAccount(double summa, Account acc){
		acc.summa  = acc.summa + summa; 
		memoryWriter(insaidAccount);
	}
	
	public void withdrowAccount(double summa, Account acc){
		acc.summa  = acc.summa - summa;
		memoryWriter(insaidAccount);
	}
	
	public Account accountSearch(String name, ArrayList<Account> insAcc){
		for(Account ac : insAcc){
			if((ac.name) == name){
				System.out.println(ac);
				return ac;
			}
		}
		return null;
	}
	
	public void memoryWriter(ArrayList<Account> insaidAccount){
		try{
		FileOutputStream fos = new FileOutputStream("c:/Java-1-0218/BankTransfer/src/bankMemory.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(insaidAccount);
		oos.close();
		}catch(Exception e){
			System.out.println("Doesn't save Output steam");
		}
	}
	
	public ArrayList<Account> memoryReader(){
		try{
		FileInputStream fis = new FileInputStream("c:/Java-1-0218/BankTransfer/src/bankMemory.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Account> insaidAccount = (ArrayList<Account>)ois.readObject();
		}catch(Exception e){
			System.out.println("Doesn't get Output steam");
		}
		return insaidAccount;
	}
	

	@Override
	public String toString() {
		return "Account [name=" + name + ", summa=" + summa + ", currency=" + currency + "]";
	}
	
}
