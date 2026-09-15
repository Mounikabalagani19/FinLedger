package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerModel;
import model.LoanModel;
import utility.DBConnection.DBConnection;

public class LoanDAO {
	Connection con=null;
	DBConnection db=new DBConnection();
	public LoanModel createLoan(CustomerModel cm,LoanModel lm) {
		con=db.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("insert into loan(loan_type,cust_id,amount,application_status,applied_date) values (?,?,?,?,?)");
	    
		ps.setString(1,lm.getLoanType());
		ps.setInt(2,cm.getCustId());
		ps.setFloat(3,lm.getAmount());
		ps.setString(4,lm.getApplicationStatus());
		ps.setDate(5,lm.getAppliedDate());
		
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println(n+"Loan application submitted successfully");
		}else {
			System.out.println("Something went wrong");
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return lm;
	}
	
	public void viewLoanDetail(int loan_id) {
		con=db.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("select * from loan where loan_id=?");
		ps.setInt(1,loan_id);
		
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			System.out.println("Loan Id:"+rs.getInt("loan_id"));
			System.out.println("Loan Type:"+rs.getString("loan_type"));
			System.out.println("Customer Id:"+rs.getInt("cust_id"));
			System.out.println("Amount:"+rs.getFloat("amount"));
			System.out.println("Application status:"+rs.getString("application_status"));
			System.out.println("Application Date:"+rs.getDate("applied_date"));
		}else {
			System.out.println("Loan not found");
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void approveLoan(int loan_id) {

	    try {

	        con = db.getConnection();

	        // Check current loan status
	        PreparedStatement ps = con.prepareStatement(
	            "select application_status from loan where loan_id=?"
	        );

	        ps.setInt(1, loan_id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            String status = rs.getString("application_status");

	            if (status.equalsIgnoreCase("PENDING")) {

	                PreparedStatement ps1 = con.prepareStatement(
	                    "update loan set application_status=? where loan_id=?"
	                );

	                ps1.setString(1, "APPROVED");
	                ps1.setInt(2, loan_id);

	                int n = ps1.executeUpdate();

	                if (n > 0) {
	                    System.out.println("Loan approved successfully");
	                } else {
	                    System.out.println("Loan approval failed");
	                }

	            } else {

	                System.out.println(
	                    "Loan cannot be approved. Current status: " + status
	                );
	            }

	        } else {

	            System.out.println("Loan not found");
	        }

	    } catch (Exception e) {

	        System.out.println(e);
	    }
	}
	
	public void rejectLoan(int loan_id) {

	    try {

	        con = db.getConnection();

	        // Check current loan status
	        PreparedStatement ps = con.prepareStatement(
	            "select application_status from loan where loan_id=?"
	        );

	        ps.setInt(1, loan_id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            String status = rs.getString("application_status");

	            if (status.equalsIgnoreCase("PENDING")) {

	                PreparedStatement ps1 = con.prepareStatement(
	                    "update loan set application_status=? where loan_id=?"
	                );

	                ps1.setString(1, "REJECTED");
	                ps1.setInt(2, loan_id);

	                int n = ps1.executeUpdate();

	                if (n > 0) {
	                    System.out.println("Loan rejected successfully");
	                } else {
	                    System.out.println("Loan rejection failed");
	                }

	            } else {

	                System.out.println(
	                    "Loan cannot be rejected. Current status: " + status
	                );
	            }

	        } else {

	            System.out.println("Loan not found");
	        }

	    } catch (Exception e) {

	        System.out.println(e);
	    }
	}
	

}
