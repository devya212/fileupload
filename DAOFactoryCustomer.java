package com.nucleus.dao;

public class DAOFactoryCustomer
{
	public static ICustomerService customerFactory(String type)
	{
		ICustomerService iCustomerService = null;
		if(type.equalsIgnoreCase("jdbc"))
		{
			CustomerServiceImp customerServiceImp = new CustomerServiceImp();
			iCustomerService = (ICustomerService)customerServiceImp;
		}
		return iCustomerService;
	}
}
