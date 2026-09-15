package model;
import java.sql.Date;
public class LoanModel {
    private int loanId;
    private String loanType;
    private int custId;
    private float amount;
    private String applicationStatus;
    private Date appliedDate;

    // No-argument constructor
    public LoanModel() {
    }

    // All-argument constructor
    public LoanModel(int loanId, String loanType, int custId, float amount,
                     String applicationStatus, Date appliedDate) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.custId = custId;
        this.amount = amount;
        this.applicationStatus = applicationStatus;
        this.appliedDate = appliedDate;
    }

    // Getter and Setter for loanId
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    // Getter and Setter for loanType
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    // Getter and Setter for custId
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    // Getter and Setter for amount
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Getter and Setter for applicationStatus
    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    // Getter and Setter for appliedDate
    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    // toString()
    @Override
    public String toString() {
        return "LoanModel [loanId=" + loanId
                + ", loanType=" + loanType
                + ", custId=" + custId
                + ", amount=" + amount
                + ", applicationStatus=" + applicationStatus
                + ", appliedDate=" + appliedDate + "]";
    }
}


