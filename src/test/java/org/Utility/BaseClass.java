package org.Utility;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass extends CapturedData {
	String text;
	String currentUrl;
	String title;
	WebDriver driver;
	private static BaseClass baseClass_inst;
	
	private BaseClass(WebDriver src_driver) {
		driver= src_driver;
	}
	
	public static BaseClass inst() {
		if (baseClass_inst==null) {
			baseClass_inst= new BaseClass(DriverManager.inst().driver);
		}
		
		return baseClass_inst;
	}
	
	public void urlLaunch() {
		try {
			//PropertyFileReader.inst().prop_Reader();
			driver.get(PropertyFileReader.inst().url_name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void send_Keys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getCurrentUrl() {
		try {
			currentUrl = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentUrl;
	}

	public String getTitle() {
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}
	public String getAttributes(WebElement element) {
		try {
			 value=element.getAttribute("value");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public String getText(WebElement element) {
		try {
			text = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	public void actions(String method, WebElement element1) {
		try {
			Actions a= new Actions(driver);
			if (method.equalsIgnoreCase("mouseoveraction")) {
				a.moveToElement(element1).perform();
			}
			else if (method.equalsIgnoreCase("contextclick")) {
				a.contextClick(element1).perform();
			}
			else if (method.equalsIgnoreCase("doubleclick")) {
				a.doubleClick(element1).perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actions1(String method, WebElement element1, WebElement element2 ) {
		try {
			Actions a= new Actions(driver);
			a.dragAndDrop(element1, element2).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String alert(String method, String value) {
		try {
			Alert alert = driver.switchTo().alert();
			if (method.equalsIgnoreCase("accept")) {
				alert.accept();
			}
			else if (method.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
			else if (method.equalsIgnoreCase("sendkeys")) {
				alert.sendKeys(value);
			}
			else if (method.equalsIgnoreCase("gettext")) {
				text = alert.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public void select(String method, WebElement element, String value) {
		try {
			Select s= new Select(element);
			if (method.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(value);
				s.selectByIndex(parseInt);
			}
			else if (method.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			}
			else if (method.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(value);
			}
			else if (method.equalsIgnoreCase("ismultiple")) {
				boolean multiple = s.isMultiple();
				System.out.println(multiple);

			}
			else if (method.equalsIgnoreCase("getoptions")) {
				List<WebElement> options = s.getOptions();
				List<String> l=new LinkedList<String>();
				for (WebElement n : options) {
					String text2 = n.getText();
					l.add(text2);
				}
				System.out.println(l);
			}
			else if (method.equalsIgnoreCase("getallselectedoptions")) {
				List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
				List<String> l=new LinkedList<String>();
				for (WebElement n : allSelectedOptions) {
					String text2 = n.getText();
					l.add(text2);
				}
				System.out.println(l);
			}
			else if (method.equalsIgnoreCase("getfirstselectedoptions")) {
				WebElement firstSelectedOption = s.getFirstSelectedOption();
				text = firstSelectedOption.getText();

			}
			else if (method.equalsIgnoreCase("deselectbyindex")) {
				int parseInt = Integer.parseInt(value);
				s.deselectByIndex(parseInt);
			}
			else if (method.equalsIgnoreCase("deselectbyvalue")) {
				s.deselectByValue(value);
			}
			else if (method.equalsIgnoreCase("deselectbyvisibletext")) {
				s.deselectByVisibleText(value);
			}
			else if (method.equalsIgnoreCase("deselectall")) {
				s.deselectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();}
	}

	public void javaScriptExecutor(String method, WebElement element, String value) {
		try {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			if (method.equalsIgnoreCase("setattribute")) {
				js.executeScript("arguments[0].setAttribute('value','"+value+"')", element);
			}
			else if (method.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click()", element);
			}
			else if (method.equalsIgnoreCase("getattribute")) {
				Object obj= js.executeScript("return arguments[0].getAttribute('value')", element);
				String text= (String) obj;
				System.out.println(text);
			}
			else if (method.equalsIgnoreCase("scrollup")) {
				js.executeScript("arguments[0].scrollIntoView(false)", element);
			}
			else if (method.equalsIgnoreCase("scrolldown")) {
				js.executeScript("arguments[0].scrollIntoView(true)", element);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
