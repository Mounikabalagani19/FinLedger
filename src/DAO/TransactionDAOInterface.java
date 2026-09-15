package DAO;

import model.TransactionModel;

public interface TransactionDAOInterface {
	public TransactionModel addTransaction(TransactionModel tm);
	public void viewTransaction(int transactionId);
	public void viewAccountTransactions(int accountId);

}
