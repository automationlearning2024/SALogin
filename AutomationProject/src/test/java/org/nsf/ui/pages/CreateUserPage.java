package org.nsf.ui.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.nsf.ui.base.BrowserSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPage {

	public static WebDriver driver;


	public static final By createProfile_button = By.xpath("//a[text()='Create profile']");
	public static final By firstName_textbox = By.name("firstName");
	public static final By lastName_textbox = By.name("lastName");
	public static final By idNumber_textbox = By.name("idNumber");
	public static final By married_checkbox = By.id("married");
	public static final By disabled_checkbox = By.id("disabled");
	public static final By race_button = By.xpath("//span[@title='Race']");
	public static final By race_dropdownValues = By.xpath("//ul[@role='listbox']/li");
	public static final By email_textbox = By.name("email");
	public static final By cellPhone_textbox = By.name("cellphone");
	public static final By agree_checkbox = By.xpath("//label[@for='agree']");
	public static final By password_textbox = By.name("password");
	public static final By confirmPassword_textbox = By.name("passwordCheck");
	public static final By next_button = By.cssSelector("button[type='submit']");
	public static final By streetNumber_textbox = By.xpath("//input[@placeholder='Street number']");
	public static final By streetName_textbox = By.xpath("//input[@placeholder='Street name']");
	public static final By townName_textbox = By.xpath("//input[@placeholder='Town']");
	public static final By selectProvince_button = By.xpath("//span[@title='Select Province']");
	public static final By province_dropdownValues = By.xpath("//ul[contains(@id,'select2-province')]/li");
	public static final By postalCode_textbox = By.xpath("//input[@placeholder='Postal code']");
	public static final By submit_button = By.xpath("//button[@type='submit']");
	public static final By message=By.xpath("//simple-snack-bar/span");
			
			
	public CreateUserPage() throws IOException {
		BrowserSetUp tb = new BrowserSetUp();
		driver = tb.getWebDriver();
		driver.findElement(createProfile_button).click();

	}

	public void enterFirstName(String value) {
		try {
			driver.findElement(firstName_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterLastName(String value) {
		try {
			driver.findElement(lastName_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enteridNumber(String value) {
		try {
			driver.findElement(idNumber_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectMarriedCheckbox(String status) {
		if (status.equalsIgnoreCase("true"))
			try {
				driver.findElement(married_checkbox).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void selectDisabledCheckbox(String status) {
		if (status.equalsIgnoreCase("true"))
			try {
				driver.findElement(disabled_checkbox).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void selectRaceDropdown(String text) {
		try {
			selectDropdown(race_button, race_dropdownValues, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEmail(String value) {
		try {
			driver.findElement(email_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterCellPhone(String value) {
		try {
			driver.findElement(cellPhone_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAgreeCheckbox() {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(agree_checkbox)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String value) {
		try {
			driver.findElement(password_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterConfirmPassword(String value) {
		try {
			driver.findElement(confirmPassword_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectNextButton() {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(next_button)).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterStreetNumber(String value) {
		try {
			driver.findElement(streetNumber_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterStreetName(String value) {
		try {
			driver.findElement(streetName_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterTownName(String value) {
		try {
			driver.findElement(townName_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectProvinceDropdown(String text) {
		try {
			selectDropdown(selectProvince_button, province_dropdownValues, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterPostalCode(String value) {
		try {
			driver.findElement(postalCode_textbox).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubmitButton() {
		try {
			driver.findElement(submit_button).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getMessage() {
		String textValue = null;
		
		try {
			WebElement element=driver.findElement(message);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			textValue=driver.findElement(message).getText();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textValue;
	}
	
	public  void selectDropdown(By button,By values,String value) throws InterruptedException
	{
	
	   WebElement dropdownButton = driver.findElement(button);
	   dropdownButton.click();
       Thread.sleep(2000);
       List<WebElement> allOptions= driver.findElements(values);
        for(int m=0;m<allOptions.size();m++)
        {
        	
           String optionValue=	allOptions.get(m).getText();
           if(optionValue.equalsIgnoreCase(value))
           {
        	   allOptions.get(m).click();
        	   Thread.sleep(1000);
        	   break;
           }
        	
        }
        
	}

}
