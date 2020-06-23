package com.example.demo.resource;

public class AddQuestions {
	public String quiz_name;
	public String que;
	public String opta;
	public String optb;
	public String optc;
	public String optd;
	public String ans;
	public AddQuestions()
	{
		
	}
	public AddQuestions(String quiz_name, String que, String opta, String optb, String optc, String optd, String ans)
	{
		this.quiz_name=quiz_name;
		this.que=que;
		this.opta=opta;
		this.optb=optb;
		this.optc=optc;
		this.optd=optd;
		this.ans=ans;
	}
	public String getQuizName()
	{
		return quiz_name;
	}
	public void setQuizName(String quiz_name)
	{
		this.quiz_name=quiz_name;
	}
	public String getQue()
	{
		return que;
	}
	public void setQue(String que)
	{
		this.que=que;
	}
	public String getOptA()
	{
		return opta;
	}
	public void setOptA(String opta)
	{
		this.opta=opta;
	}
	public String getOptB()
	{
		return optb;
	}
	public void setOptB(String optb)
	{
		this.optb=optb;
	}
	public String getOptC()
	{
		return optc;
	}
	public void setOptC(String optc)
	{
		this.optc=optc;
	}
	public String getOptD()
	{
		return optd;
	}
	public void setOptD(String optd)
	{
		this.optd=optd;
	}
	public String getAns()
	{
		return ans;
	}
	public void setAns(String ans)
	{
		this.ans=ans;
	}
}
