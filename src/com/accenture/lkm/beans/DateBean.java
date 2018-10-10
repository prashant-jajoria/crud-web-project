package com.accenture.lkm.beans;

import java.util.Date;

public class DateBean 
{
	private Date date;
	private String content;
	
	public DateBean() 
	{
		date = new Date();
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
