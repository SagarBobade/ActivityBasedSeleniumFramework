package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;

import exceptionLogText.CommonExceptionMsg;
import values.CommonValues;

public class Common {

	public static WebElement element;
	public static WebDriverWait wait;
	
	public static void waitForXpathAndClick(WebDriver driver, String xpath){
		wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.click();
	}

	public static void waitForIdAndClick(WebDriver driver, String id){
		wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		element.click();
	}

	public static void waitFor(WebDriver driver, WebElement elementToWaitFor){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementToWaitFor));
	}
	public static Boolean select(String value, By DropDown, WebDriver driver) {

		try{
		Select dropdown = new Select(driver.findElement(DropDown));
		dropdown.selectByVisibleText(value);
		return true;
		}
		catch (Exception e) {
			System.out.println("select function failed for selecting "+ value);
			return false;
		}
	}
	
	public static Boolean findByNameAndType(WebDriver driver,Logger logger, String fieldName, String name){
		
		try{
			System.out.println(fieldName + name);
		 driver.findElement(By.name(fieldName)).sendKeys(name);
		}catch(Exception e){
			logger.log(Level.INFO, CommonExceptionMsg.findByNameAndType+" - "+name );
		}
		 return true;
	}
	
	public static Boolean findByXpathAndClick(WebDriver driver,Logger logger, String xpath){
	
		try{
			 driver.findElement(By.xpath(xpath)).click();
			}catch(Exception e){
				logger.log(Level.INFO,CommonExceptionMsg.findByXpathAndClick+" - "+xpath);
			}
			 return true;
	}
	
	public static boolean findByPartialTextAndClick(WebDriver driver, Logger logger, String partialLinkText) {
		try{
			 driver.findElement(By.partialLinkText(partialLinkText)).click();
			}catch(Exception e){
				logger.log(Level.INFO,CommonExceptionMsg.findByPartialTextAndClick+" - "+partialLinkText);
			}
			 return true;
	}

	public static boolean findByClassNameAndClick(WebDriver driver, Logger logger, String myProfileIconClassName) {
		try{
			 driver.findElement(By.className(myProfileIconClassName)).click();
			}catch(Exception e){
				logger.log(Level.INFO,CommonExceptionMsg.findByPartialTextAndClick+"- "+myProfileIconClassName);
			}
			 return true;
	}

	public static boolean findByNgAngularBtnTextAndClick(WebDriver driver, Logger logger, String loginBtn) {
		try{
			 driver.findElement(ByAngular.buttonText("LOGIN")).click();
			}catch(Exception e){
				logger.log(Level.INFO,CommonExceptionMsg.findByPartialTextAndClick+"- "+loginBtn);
			}
			 return true;
	}
	
	public static void WriteToFile(WebDriver driver,String methodName) throws Exception{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		  String str = dateFormat.format(date);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(CommonValues.textLogFile));
		    writer.write(methodName +" 		------------------------------- "+str);
		    writer.newLine();
		    writer.close();
		   // Common.takeScreenshot(driver);
		    System.out.println("done");
	}
	public static void takeScreenshot(WebDriver driver) throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("E://testresults//failed-test.png"));
    }
	
	public static void loggerWithScreenshot(WebDriver driver,String exceptionLogMessage) throws Exception{
		takeScreenshot(driver);
		CommonValues.logger.log(Level.INFO, exceptionLogMessage);
	}


}

