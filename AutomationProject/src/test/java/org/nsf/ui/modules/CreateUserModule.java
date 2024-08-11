package org.nsf.ui.modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.nsf.ui.base.BrowserSetUp;
import org.nsf.ui.pages.CreateUserPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateUserModule {
	
	Logger log = LogManager.getLogger(CreateUserModule.class);
	
	 @Test(dataProvider = "userData")
	    public void createUserScenario(String firstName, String lastName, String idNumber, String married, String disabled,
	                                   String race, String email, String contactNumber, String passwordValue,
	                                   String confirmPasswordValue, String streetNumberValue, String streetNameValue,
	                                   String townValue, String provinceValue, String postalCodeValue) throws InterruptedException, IOException {

	        // Assertions to check for blank fields
	        assertNotBlank(firstName, "First Name");
	        assertNotBlank(lastName, "Last Name");
	        assertNotBlank(idNumber, "ID Number");
	        assertNotBlank(race, "Race");
	        assertNotBlank(email, "Email");
	        assertNotBlank(contactNumber, "Contact Number");
	        assertNotBlank(passwordValue, "Password");
	        assertNotBlank(confirmPasswordValue, "Confirm Password");
	        assertNotBlank(streetNumberValue, "Street Number");
	        assertNotBlank(streetNameValue, "Street Name");
	        assertNotBlank(townValue, "Town");
	        assertNotBlank(provinceValue, "Province");
	        assertNotBlank(postalCodeValue, "Postal Code");

	        CreateUserPage cp = new CreateUserPage();

	     // Actions part
	     			cp.enterFirstName(firstName);

	     			cp.enterLastName(lastName);

	     			cp.enteridNumber(idNumber);

	     			cp.selectMarriedCheckbox(married);

	     			cp.selectDisabledCheckbox(disabled);

	     			cp.selectRaceDropdown(race);

	     			cp.enterEmail(email);

	     			cp.enterCellPhone(contactNumber);
	     			Thread.sleep(1000);

	     			cp.selectAgreeCheckbox();

	     			cp.enterPassword(passwordValue);

	     			cp.enterConfirmPassword(confirmPasswordValue);

	     			cp.selectNextButton();
	     			Thread.sleep(1000);

	     			cp.enterStreetNumber(streetNumberValue);

	     			cp.enterStreetName(streetNameValue);

	     			cp.enterTownName(townValue);

	     			cp.selectProvinceDropdown(provinceValue);

	     			cp.enterPostalCode(postalCodeValue);

	     			cp.selectSubmitButton();
	     			
	     			String message=cp.getMessage();
	     			if(message.contains("Profile already exists"))
	     			{
	     				log.info("Profile already existed for the user " + firstName +" "+ lastName);
	     				Assert.assertTrue(false);
	     			}
	     			else if(message.contains("The ID number entered is not valid"))
	     			{
	     				log.info("ID number entered is not valid for the user " + firstName +" "+ lastName);
	     				Assert.assertTrue(false);
	     			}
	     			else
	     			{
	     			log.info("Profile created successfully for the user " + firstName +" "+ lastName);
	     			}
	     			Thread.sleep(2000);
	     			
	     			BrowserSetUp.driver.quit();
	     			

	       
	    }
	 
	 
	

	
	@DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        FileInputStream excelFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx");
        Workbook workbook = WorkbookFactory.create(excelFile);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i-1][j] = getCellValue(row.getCell(j));
            }
        }

        workbook.close();
        return data;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

   
    private void assertNotBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }
    }

}
