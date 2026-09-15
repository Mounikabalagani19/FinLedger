package model;
public class CustomerModel {

    private int custId;
    private String custName;
    private String custPhoneNo;
    private String custEmail;

    // No-argument constructor
    public CustomerModel() {
    }

    // All-argument constructor
    public CustomerModel(int custId, String custName, String custPhoneNo, String custEmail) {
        this.custId = custId;
        this.custName = custName;
        this.custPhoneNo = custPhoneNo;
        this.custEmail = custEmail;
    }

    // Getter for custId
    public int getCustId() {
        return custId;
    }

    // Setter for custId
    public void setCustId(int custId) {
        this.custId = custId;
    }

    // Getter for custName
    public String getCustName() {
        return custName;
    }

    // Setter for custName
    public void setCustName(String custName) {
        this.custName = custName;
    }

    // Getter for custPhoneNo
    public String getCustPhoneNo() {
        return custPhoneNo;
    }

    // Setter for custPhoneNo
    public void setCustPhoneNo(String custPhoneNo) {
        this.custPhoneNo = custPhoneNo;
    }

    // Getter for custEmail
    public String getCustEmail() {
        return custEmail;
    }

    // Setter for custEmail
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    // toString() method
    @Override
    public String toString() {
        return "Customer [custId=" + custId
                + ", custName=" + custName
                + ", custPhoneNo=" + custPhoneNo
                + ", custEmail=" + custEmail + "]";
    }
}