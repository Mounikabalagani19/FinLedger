package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import model.LoanModel;
import model.PaymentModel;
import utility.DBConnection.DBConnection;

public class PaymentDAO implements PaymentInterface {
	Connection con=null;
	DBConnection db=new DBConnection();

	@Override
	public PaymentModel makePayemnt(LoanModel lm, PaymentModel pm) {
		 try {

		        con = db.getConnection();

		        // 1. Check whether loan exists and get its status
		        PreparedStatement ps = con.prepareStatement(
		            "select application_status from loan where loan_id=?"
		        );

		        ps.setInt(1, lm.getLoanId());

		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {

		            String status = rs.getString("application_status");

		            // 2. Check whether loan is approved
		            if (status.equalsIgnoreCase("APPROVED")) {

		                Scanner sc = new Scanner(System.in);

		                System.out.println("Enter payment amount:");
		                float amount = sc.nextFloat();
		                if (amount <= 0) {
		                    System.out.println("Payment amount must be greater than 0");
		                    return pm;
		                }

		                // 4. Insert payment
		                PreparedStatement ps1 = con.prepareStatement(
		                    "insert into payment(loan_id, amount, paid_date) values (?,?,?)"
		                );

		                ps1.setInt(1, lm.getLoanId());
		                ps1.setFloat(2, amount);
		                ps1.setDate(3, new java.sql.Date(System.currentTimeMillis()));

		                int n = ps1.executeUpdate();

		                if (n > 0) {
		                    System.out.println("Payment successful");
		                } else {
		                    System.out.println("Payment failed");
		                }

		            } else {

		                System.out.println(
		                    "Payment cannot be made. Loan status is: " + status
		                );
		            }

		        } else {

		            System.out.println("Loan not found");

		        }

		    } catch (Exception e) {

		        System.out.println(e);

		    }

		    return pm;
		}
	
	public void viewPayment(int paymentId) {

	    try {

	        con = db.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "select * from payment where payment_id=?"
	        );

	        ps.setInt(1, paymentId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            System.out.println("Payment ID: "
	                    + rs.getInt("payment_id"));

	            System.out.println("Loan ID: "
	                    + rs.getInt("loan_id"));

	            System.out.println("Amount: "
	                    + rs.getFloat("amount"));

	            System.out.println("Paid Date: "
	                    + rs.getDate("paid_date"));

	        } else {

	            System.out.println("Payment not found");
	        }

	    } catch (Exception e) {

	        System.out.println(e);
	    }
	}
	
	
	public void viewLoanPayments(int loanId) {

	    try {

	        con = db.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	            "select * from payment where loan_id=?"
	        );

	        ps.setInt(1, loanId);

	        ResultSet rs = ps.executeQuery();

	        float totalPaid = 0;
	        boolean found = false;

	        System.out.println("Payments for Loan ID: " + loanId);

	        while (rs.next()) {

	            found = true;

	            float amount = rs.getFloat("amount");

	            System.out.println("-------------------------");
	            System.out.println("Payment ID: "
	                    + rs.getInt("payment_id"));

	            System.out.println("Amount: " + amount);

	            System.out.println("Paid Date: "
	                    + rs.getDate("paid_date"));

	            totalPaid = totalPaid + amount;
	        }

	        if (found) {

	            System.out.println("-------------------------");
	            System.out.println("Total Paid: " + totalPaid);

	        } else {

	            System.out.println("No payments found for this loan");
	        }

	    } catch (Exception e) {

	        System.out.println(e);
	    }
	}

  
		
	
}
