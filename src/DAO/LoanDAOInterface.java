package DAO;

import model.CustomerModel;
import model.LoanModel;

public interface LoanDAOInterface {
	public LoanModel createLoan(CustomerModel cm,LoanModel lm);
	public void viewLoanDetail(int loan_id);
	public void approveLoan(int loan_id);
	public void rejectLoan(int loan_id);

}
