package com.nucleus.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.nucleus.model.Customer;
import com.nucleus.model.File;
import com.nucleus.validation.ValidationFile;
import com.nucleus.validation.ValidationRecord;



public class SplitFile 
{
	
	public void splitCustomer(File file) //Split customer method to split records from the file input by the user.   
	{
		Customer customer;
		ValidationRecord validRecordCustomer = new ValidationRecord();
		ValidationFile validFileCustomer = new ValidationFile();
		String fileRejection=file.getRejectionLevel();
		String [] split = new String[1000];
		int i=0;
		FileReader fileReader=null;
		try 
		{
			fileReader = new FileReader(file.getFileName());
			BufferedReader br = new BufferedReader(fileReader);
			String str = br.readLine();
			while(str!=null)
			{
				split = str.split("~",-1);
				customer=new Customer();
				customer.setCustomerCode(split[i]);
				customer.setCustomerName(split[i+1]);
				customer.setCustomerAddress1(split[i+2]);
				customer.setCustomerAddress2(split[i+3]);
				customer.setCustomerPinCode(split[i+4]);
				customer.setEmailAddress(split[i+5]);
				customer.setContactNumber(split[i+6]);
				customer.setPrimaryContactPerson(split[i+7]);
				customer.setRecordStatus(split[i+8]);
				customer.setFlag(split[i+9]);
				customer.setCreateDate(split[i+10]);
				customer.setCreatedBy(split[i+11]);
				customer.setModifiedDate(split[i+12]);
				customer.setModifiedBy(split[i+13]);
				customer.setAuthorizedDate(split[i+14]);
				customer.setAuthorizedBy(split[i+15]);
				
				if(fileRejection.equalsIgnoreCase("R"))//If file rejection entered by the user is R - record level validation is called.
				{
					validRecordCustomer.validateCustomer(customer);
				}
				else if(fileRejection.equalsIgnoreCase("F")) //If file rejection entered by the user is F - file level validation is called.
				{
					validFileCustomer.validateCustomer(customer);
				}
				str=br.readLine();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
