package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerModel;
import utility.DBConnection.DBConnection;

public class CustomerDAO implements CustomerDAOInterface{
	Connection con=null;
	DBConnection db=new DBConnection();


	@Override
	public CustomerModel insertCustomer(CustomerModel cm) {
		try {
		con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into customer(cust_name,cust_phoneno,cust_email) values (?,?,?)");
		ps.setString(1, cm.getCustName());
		ps.setString(2, cm.getCustPhoneNo());
		ps.setString(3, cm.getCustEmail());
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println(n+"rows affected");
		}else {
			System.out.println("check again");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return cm;
	}
	
	public String viewCustomer(int cust_id) {
		try {
		con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from customer where cust_id=?");
		ps.setInt(1,cust_id);
		
		 ResultSet rs =ps.executeQuery();
		if(rs.next()) {
			System.out.println("Customer id:"+rs.getInt("cust_id"));
			System.out.println("Customer Name:"+rs.getString("cust_name"));
			System.out.println("Customer Phone No:"+rs.getString("cust_phoneno"));
			System.out.println("Customer email:"+rs.getString("cust_email"));
		}else {
			System.out.println("Customer not found!!");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public String updateCustomer(int cust_id,CustomerModel cm) {
		try {
		con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from customer where cust_id=?");
		ps.setInt(1,cm.getCustId());
		ResultSet rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			count++;
		}
		if(count>0) {
			PreparedStatement ps1=con.prepareStatement("update customer set cust_name=?,cust_phoneno=?,cust_email=? where cust_id=?");
			ps1.setString(1,cm.getCustName());
			ps1.setString(2, cm.getCustPhoneNo());
			ps1.setString(3, cm.getCustEmail());
			ps1.setInt(4, cust_id);
			int n=ps1.executeUpdate();
			if(n>0) {
				System.out.println(n+"rows affected");
			}else {
				System.out.println("Something went wrong..");
			}
			
		}else {
			System.out.println("customer with given id is not present ");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void deleteCustomer(int cust_id) {
		try {
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer where cust_id=?");
			ps.setInt(1,cust_id);
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				count++;
			}
			if(count>0) {
				PreparedStatement ps1=con.prepareStatement("delete from customer where cust_id=?");
				ps1.setInt(1, cust_id);
				int n=ps1.executeUpdate();
				if(n>0) {
					System.out.println(n+"rows affected");
				}else {
					System.out.println("Something went wrong..");
				}
				
			}else {
				System.out.println("customer with given id is not present ");
			}
			}catch(Exception e) {
				System.out.println(e);
			}
	}
		
		@Override
		public CustomerModel searchCustomer(CustomerModel cm) {
		    try {
		        con = db.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from customer where cust_id=? or cust_phoneno=? or cust_email=?");

		        ps.setInt(1, cm.getCustId());
		        ps.setString(2, cm.getCustPhoneNo());
		        ps.setString(3, cm.getCustEmail());

		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {

		            cm = new CustomerModel();

		            cm.setCustId(rs.getInt("cust_id"));
		            cm.setCustName(rs.getString("cust_name"));
		            cm.setCustPhoneNo(rs.getString("cust_phoneno"));
		            cm.setCustEmail(rs.getString("cust_email"));

		        } else {

		            System.out.println("Customer not found");
		        }

		    } catch (Exception e) {
		        System.out.println(e);
		    }

		    return cm;
		
	}

	
	

}
