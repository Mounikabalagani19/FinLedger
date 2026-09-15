package DAO;

import model.CustomerModel;

public interface CustomerDAOInterface {
	public CustomerModel insertCustomer(CustomerModel cm);
	public String viewCustomer(int cust_id);
	public String updateCustomer(int cust_id,CustomerModel cm);
	public void deleteCustomer(int cust_id);
	public CustomerModel searchCustomer(CustomerModel cm);

}
