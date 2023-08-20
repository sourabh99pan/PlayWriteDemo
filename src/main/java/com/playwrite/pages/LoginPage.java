package com.playwrite.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	private String emailId="#input-email";
	private String password = "#input-password";
	private String loginBtn = "input[value='Login']";
	private String forgotPwdLink="//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	
	//page constructor
	public LoginPage(Page page)
	{
		this.page=page;
	}
	
	//page actions/methods:
	public String getLoginPageTitle()
	{
		return page.title();
	}
	
	public boolean isForgotpwdLinkExist()
	{
		return page.isVisible(forgotPwdLink);
	}
	
	
}
