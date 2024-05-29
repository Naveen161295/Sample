package org.stepDefinitions;

import org.ElementLocators.BookAHotel;
import org.ElementLocators.LoginPage;
import org.ElementLocators.Page2_SearchHotel;
import org.ElementLocators.SelectHotel;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	@When("User should enter the login credentials with {string}, {string} and click the login button")
	public void userShouldEnterTheLoginCredentialsWithAndClickTheLoginButton(String c1, String c2) {
		System.out.println(c1);
		System.out.println(c2);
		LoginPage.inst().LoginPageStart(c1, c2);
	}

	@When("User should enter the Booking details such as {string},{string},{string},{string},{string},{string},{string},{string} and click submit button")
	public void userShouldEnterTheBookingDetailsSuchAsAndClickSubmitButton(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		Page2_SearchHotel.inst().searchHotels(string, string2, string3, string4, string5, string6, string7, string8);

	}

	@When("User should click the radio button and click search button")
	public void userShouldClickTheRadioButtonAndClickSearchButton() {
		SelectHotel.inst().selectHotels();
	}

	@When("User should enter the personal details such as {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and click Booknow button")
	public void userShouldEnterThePersonalDetailsSuchAsAndClickBooknowButton(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		BookAHotel.inst().selectAHotels(string, string2, string3, string4, string5, string6, string7, string8);
	}

	@Then("User should validate the Booking Confirmation")
	public void userShouldValidateTheBookingConfirmation() {

	}

}
