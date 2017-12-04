package bankLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import bankLogic.dataBaseUtility.AccountDAO;

public class Account {
	
	public String name; 
	public double summa;
	public Currency currency;
	public int id;
	
	public Account() {}
	
	public Account(String name, double summa, Currency currency) {
		this.name = name;
		this.summa = summa;
		this.currency = currency;
	}
	
	public void transfer(double summa, Account acc) throws SQLException{
		IConverter conv = new  ConverterInternetImplements();
		Account account = new Account();
		acc.summa  = acc.summa - conv.fromCarrencyToCarrency(summa, currency, acc.currency);
		this.summa = this.summa + summa;
		AccountDAO.update(account);
	}
	
	public void depositAccount(double summa) throws SQLException{
		Account acc = new Account();
		this.summa  = (double)this.summa + summa;
		AccountDAO.update(acc);
	}
	
	public void withdrowAccount(double summa) throws SQLException{
		Account acc = new Account();
		this.summa  = (double)this.summa - summa;
		AccountDAO.update(acc);
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", summa=" + summa + ", currency=" + currency + "]";
	}
	
}
