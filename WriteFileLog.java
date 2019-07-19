package com.nucleus.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import com.nucleus.dao.ICustomerService;
import com.nucleus.dao.DAOFactoryCustomer;


public class WriteFileLog
{
	FileWriter fileWriter = null;
	public void writeError(String errorFile) //Function to write file wise error code in logFile document.
	{
		try
		{
			fileWriter = new FileWriter("logFile.txt");
			fileWriter.write(errorFile);
			System.out.println("Error written successfully");
			fileWriter.flush();
			ICustomerService truncateCustomer = DAOFactoryCustomer.customerFactory("jdbc");
			truncateCustomer.truncate();//If even a single error exists in the file truncate method is called and file is rejected.
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(fileWriter==null)
			{
				try
				{
					fileWriter.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
}
