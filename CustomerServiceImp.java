package com.nucleus.dao;

import com.nucleus.model.Customer;



public class CustomerServiceImp implements ICustomerService
{

	ICustomerDao customerDAO = new CustomerDAOImp();
	@Override
	public void insert(Customer customer)
	{
		customerDAO.insert(customer);
		
	}

	@Override
	public void truncate() 
	{
		customerDAO.truncate();
	}

}
