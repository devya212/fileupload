package com.nucleus.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nucleus.connection.ConnectionDetail;
import com.nucleus.connection.ConnectionFactory;
import com.nucleus.dao.ICustomerService;
import com.nucleus.dao.DAOFactoryCustomer;
import com.nucleus.filehandling.WriteFileLog;
import com.nucleus.model.Customer;

//Validation function to validate records at file level

public class ValidationFile 
{
	static String errorLogFile="Records in which error exist are:";
	Customer customer = new Customer();
	WriteFileLog log1 = new WriteFileLog();
	ICustomerService insertCustomer = DAOFactoryCustomer.customerFactory("jdbc");
	static int i1=1;
	public void validateCustomer(Customer customerValidate)
	{
		i1++;
		ValidationFile validateCustomer = new ValidationFile();
		customer.setCustomerCode(customerValidate.getCustomerCode());
		customer.setCustomerName(customerValidate.getCustomerName());
		customer.setCustomerAddress1(customerValidate.getCustomerAddress1());
		customer.setCustomerAddress2(customerValidate.getCustomerAddress2());
		customer.setCustomerPinCode(customerValidate.getCustomerPinCode());
		customer.setEmailAddress(customerValidate.getEmailAddress());
		customer.setContactNumber(customerValidate.getContactNumber());
		customer.setPrimaryContactPerson(customerValidate.getPrimaryContactPerson());
		customer.setRecordStatus(customerValidate.getRecordStatus());
		customer.setFlag(customerValidate.getFlag());
		customer.setCreateDate(customerValidate.getCreateDate());
		customer.setCreatedBy(customerValidate.getCreatedBy());
		customer.setModifiedDate(customerValidate.getModifiedDate());
		customer.setModifiedBy(customerValidate.getModifiedBy());
		customer.setAuthorizedDate(customerValidate.getAuthorizedDate());
		customer.setAuthorizedBy(customerValidate.getAuthorizedBy());
		
		
		boolean checkCode=validateCustomer.validateCode(customer.getCustomerCode());
		
		boolean checkName=validateCustomer.validateName(customer.getCustomerName());
		
		boolean checkAddress1=validateCustomer.validateAddress1(customer.getCustomerAddress1());
		
		boolean checkAddress2=validateCustomer.validateAddress2(customer.getCustomerAddress2());
		
		boolean checkPinCode=validateCustomer.validatePinCode(customer.getCustomerPinCode());
		
		boolean checkEmail=validateCustomer.validateEmail(customer.getEmailAddress());
		
		boolean checkContact=validateCustomer.validateContact(customer.getContactNumber());
		
		boolean checkPrimaryContact=validateCustomer.validatePrimaryContact(customer.getPrimaryContactPerson());
		
		boolean checkRecordStatus=validateCustomer.validateRecordStatus(customer.getRecordStatus());
		
		boolean checkFlag=validateCustomer.validateFlag(customer.getFlag());
		
		boolean checkCreateDate=validateCustomer.validateCreateDate(customer.getCreateDate());
		
		boolean checkCreateBy=validateCustomer.validateCreatedBy(customer.getCreatedBy());
		
		boolean checkModifiedBy=validateCustomer.validateModifiedBy(customer.getModifiedBy());
		
		boolean checkAuthorizedBy=validateCustomer.validateAuthorizedBy(customer.getAuthorizedBy());
		
		boolean checkCodeExist= validateCustomer.codeExist(customer.getCustomerCode());
		
		if(checkCode==false||checkName==false||checkAddress1==false||checkAddress2==false||checkPinCode==false||checkEmail==false||checkContact==false||checkPrimaryContact==false||checkRecordStatus==false||checkFlag==false||checkCreateDate==false||checkCreateBy==false||checkModifiedBy==false||checkAuthorizedBy==false||checkCodeExist==true)
		{
			log1.writeError(errorLogFile); //Function called to write error in log file.
		}
		else
		{
			insertCustomer.insert(customer); //Function called to insert record in the table.
		}
		
	}
	
	public boolean validateCode(String code) //Function to validate customer code.
	{
		if(code.length()<=10&&code!=null)
		{
			return true;
		}
		else
		{	
			errorLogFile=errorLogFile+("\nError in customer code:"+i1+":"+code); //Function to validate customer code.
			return false;	
		}
	}
	
	public boolean validateName(String name)
	{
		if(name.matches("[ a-zA-Z0-9]+$")&&name.length()<=30)
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer name:"+i1+":"+name); //Function to validate customer name.
			return false;
		}	
	}
	
	public boolean validateAddress1(String address1)  //Function to validate customer address1.
	{
		if(address1.length()<=100&&!address1.isEmpty())
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer Address1:"+i1+":"+address1);
			return false;
		}
	}
	
	public boolean validateAddress2(String address2)  //Function to validate customer address2.
	{
		if(address2==null||address2.length()<=100)
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer Address2:"+i1+":"+address2);
			return false;
		}
	}
	
	public boolean validatePinCode(String pinCode) //Function to validate customer pincode.
	{
		if(pinCode.matches("[0-9]+")&&pinCode.length()==6 )
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer Pin Code:"+i1+":"+pinCode);
			return false;
		}
	}
	
	public boolean validateEmail(String email) //Function to validate customer email address.
	{
		 if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$") && email.length()<=100) 
		 {
			 return true;
		 }
		 else
		 {
			 errorLogFile=errorLogFile+("\nError in customer email address:"+i1+":"+email);
				return false;
		}
                  
	}
	
	public boolean validateContact(String contact) //Function to validate customer contact number.
	{
		if(contact==null)
		{
			return true;
		}
		else
		{
			if(contact.matches("^[0-9]+$*")&&contact.length()<=20 )
			{
			return true;
			}
			else
			{
				errorLogFile=errorLogFile+("\nError in customer contact number:"+i1+":"+contact);
			return false;
			}
		}
	}
	
	public boolean validatePrimaryContact(String primaryContact) //Function to validate customer primary contact person.
	{
		if(primaryContact!=null&&primaryContact.length()<=100 )
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer primary contact person:"+i1+":"+primaryContact);
			return false;
		}
	}
	
	public boolean validateRecordStatus(String recordStatus) //Function to validate customer record status.
	{
		if(recordStatus.equalsIgnoreCase("N")||recordStatus.equalsIgnoreCase("M")||recordStatus.equalsIgnoreCase("D")||recordStatus.equalsIgnoreCase("A")||recordStatus.equalsIgnoreCase("R"))
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer recordStatus:"+i1+":"+recordStatus);
			return false;
		}
	}
	
	public  boolean validateFlag(String flag) //Function to validate customer active/inactive flag.
	{
		if(flag.equalsIgnoreCase("A")||flag.equalsIgnoreCase("I"))
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer active/inactive flag:"+i1+":"+flag);
			return false;
		}
	}
	
	public  boolean validateCreateDate(String createDate)  //Function to validate customer create date.
	{
		if(createDate!=null)
		{
			return true;
		}
		else
			errorLogFile=errorLogFile+("\nError in customer create Date:"+i1+":"+createDate);
			return false;
	}
	
	public  boolean validateCreatedBy(String createdBy) //Function to validate customer created by.
	{
		if(createdBy.matches("^[a-zA-Z0-9]+$")&&createdBy.length()<=30)
		{
			return true;
		}
		else
		{
			errorLogFile=errorLogFile+("\nError in customer createdBy:"+i1+":"+createdBy);
			return false;
		}
	}
	
		
	public  boolean validateModifiedBy(String modifiedBy) //Function to validate customer modified by.
	{
		if(modifiedBy==null)
		{
			return true;
		}
		else
		{
			if(modifiedBy.length()<=30)
			{
				return true;
			}
			else
			{
				errorLogFile=errorLogFile+("\nError in customer modified by:"+i1+":"+modifiedBy);
			return false;
			}
		}
		
	}
	
	
	public  boolean validateAuthorizedBy(String authorizedBy)
	{
		if(authorizedBy==null)
		{
			return true;
		}
		else
		{
			if(authorizedBy.length()<=30)
			{
				return true;
			}
			else
			{
				errorLogFile=errorLogFile+("\nError in customer authorized By:"+i1+":"+authorizedBy);
			return false;
			}
		}
	}
	
	public boolean codeExist(String customerCode)
	{
		ConnectionDetail connectionDetail = ConnectionFactory.connectionFactory("oracle");
		Connection con=null;
		try
		{
			
			con = connectionDetail.createConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from customer_varnika where customer_code=?");
			pstmt.setString(1,customerCode);			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()==true)
			{
				errorLogFile=errorLogFile+("\nError in Customer code:Customer code already exists,customer code is not unique:"+i1+":"+customerCode);
				return true;
			}
			else
			{
					return false;
				
			}
			
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
		return false;
	}

	
	
}
