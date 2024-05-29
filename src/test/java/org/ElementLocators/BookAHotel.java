package org.ElementLocators;

import org.Utility.BaseClass;
import org.Utility.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotel {
	private static BookAHotel bookAHotel_inst;

	private BookAHotel() {
		PageFactory.initElements(DriverManager.inst().driver, this);
	}

	public static BookAHotel inst() {
		if (bookAHotel_inst== null) {
			bookAHotel_inst= new BookAHotel();
		}
		return bookAHotel_inst;
	}

	@FindBy(name="first_name")
	private WebElement firstName;

	@FindBy(name="last_name")
	private WebElement lastname;

	@FindBy(name="address")
	private WebElement address;

	@FindBy(name="cc_num")
	private WebElement ccNum;

	@FindBy(xpath="//select[@name='cc_type']")
	private WebElement ccType;

	@FindBy(xpath="//select[@name='cc_exp_month']")
	private WebElement ccExpMonth;

	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement ccExpYear;

	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement ccCVV;

	@FindBy(xpath="//input[@id='book_now']")
	private WebElement bookNow;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}

	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	public WebElement getCcCVV() {
		return ccCVV;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public void selectAHotels(String s1, String s2, String s3, String s4, String s5, String s6, String s7,String s8) {
		BaseClass.inst().send_Keys(getFirstName(), s1);
		BaseClass.inst().send_Keys(getLastname(), s2);
		BaseClass.inst().send_Keys(getAddress(), s3);
		BaseClass.inst().send_Keys(getCcNum(), s4);
		BaseClass.inst().select("value", getCcType(), s5);
		BaseClass.inst().select("visibletext", getCcExpMonth(), s6);
		BaseClass.inst().select("value", getCcExpYear(), s7);
		BaseClass.inst().send_Keys(getCcCVV(), s8);
		BaseClass.inst().click(getBookNow());
	}

}
