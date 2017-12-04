package bankTransferTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import bankLogic.Account;

public class MainTest {

	public static void main(String[] args) {
		
		AccTest ac = new AccTest();
		ArrayList<AccountTest> insaidAccount = ac.createdTestAcc();
		AccountTest ac1 = AccountTest.search("Ania", insaidAccount);
		System.out.println(ac1.name);
		
		/**
		ArrayList<AccountTest> insaidAccount = new ArrayList<AccountTest>();
		
		AccountTest acc1 = new AccountTest("Tania", 200, Currency.EUR);
		AccountTest acc2 = new AccountTest("Ania", 300, Currency.USD);
		AccountTest acc3 = new AccountTest("Vania", 1200, Currency.PLN);
		
		insaidAccount.add(acc1);
		insaidAccount.add(acc2);
		insaidAccount.add(acc3);
		
		AccountTest ac = AccountTest.search("Ania", insaidAccount);
		ac.depositAccount(25, ac);
		ac.withdrowAccount(170, ac);
		System.out.println(ac.summa);
*/
	}
}
