package com.nucleus.filehandling;

import java.io.FileWriter;
import java.io.IOException;



public class WriteRecordLog 
{
	FileWriter fileWriter = null;
	public void writeCode(String error)//Function to write record wise error code in log record file.
	{
		try
		{
			fileWriter = new FileWriter("logRecord.txt");
			fileWriter.write(error);
			System.out.println("Error written successfully");
			fileWriter.flush();
		
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
