package model;
import java.sql.Timestamp;

public class TransactionModel {
	private int transactionId;
    private int accountId;
    private String transactionType;
    private float amount;
    private Timestamp transactionDate;

    // No-argument constructor
    public TransactionModel() {
    }

    // All-argument constructor
    public TransactionModel(int transactionId, int accountId,
                            String transactionType, float amount,
                            Timestamp transactionDate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // Getter and Setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for accountId
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    // Getter and Setter for transactionType
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Getter and Setter for amount
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Getter and Setter for transactionDate
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    // toString()
    @Override
    public String toString() {
        return "TransactionModel [transactionId=" + transactionId
                + ", accountId=" + accountId
                + ", transactionType=" + transactionType
                + ", amount=" + amount
                + ", transactionDate=" + transactionDate + "]";
    }
}

