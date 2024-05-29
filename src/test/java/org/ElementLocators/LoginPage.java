package org.ElementLocators;

import org.Utility.BaseClass;
import org.Utility.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private static LoginPage loginPage_inst;
	
	private LoginPage() {
		PageFactory.initElements(DriverManager.inst().driver, this);
	
	}
	public static LoginPage inst() {
		if (loginPage_inst== null) {
			loginPage_inst= new LoginPage();
		}
		
		return loginPage_inst;
	}
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginBtn;

	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void LoginPageStart(String s1, String s2) {
		BaseClass.inst().send_Keys(getUsername(), s1);
		BaseClass.inst().send_Keys(getPassword(), s2);
		BaseClass.inst().click(getLoginBtn());
		
		
	}
	
}
