package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nucleus.connection.ConnectionDetail;
import com.nucleus.connection.ConnectionFactory;
import com.nucleus.model.Customer;


public class CustomerDAOImp implements ICustomerDao
{
	static int i=1;
	@Override
	public void insert(Customer customer) //Function to insert records in the table.
	{
		ConnectionDetail connectionDetail = ConnectionFactory.connectionFactory("oracle");
		Connection con = null;
		
		try
		{
			con = connectionDetail.createConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into customer_varnika values(customer_var.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,customer.getCustomerCode());
			pstmt.setString(2,customer.getCustomerName());
			pstmt.setString(3,customer.getCustomerAddress1());
			pstmt.setString(4,customer.getCustomerAddress2());
			pstmt.setString(5,customer.getCustomerPinCode());
			pstmt.setString(6,customer.getEmailAddress());
			pstmt.setString(7,customer.getContactNumber());
			pstmt.setString(8,customer.getPrimaryContactPerson());
			pstmt.setString(9,customer.getRecordStatus());
			pstmt.setString(10,customer.getFlag());
			pstmt.setString(11,customer.getCreateDate());
			pstmt.setString(12,customer.getCreatedBy());
			pstmt.setString(13,customer.getModifiedDate());
			pstmt.setString(14,customer.getModifiedBy());
			pstmt.setString(15,customer.getAuthorizedDate());
			pstmt.setString(16,customer.getAuthorizedBy());
			pstmt.executeUpdate();
			System.out.println("Record:"+i+" inserted successfully");
			i++;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				connectionDetail.closeConnection(con);
			} 
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void truncate() //Function to truncate records in the table.
	{
		
		ConnectionDetail connectionDetail = ConnectionFactory.connectionFactory("oracle");
		Connection con = null;
		
		try
		{
			con = connectionDetail.createConnection();
			PreparedStatement pstmt = con.prepareStatement("truncate table customer_varnika");
			pstmt.executeUpdate();
			System.out.println("Your file is rejected-Table truncated successfully");
			System.out.println("Thank You");
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				connectionDetail.closeConnection(con);
			} 
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
		}
	}

}
