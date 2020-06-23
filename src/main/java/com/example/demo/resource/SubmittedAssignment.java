package com.example.demo.resource;

import java.io.File;
//import java.sql.Blob;

public class SubmittedAssignment {
	public String assignment_name;
	public String email;
	public String filename;
	public File uploadfile;
	public SubmittedAssignment()
	{
		
	}
	public SubmittedAssignment(String assignment_name,String email, String filename, File uploadfile)
	{
		super();
		this.assignment_name=assignment_name;
		this.email=email;
		this.filename=filename;
		this.uploadfile=uploadfile;
	}
	public String getAssignment_name()
	{
		return assignment_name;
	}
	public void setAssignment_name(String assignment_name)
	{
		this.assignment_name=assignment_name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getFileName()
	{
		return filename;
	}
	public void setFileName(String filename)
	{
		this.filename=filename;
	}
	public File getUploadFile()
	{
		return uploadfile;
	}
	public void setUploadfile(File uploadfile)
	{
		this.uploadfile = uploadfile;
	}
}
