package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import activity.Login;
import values.IndexPageValues;

public class TestIndex {
	private static NgWebDriver ngDriver;
	
  @Test
  public void TestIndexfunc() throws Exception {
	  
	  WebDriver driver = Prerequisite.preRequisite();
	  driver.manage().window().maximize();
	  Login.getUrl(driver, IndexPageValues.webURL, IndexPageValues.expectedTitle);
	  
	  ngDriver = new NgWebDriver((JavascriptExecutor) driver);
	  ngDriver.waitForAngularRequestsToFinish();
		
		Login.doLogin(driver);
		
		Common.waitForXpathAndClick(driver, "//i[@class='fa fa-cog setting-io']");
		Common.waitForXpathAndClick(driver, "//a[@class='nav-link cog-link']");
		
		Common.waitForIdAndClick(driver, "csmShow");
		Common.waitForXpathAndClick(driver, "//li[contains(text(),'Course Management')]");
		Common.waitForXpathAndClick(driver, "//div[@class='col-md-2 btn-flext-start']//i[@class='fa fa-plus']");

  }
}
