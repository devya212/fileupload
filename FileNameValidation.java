package com.nucleus.validation;

import java.io.File;

public class FileNameValidation 
{
	public boolean validateFileExtension(String fileName)//Function to validate file extension.
	{
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if(i>0)
		{
			extension=fileName.substring(i+1);
		}
		if(extension.equals("txt"))
		{
			return true;
		}
		else
		{
			System.out.println("Enter file with .txt extension only");
			return false;
		}
	}
	public boolean checkRejection(String fileRejection) //Function to validate file rejection level.
	{
		if(fileRejection.equalsIgnoreCase("R")||fileRejection.equals("F"))
		{
			return true;
		}
		else
		{
			System.out.println("Enter file rejection as R or F only");
			return false;
		}
	}
	public boolean checkFileExist(String fileName) //Function to validate whether file exist in the determined path or not.
	{
		File file = new File(fileName);
		boolean check=file.exists();
		if(check==true)
			return true;
		else
			return false;
		
	}
}
