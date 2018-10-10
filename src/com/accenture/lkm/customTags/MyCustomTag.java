package com.accenture.lkm.customTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyCustomTag extends SimpleTagSupport 
{
	private String color;
	private String content;
	
	public MyCustomTag() 
	{
		super();
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void doTag() throws JspException, IOException 
	{
		JspWriter out = getJspContext().getOut();
		
		out.write( "<td style = \" background-color : " + color + "  \" > " +  content +  " </td> ");
		
	}
	
}
