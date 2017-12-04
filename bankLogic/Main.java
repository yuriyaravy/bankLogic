package bankLogic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import bankLogic.dataBaseUtility.AccountDAO;
import bankTransferTest.AccountTest;

public class Main {
	
	// static ArrayList<Account> accounts = AccountDAO.read();

		public static void main(String[] args) throws IOException, SQLException {
			
			
			Menu menu = new Menu();
			menu.runMenu();
			
			/*
			accountManager.accountCreator(); 
			ArrayList<Account> t1 = new ArrayList<Account>();
			Account ac1 = new Account();
			ac1 = accountManager.accountSearch(2);
			System.out.println(ac1);
			ac1.withdrowAccount(30);  //945
			AccountDAO.update(ac1);
			
			Account acc2 = new Account("Ania", 300, Currency.USD);
			Main.accounts.add(acc2);
			
			System.out.println(Main.accounts);
			Account yr = accountManager.accountSearch("yra", Main.accounts);
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
			
			
			*/
		}

}
