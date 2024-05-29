package org.ElementLocators;



import static org.testng.Assert.assertEquals;

import org.Utility.BaseClass;
import org.Utility.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SelectHotel {
	private static SelectHotel selectHotel_inst;
	
	private SelectHotel() {
		PageFactory.initElements(DriverManager.inst().driver, this);
	}

	public static SelectHotel inst() {
		if (selectHotel_inst==null) {
			selectHotel_inst = new SelectHotel();
		}
		return selectHotel_inst;
	}
	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement rdBtn;
	
	@FindBy(xpath="//input[@name='hotel_name_0']")
	private WebElement hotelname;
	
	@FindBy(xpath="//input[@name='arr_date_0']")
	private WebElement checkIn;
	
	@FindBy(xpath="//input[@name='dep_date_0']")
	private WebElement checkOut;
	
	@FindBy(xpath="//input[@name='room_type_0']")
	private WebElement roomType;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement btnContinue;
	
	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getRdBtn() {
		return rdBtn;
	}

	public WebElement getHotelname() {
		return hotelname;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getRoomType() {
		return roomType;
	}
	
	public void selectHotels() {
		System.out.println("The selected Hotel name is: "+BaseClass.inst().hotels);
		BaseClass.inst().click(getRdBtn());
		
		
		assertEquals(BaseClass.inst().hotels, BaseClass.inst().getAttributes(getHotelname()));
		assertEquals(BaseClass.inst().checkInDate, BaseClass.inst().getAttributes(getCheckIn()));
		assertEquals(BaseClass.inst().checkOutDate, BaseClass.inst().getAttributes(getCheckOut()));
		assertEquals(BaseClass.inst().roomType, BaseClass.inst().getAttributes(getRoomType()));
		
		BaseClass.inst().click(getBtnContinue());
	}
	
	
}
