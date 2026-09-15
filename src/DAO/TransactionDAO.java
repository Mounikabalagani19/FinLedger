package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.TransactionModel;
import utility.DBConnection.DBConnection;

public class TransactionDAO {

		Connection con=null;
		DBConnection db=new DBConnection();
	
		 public TransactionModel addTransaction(TransactionModel tm) {

		        try {
		        	
		        

		            con = db.getConnection();

		            PreparedStatement ps = con.prepareStatement(
		                "insert into transaction_table(account_id, tranaction_type, amount) values (?,?,?)"
		            );

		            ps.setInt(1, tm.getAccountId());
		            ps.setString(2, tm.getTransactionType());
		            ps.setFloat(3, tm.getAmount());

		            int n = ps.executeUpdate();

		            if (n > 0) {
		                System.out.println("Transaction added successfully");
		            } else {
		                System.out.println("Transaction failed");
		            }

		        } catch (Exception e) {
		            System.out.println(e);
		        }

		        return tm;
		    }


		    // 2. View Transaction
		    public void viewTransaction(int transactionId) {

		        try {

		            con = db.getConnection();

		            PreparedStatement ps = con.prepareStatement(
		                "select * from transaction_table where transaction_id=?"
		            );

		            ps.setInt(1, transactionId);

		            ResultSet rs = ps.executeQuery();

		            if (rs.next()) {

		                System.out.println("Transaction ID: "
		                        + rs.getInt("transaction_id"));

		                System.out.println("Account ID: "
		                        + rs.getInt("account_id"));

		                System.out.println("Transaction Type: "
		                        + rs.getString("tranaction_type"));

		                System.out.println("Amount: "
		                        + rs.getFloat("amount"));

		                System.out.println("Transaction Date: "
		                        + rs.getTimestamp("transaction_date"));

		            } else {

		                System.out.println("Transaction not found");
		            }

		        } catch (Exception e) {

		            System.out.println(e);
		        }
		    }


		    // 3. View Account Transactions
		    public void viewAccountTransactions(int accountId) {

		        try {

		            con = db.getConnection();

		            PreparedStatement ps = con.prepareStatement(
		                "select * from transaction_table where account_id=?"
		            );

		            ps.setInt(1, accountId);

		            ResultSet rs = ps.executeQuery();

		            boolean found = false;

		            while (rs.next()) {

		                found = true;

		                System.out.println("----------------------------");

		                System.out.println("Transaction ID: "
		                        + rs.getInt("transaction_id"));

		                System.out.println("Transaction Type: "
		                        + rs.getString("tranaction_type"));

		                System.out.println("Amount: "
		                        + rs.getFloat("amount"));

		                System.out.println("Transaction Date: "
		                        + rs.getTimestamp("transaction_date"));
		            }

		            if (!found) {
		                System.out.println("No transactions found");
		            }

		        } catch (Exception e) {

		            System.out.println(e);
		        }

	}
}
		    


