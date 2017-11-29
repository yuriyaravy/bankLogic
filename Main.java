package bankLogic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import bankTransferTest.AccountTest;

public class Main {

		public static void main(String[] args) throws IOException {
			
		//	Menu menu = new Menu();
		//	menu.runMenu();
			
			Account acc1 = new Account();
			acc1.accountCreator();
			
			Account acc2 = new Account("Ania", 300, Currency.USD);
			acc1.insaidAccount.add(acc2);
			
			System.out.println(acc1.insaidAccount);
			Account yr = acc1.accountSearch("yra", acc1.insaidAccount);
			System.out.println(yr.summa);
		//	acc1.memoryReader();
		//	System.out.println(acc1);
			/*
			ArrayList<Account> insaidAccount = new ArrayList<Account>();
			Account acc1 = new Account("Tania", 200, Currency.EUR);
			Account acc2 = new Account("Ania", 300, Currency.USD);
			Account acc3 = new Account("Vania", 1200, Currency.PLN);
			insaidAccount.add(acc1);
			insaidAccount.add(acc2);
			insaidAccount.add(acc3);
			
			Account ac = Account.accountSearch("Tania", insaidAccount);
			Account ac2 = Account.accountSearch("Vania", insaidAccount);
			
			ac.transfer(250, ac2);
			System.out.println(ac.summa);
			System.out.println(ac2.summa);
			
			
			System.out.println(acc3);
			
		//	Account a4 = new Account();
		//	a4.accountCreator();
		//	System.out.println(a4);
		//	System.out.println(a4.insaidAccount);
		//	a4.accountCreator();
		//	System.out.println(a4.repositoryAccounts);
			
			
			/*
			Accounte a1 = new Accounte();
			a1.currency = Currency.EUR;
			a1.summa = 1000;
			
			Accounte a2 = new Accounte();
			a2.currency = Currency.BLR;
			a2.summa = 1000;
			
			a1.deposit(10, a2);
			
			System.out.println("Куда ----> "+a1.summa);
			System.out.println("Откуда --> "+a2.summa);
			
			ConverterInternetImplements t = new ConverterInternetImplements();
			System.out.println(t.curMap);
			*/
			
			
		}

}
