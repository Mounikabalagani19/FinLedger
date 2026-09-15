package model;

public class AccountModel {

    private int accountId;
    private String accountType;
    private int custId;
    private float balance;

    // No-argument constructor
    public AccountModel() {
    }

    // All-argument constructor
    public AccountModel(int accountId, String accountType, int custId, float balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.custId = custId;
        this.balance = balance;
    }

    // Getter for accountId
    public int getAccountId() {
        return accountId;
    }

    // Setter for accountId
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    // Getter for accountType
    public String getAccountType() {
        return accountType;
    }

    // Setter for accountType
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Getter for custId
    public int getCustId() {
        return custId;
    }

    // Setter for custId
    public void setCustId(int custId) {
        this.custId = custId;
    }

    // Getter for balance
    public float getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(float balance) {
        this.balance = balance;
    }

    // toString()
    @Override
    public String toString() {
        return "AccountModel [accountId=" + accountId
                + ", accountType=" + accountType
                + ", custId=" + custId
                + ", balance=" + balance + "]";
    }
}
