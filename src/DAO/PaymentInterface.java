package DAO;

import model.LoanModel;
import model.PaymentModel;

public interface PaymentInterface {

	public PaymentModel makePayemnt(LoanModel lm,PaymentModel pm);
	public void viewPayment(int paymentId);
	public void viewLoanPayments(int loanId);
		
	

}
