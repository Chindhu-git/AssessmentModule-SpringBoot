package com.example.demo.resource;

//import java.io.File;
//import java.sql.Blob;

public class ViewSubmission {
	public String grademail;
	public String filename;
	public byte[] submittedass;
	public int score;
	public ViewSubmission()
	{
		
	}
	ViewSubmission(String grademail, String filename, byte[] submittedass, int score)
	{
		super();
		this.grademail=grademail;
		this.filename=filename;
		this.submittedass=submittedass;
		this.score=score;
	}
	public String getGradEmail()
	{
		return grademail;
	}
	public void setGradEmail(String grademail)
	{
		this.grademail=grademail;
	}
	public String getFileName()
	{
		return filename;
	}
	public void setFileName(String filename)
	{
		this.filename=filename;
	}
	public byte[] getSubmittedAss()
	{
		return submittedass;
	}
	public void setSubmittedAss(byte[] submittedass)
	{
		System.out.println("Writing file");
		this.submittedass=submittedass;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score=score;
	}
}
