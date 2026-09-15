package DAO;

import model.AccountModel;
import model.CustomerModel;

public interface AccountDAOInterface {
	public AccountModel createAccount(CustomerModel cm,AccountModel am);
	public String viewAccount(int account_id);
	public void deposit(int accountId, float depositAmount);
	public void withdrwal(int accountId, float withdrawlAmount);
	public void checkBalance(int account_id);

}
