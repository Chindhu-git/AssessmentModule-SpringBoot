package com.example.demo.resource;

public class SubmittedProject {
	public String project_name;
	public String email;
	public String projectlink;
	SubmittedProject()
	{
		
	}
	SubmittedProject(String project_name, String email, String projectlink)
	{
		super();
		this.project_name=project_name;
		this.email=email;
		this.projectlink=projectlink;
	}
	public String getProject_name()
	{
		return project_name;
	}
	public void setProject_name(String project_name)
	{
		this.project_name=project_name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getProjectLink()
	{
		return projectlink;
	}
	public void setProjectLink(String projectlink)
	{
		this.projectlink=projectlink;
	}
}

