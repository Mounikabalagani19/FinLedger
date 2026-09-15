package model;
import java.sql.Date;

public class PaymentModel {
        private int paymentId;
	    private int loanId;
	    private float amount;
	    private Date paidDate;

	    // No-argument constructor
	    public PaymentModel() {
	    }

	    // All-argument constructor
	    public PaymentModel(int paymentId, int loanId, float amount, Date paidDate) {
	        this.paymentId = paymentId;
	        this.loanId = loanId;
	        this.amount = amount;
	        this.paidDate = paidDate;
	    }

	    // Getter and Setter for paymentId
	    public int getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(int paymentId) {
	        this.paymentId = paymentId;
	    }

	    // Getter and Setter for loanId
	    public int getLoanId() {
	        return loanId;
	    }

	    public void setLoanId(int loanId) {
	        this.loanId = loanId;
	    }

	    // Getter and Setter for amount
	    public float getAmount() {
	        return amount;
	    }

	    public void setAmount(float amount) {
	        this.amount = amount;
	    }

	    // Getter and Setter for paidDate
	    public Date getPaidDate() {
	        return paidDate;
	    }

	    public void setPaidDate(Date paidDate) {
	        this.paidDate = paidDate;
	    }

	    // toString()
	    @Override
	    public String toString() {
	        return "PaymentModel [paymentId=" + paymentId
	                + ", loanId=" + loanId
	                + ", amount=" + amount
	                + ", paidDate=" + paidDate + "]";
	    }
	}

