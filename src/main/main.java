package main;

import java.sql.Date;
import java.util.Scanner;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import DAO.LoanDAO;
import DAO.PaymentDAO;
import DAO.TransactionDAO;

import model.AccountModel;
import model.CustomerModel;
import model.LoanModel;
import model.PaymentModel;
import model.TransactionModel;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();
        LoanDAO loanDAO = new LoanDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        int mainChoice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Customer Management");
            System.out.println("2. Account Management");
            System.out.println("3. Loan Management");
            System.out.println("4. Payment Management");
            System.out.println("5. Transaction Management");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            mainChoice = sc.nextInt();

            switch (mainChoice) {

            // =====================================================
            // CUSTOMER MANAGEMENT
            // =====================================================
            case 1:

                int customerChoice;

                do {

                    System.out.println("\n===== CUSTOMER MANAGEMENT =====");
                    System.out.println("1. Add Customer");
                    System.out.println("2. View Customer");
                    System.out.println("3. Update Customer");
                    System.out.println("4. Delete Customer");
                    System.out.println("5. Search Customer");
                    System.out.println("6. Back");
                    System.out.print("Enter choice: ");

                    customerChoice = sc.nextInt();

                    switch (customerChoice) {

                    case 1:

                        CustomerModel cm = new CustomerModel();

                        System.out.print("Enter Customer Name: ");
                        sc.nextLine();
                        cm.setCustName(sc.nextLine());

                        System.out.print("Enter Phone Number: ");
                        cm.setCustPhoneNo(sc.nextLine());

                        System.out.print("Enter Email: ");
                        cm.setCustEmail(sc.nextLine());

                        customerDAO.insertCustomer(cm);

                        break;

                    case 2:

                        System.out.print("Enter Customer ID: ");
                        int custId = sc.nextInt();

                        customerDAO.viewCustomer(custId);

                        break;

                    case 3:

                        System.out.print("Enter Customer ID to update: ");
                        int updateId = sc.nextInt();

                        CustomerModel updateCustomer = new CustomerModel();

                        updateCustomer.setCustId(updateId);

                        System.out.print("Enter New Customer Name: ");
                        sc.nextLine();
                        updateCustomer.setCustName(sc.nextLine());

                        System.out.print("Enter New Phone Number: ");
                        updateCustomer.setCustPhoneNo(sc.nextLine());

                        System.out.print("Enter New Email: ");
                        updateCustomer.setCustEmail(sc.nextLine());

                        customerDAO.updateCustomer(updateId, updateCustomer);

                        break;

                    case 4:

                        System.out.print("Enter Customer ID to delete: ");
                        int deleteId = sc.nextInt();

                        customerDAO.deleteCustomer(deleteId);

                        break;

                    case 5:

                        CustomerModel searchCustomer = new CustomerModel();

                        System.out.println("\nSearch Customer");
                        System.out.println("Enter details for search.");

                        System.out.print("Enter Customer ID: ");
                        searchCustomer.setCustId(sc.nextInt());

                       

                        CustomerModel result =
                                customerDAO.searchCustomer(searchCustomer);

                        if (result != null && result.getCustName() != null) {

                            System.out.println("\n===== CUSTOMER DETAILS =====");
                            System.out.println("Customer ID: "
                                    + result.getCustId());
                            System.out.println("Customer Name: "
                                    + result.getCustName());
                            System.out.println("Phone Number: "
                                    + result.getCustPhoneNo());
                            System.out.println("Email: "
                                    + result.getCustEmail());
                        }

                        break;

                    case 6:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid choice");

                    }

                } while (customerChoice != 6);

                break;


            // =====================================================
            // ACCOUNT MANAGEMENT
            // =====================================================
            case 2:

                int accountChoice;

                do {

                    System.out.println("\n===== ACCOUNT MANAGEMENT =====");
                    System.out.println("1. Create Account");
                    System.out.println("2. View Account");
                    System.out.println("3. Deposit Money");
                    System.out.println("4. Withdraw Money");
                    System.out.println("5. Check Balance");
                    System.out.println("6. Back");
                    System.out.print("Enter choice: ");

                    accountChoice = sc.nextInt();

                    switch (accountChoice) {

                    case 1:

                        CustomerModel accountCustomer = new CustomerModel();
                        AccountModel am = new AccountModel();

                        System.out.print("Enter Customer ID: ");
                        accountCustomer.setCustId(sc.nextInt());

                        System.out.print("Enter Account Type: ");
                        sc.nextLine();
                        am.setAccountType(sc.nextLine());

                        System.out.print("Enter Initial Balance: ");
                        am.setBalance(sc.nextFloat());

                        accountDAO.createAccount(accountCustomer, am);

                        break;

                    case 2:

                        System.out.print("Enter Account ID: ");
                        int accountId = sc.nextInt();

                        accountDAO.viewAccount(accountId);

                        break;

                    case 3:

                        System.out.print("Enter Account ID: ");
                        int depositAccountId = sc.nextInt();

                        System.out.print("Enter Deposit Amount: ");
                        float depositAmount = sc.nextFloat();

                        accountDAO.deposit(depositAccountId, depositAmount);

                        break;

                    case 4:

                        System.out.print("Enter Account ID: ");
                        int withdrawalAccountId = sc.nextInt();

                        System.out.print("Enter Withdrawal Amount: ");
                        float withdrawalAmount = sc.nextFloat();

                        accountDAO.withdrwal(
                                withdrawalAccountId,
                                withdrawalAmount
                        );

                        break;

                    case 5:

                        System.out.print("Enter Account ID: ");
                        int balanceAccountId = sc.nextInt();

                        accountDAO.checkBalance(balanceAccountId);

                        break;

                    case 6:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid choice");

                    }

                } while (accountChoice != 6);

                break;


            // =====================================================
            // LOAN MANAGEMENT
            // =====================================================
            case 3:

                int loanChoice;

                do {

                    System.out.println("\n===== LOAN MANAGEMENT =====");
                    System.out.println("1. Apply Loan");
                    System.out.println("2. View Loan");
                    System.out.println("3. Approve Loan");
                    System.out.println("4. Reject Loan");
                    System.out.println("5. Back");
                    System.out.print("Enter choice: ");

                    loanChoice = sc.nextInt();

                    switch (loanChoice) {

                    case 1:

                        CustomerModel loanCustomer = new CustomerModel();
                        LoanModel lm = new LoanModel();

                        System.out.print("Enter Customer ID: ");
                        loanCustomer.setCustId(sc.nextInt());

                        System.out.print("Enter Loan Type: ");
                        sc.nextLine();
                        lm.setLoanType(sc.nextLine());

                        System.out.print("Enter Loan Amount: ");
                        lm.setAmount(sc.nextFloat());

                        // New loan should normally be PENDING
                        lm.setApplicationStatus("PENDING");

                        // Current date
                        lm.setAppliedDate(
                                new Date(System.currentTimeMillis())
                        );

                        loanDAO.createLoan(loanCustomer, lm);

                        break;

                    case 2:

                        System.out.print("Enter Loan ID: ");
                        int loanId = sc.nextInt();

                        loanDAO.viewLoanDetail(loanId);

                        break;

                    case 3:

                        System.out.print("Enter Loan ID to approve: ");
                        int approveLoanId = sc.nextInt();

                        loanDAO.approveLoan(approveLoanId);

                        break;

                    case 4:

                        System.out.print("Enter Loan ID to reject: ");
                        int rejectLoanId = sc.nextInt();

                        loanDAO.rejectLoan(rejectLoanId);

                        break;

                    case 5:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid choice");

                    }

                } while (loanChoice != 5);

                break;


            // =====================================================
            // PAYMENT MANAGEMENT
            // =====================================================
            case 4:

                int paymentChoice;

                do {

                    System.out.println("\n===== PAYMENT MANAGEMENT =====");
                    System.out.println("1. Make Payment");
                    System.out.println("2. View Payment");
                    System.out.println("3. View Loan Payments");
                    System.out.println("4. Back");
                    System.out.print("Enter choice: ");

                    paymentChoice = sc.nextInt();

                    switch (paymentChoice) {

                    case 1:

                        LoanModel paymentLoan = new LoanModel();
                        PaymentModel pm = new PaymentModel();

                        System.out.print("Enter Loan ID: ");
                        paymentLoan.setLoanId(sc.nextInt());

                        paymentDAO.makePayemnt(paymentLoan, pm);

                        break;

                    case 2:

                        System.out.print("Enter Payment ID: ");
                        int paymentId = sc.nextInt();

                        paymentDAO.viewPayment(paymentId);

                        break;

                    case 3:

                        System.out.print("Enter Loan ID: ");
                        int loanPaymentId = sc.nextInt();

                        paymentDAO.viewLoanPayments(loanPaymentId);

                        break;

                    case 4:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid choice");

                    }

                } while (paymentChoice != 4);

                break;


            // =====================================================
            // TRANSACTION MANAGEMENT
            // =====================================================
            case 5:

                int transactionChoice;

                do {

                    System.out.println("\n===== TRANSACTION MANAGEMENT =====");
                    System.out.println("1. Add Transaction");
                    System.out.println("2. View Transaction");
                    System.out.println("3. View Account Transactions");
                    System.out.println("4. Back");
                    System.out.print("Enter choice: ");

                    transactionChoice = sc.nextInt();

                    switch (transactionChoice) {

                    case 1:

                        TransactionModel tm = new TransactionModel();

                        System.out.print("Enter Account ID: ");
                        tm.setAccountId(sc.nextInt());

                        System.out.print("Enter Transaction Type: ");
                        sc.nextLine();
                        tm.setTransactionType(sc.nextLine());

                        System.out.print("Enter Amount: ");
                        tm.setAmount(sc.nextFloat());

                        transactionDAO.addTransaction(tm);

                        break;

                    case 2:

                        System.out.print("Enter Transaction ID: ");
                        int transactionId = sc.nextInt();

                        transactionDAO.viewTransaction(transactionId);

                        break;

                    case 3:

                        System.out.print("Enter Account ID: ");
                        int transactionAccountId = sc.nextInt();

                        transactionDAO.viewAccountTransactions(
                                transactionAccountId
                        );

                        break;

                    case 4:

                        System.out.println("Returning to Main Menu...");

                        break;

                    default:

                        System.out.println("Invalid choice");

                    }

                } while (transactionChoice != 4);

                break;


            // =====================================================
            // EXIT
            // =====================================================
            case 6:

                System.out.println("\nThank you for using FinLedger!");
                break;


            default:

                System.out.println("Invalid main menu choice");

            }

        } while (mainChoice != 6);

        sc.close();
    }
}