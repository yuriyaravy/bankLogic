package bankTransferTest;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import bankLogic.Account;
import bankLogic.Currency;
import bankLogic.accountManager;

public class AccTest {
	
	public ArrayList createdTestAcc(){
		ArrayList<AccountTest> insaidAccount = new ArrayList<AccountTest>();
		AccountTest acc1 = new AccountTest("Tania", 200, Currency.EUR);
		AccountTest acc2 = new AccountTest("Ania", 300, Currency.USD);
		AccountTest acc3 = new AccountTest("Vania", 1200, Currency.PLN);
		insaidAccount.add(acc1);
		insaidAccount.add(acc2);
		insaidAccount.add(acc3);
		return insaidAccount;
	}
	@Test
	public void testTransfer() {
		AccTest at = new AccTest();
		ArrayList arList =	at.createdTestAcc();
		Account ac = accountManager.accountSearch("Tania", arList);
		Account ac2 = accountManager.accountSearch("Vania", arList);
		ac.transfer(250, ac2);
		if(ac.summa != 450.0){
			Assert.fail();
		}
		System.out.println(ac.summa);
	}

	@Test
	public void testDepositAccount() {
		AccTest at = new AccTest();
		ArrayList arList =	at.createdTestAcc();
		AccountTest ac = AccountTest.search("Tania", arList);
		ac.withdrowAccount(25, ac);
		if(ac.summa != 175){
			Assert.fail();
		}
	}

	@Test
	public void testWithdrowAccount() {
		AccTest at = new AccTest();
		ArrayList arList =	at.createdTestAcc();
		AccountTest ac = AccountTest.search("Ania", arList);
		ac.depositAccount(57, ac);
		if(ac.summa != 357){
			Assert.fail();
		}
	}
	@Test
	public void memoryWriter(){
		try{
		FileOutputStream fos = new FileOutputStream("c:/Java-1-0218/BankTransfer/src/bankMemoryTest.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		AccTest at = new AccTest();
		ArrayList arList =	at.createdTestAcc();
		oos.writeObject(arList);
		}catch(Exception e){
			System.out.println("Doesn't save Output steam" + e);
		}
	}
	
}
