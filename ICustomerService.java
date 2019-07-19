package com.nucleus.dao;

import com.nucleus.model.Customer;



public interface ICustomerService 
{
	public void insert(Customer customer);
	public void truncate();
}
