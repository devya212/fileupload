package com.nucleus.dao;

import com.nucleus.model.Customer;



public interface ICustomerDao 
{
		public void insert(Customer customer);
		public void truncate();
}
