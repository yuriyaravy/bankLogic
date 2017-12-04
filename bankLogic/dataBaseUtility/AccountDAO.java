package bankLogic.dataBaseUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import bankLogic.Account;
import bankLogic.Currency;

public class AccountDAO {
	
	public static void insert(Account account) throws SQLException{
		Connection dbConnection = (Connection)dataBaseManager.getDBCannection();
		String query = "insert into accounts (name, summa, currency)"+
				" values ('"+account.name+"', "+account.summa+", '"+account.currency+"');";// account.currency account.summa и все поля нашего объекта
		Statement statement = null;
		try{
			statement = (Statement)dbConnection.createStatement();
			statement.execute(query);
		}catch(SQLException e){
			System.out.println("WE can't add new value for your column");
		}finally{
			if(statement != null){
				statement.close();
			}
			if(dbConnection != null){
				dbConnection.close();
			}
		}
	}

	public static void update(Account account) throws SQLException{
		Connection dbConnection = (Connection)dataBaseManager.getDBCannection();
		String query  = "update accounts set summa = "+account.summa+" "
				+ "where name = '"+account.name+"';"; //прописываем  MySQL запрос
		Statement statement = null;
		try{
			statement = (Statement)dbConnection.createStatement();
			statement.execute(query);
		}catch(SQLException e){
			System.out.println("WE can't update value into your column");
		}finally{
			if(statement != null){
				statement.close();
			}
			if(dbConnection !=null){
				dbConnection.close();
			}
		}
	}
	
	public static void delete(Account account) throws SQLException{
		Connection dbConnection = (Connection)dataBaseManager.getDBCannection();
		String query = "delete from accounts where name = '"+account.name+"';";
		Statement statement = null;
		try{
			statement = (Statement) dbConnection.createStatement();
			statement.execute(query);
		}catch(SQLException e){
			System.out.println("WE can't delete account by id");
		}finally{
			if(statement != null){
				statement.close();
			}
			if(dbConnection != null){
				dbConnection.close();
			}
		}
	}
	
	public static ArrayList<Account> read() throws SQLException{
		Connection dbConnection = (Connection)dataBaseManager.getDBCannection();
		String query = "select * from accounts;";
		Statement statement = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
		try{
			statement = (Statement)dbConnection.createStatement();
			ResultSet  rs = statement.executeQuery(query);
			while(rs.next()){
				Account accFrombtd = new Account();
				accFrombtd.name = rs.getString("name");
				accFrombtd.summa = rs.getInt("summa");
				String value = rs.getString("currency");
				Currency enumValue = Currency.valueOf(value);
				accFrombtd.currency = enumValue;
				accFrombtd.id = rs.getInt("id");
				accounts.add(accFrombtd);
			}
		}catch(SQLException e){
			System.out.println("WE could not read accounts");
			System.out.println(e);
		}finally{
			if (statement != null){
				statement.close();
			}
			if (dbConnection != null){
				dbConnection.close();
			}
		}
		return accounts;
	}
	
}
