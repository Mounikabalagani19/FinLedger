package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.AccountModel;
import model.CustomerModel;
import utility.DBConnection.DBConnection;

public class AccountDAO implements AccountDAOInterface {
	Connection con=null;
	DBConnection db=new DBConnection();
	
	public AccountModel createAccount(CustomerModel cm,AccountModel am) {
		con=db.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("insert into account(account_type,cust_id,balance) values (?,?,?)");
		ps.setString(1, am.getAccountType());
		ps.setInt(2, cm.getCustId());
		ps.setFloat(3, am.getBalance());
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println(n+"rows affected");
		}else {
			System.out.println("Something went wrong..");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return am;
		
	}
	public String viewAccount(int account_id) {
		try {
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from account where account_id=?");
			ps.setInt(1,account_id);
			
			 ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				System.out.println("Account id:"+rs.getInt("account_id"));
				System.out.println("Account Type:"+rs.getString("account_type"));
				System.out.println("Customer ID:"+rs.getString("cust_id"));
				System.out.println("Balance:"+rs.getString("balance"));
			}else {
				System.out.println("Account not found!!");
			}
			}catch(Exception e) {
				System.out.println(e);
			}
		return null;
		
	}
	
	public void deposit(int accountId, float depositAmount) {

	    try {
	        con = db.getConnection();
	        PreparedStatement ps = con.prepareStatement("select balance from account where account_id=?");
	        ps.setInt(1, accountId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            float currentBalance = rs.getFloat("balance");
	            // 2. Validate deposit amount
	            if (depositAmount <= 0) {
	                System.out.println("Deposit amount must be greater than 0");
	                return;
	            }
	            // 3. Calculate new balance
	            float newBalance = currentBalance + depositAmount;

	            // 4. Update balance
	            PreparedStatement ps1 = con.prepareStatement(
	                "update account set balance=? where account_id=?"
	            );

	            ps1.setFloat(1, newBalance);
	            ps1.setInt(2, accountId);

	            int n = ps1.executeUpdate();

	            if (n > 0) {
	                System.out.println("Deposit successful");
	                System.out.println("Deposited amount: " + depositAmount);
	                System.out.println("New balance: " + newBalance);
	            } else {
	                System.out.println("Deposit failed");
	            }

	        } else {
	            System.out.println("Account not found");
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	public void withdrwal(int accountId, float withdrawlAmount) {

	    try {
	        con = db.getConnection();
	        PreparedStatement ps = con.prepareStatement("select balance from account where account_id=?");
	        ps.setInt(1, accountId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            float currentBalance = rs.getFloat("balance");
	            if (withdrawlAmount <= 0) {
	                System.out.println("Withdrawal amount must be greater than 0");
	                return;
	            }
	            // 3. Calculate new balance
	            float newBalance = currentBalance - withdrawlAmount;

	            // 4. Update balance
	            PreparedStatement ps1 = con.prepareStatement(
	                "update account set balance=? where account_id=?"
	            );

	            ps1.setFloat(1, newBalance);
	            ps1.setInt(2, accountId);

	            int n = ps1.executeUpdate();

	            if (n > 0) {
	                System.out.println("Deposit successful");
	                System.out.println("Deposited amount: " + withdrawlAmount);
	                System.out.println("New balance: " + newBalance);
	            } else {
	                System.out.println("Deposit failed");
	            }

	        } else {
	            System.out.println("Account not found");
	        }

	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	public void checkBalance(int account_id) {
		con=db.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select balance from account where account_id=?");
			ps.setInt(1, account_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				float balance = rs.getFloat("balance");
				System.out.println("Current Balance amount is:"+balance);
			}else {
				System.out.println("Account not found.");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
