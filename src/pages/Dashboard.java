package pages;

import org.openqa.selenium.WebDriver;

import common.Common;
import values.CommonValues;

public class Dashboard {

	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean findByXpathAndClickLogoutBtn(String logoutBtnXpath) {
	
		if(Common.findByXpathAndClick(this.driver, CommonValues.logger, logoutBtnXpath)){
			return true;
		}
		return false;
	}
	
	public Boolean findByPartialTextAndClickLogoutBtn(String logoutBtnPartialLinkText) {
		
		if(Common.findByPartialTextAndClick(this.driver, CommonValues.logger, logoutBtnPartialLinkText)){
			return true;
		}
		return false;
	}

	public Boolean findByClassNameAndClickLogoutBtn(String myProfileIconClassName) {
		if(Common.findByClassNameAndClick(this.driver, CommonValues.logger, myProfileIconClassName)){
			return true;
		}
		return false;
	}
}