package bankTransferTest;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import bankLogic.Account;
import bankLogic.ConverterInternetImplements;
import bankLogic.Currency;
import bankLogic.IConverter;
import bankLogic.Menu;

public class AccountTest {
	
	String name; 
	double summa;
	Currency currency;
	
	public AccountTest(String name, double summa, Currency currency) {
		this.name = name;
		this.summa = summa;
		this.currency = currency;
	}
	@Test
	public static AccountTest search(String name, ArrayList<AccountTest> insaidAccount){
		for(AccountTest ac: insaidAccount){
			if((ac.getName())==name){
				return ac;
			}
		}
		return null;
	}
	@Test
	public String getName() {
		return name;
	}
	@Test
	public void setName(String name) {
		this.name = name;
	}
	@Test
	public void depositAccount(double summa, AccountTest acc){
		acc.summa  = acc.summa + summa;
	}
	@Test
	public void withdrowAccount(double summa, AccountTest acc){
		acc.summa  = acc.summa - summa;
	}
	
}
