package org.ElementLocators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.Utility.BaseClass;
import org.Utility.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

public class Page2_SearchHotel {
	
	private Page2_SearchHotel() {
		PageFactory.initElements(DriverManager.inst().driver, this);
	}
	
	private static Page2_SearchHotel searchHotel_inst;
	
	public static Page2_SearchHotel inst() {
		if (searchHotel_inst==null) {
			searchHotel_inst= new Page2_SearchHotel();
		}
		return searchHotel_inst;
	}
	
	@FindBy(xpath="//td[text()='Search Hotel ']")
	private WebElement title;

	
	@FindBy(xpath = "//select[@id='location']")
	private WebElement location;
	
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotel;
	
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement noOfRooms;
	
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkInDate;
	
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement checkOutdate;
	
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultPerRoom;
	
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childrenPerRoom;
	
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement searchBtn;

	public WebElement getTitle() {
		return title;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutdate() {
		return checkOutdate;
	}

	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	String s1="Search Hotel";
	public void titleOfPage(String s1) {
		
		getTitle().isDisplayed();
		assertEquals(s1, getTitle().getText(), "Error");
	}
	
	public void searchHotels(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		BaseClass.inst().send_Keys(getLocation(), s1 );
		BaseClass.inst().send_Keys(getHotel(), s2);
		BaseClass.inst().hotels=s2;
		BaseClass.inst().send_Keys(getRoomType(), s3);
		BaseClass.inst().roomType=s3;
		BaseClass.inst().select("value",getNoOfRooms(), s4);
		BaseClass.inst().javaScriptExecutor("setAttribute", getCheckInDate(), s5 );
		BaseClass.inst().checkInDate=s5;
		BaseClass.inst().javaScriptExecutor("setattribute", getCheckOutdate(), s6);
		BaseClass.inst().checkOutDate=s6;
		BaseClass.inst().select("value", getAdultPerRoom(), s7);
		BaseClass.inst().select("visibletext", getChildrenPerRoom(), s8);
		getSearchBtn().click();
	}
	

}
