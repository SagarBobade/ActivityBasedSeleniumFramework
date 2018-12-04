package pages;

import org.openqa.selenium.WebDriver;

import common.Common;
import values.CommonValues;

public class LoginPage {

	WebDriver driver;
	
	public Boolean findByNgAngularAndClickLoginBtn(String loginBtn) {
		if(Common.findByNgAngularBtnTextAndClick(this.driver, CommonValues.logger, loginBtn)){
			return true;
		}
		return false;
	}
	
	public Boolean findByXpathAndClickLoginBtn(String loginBtn) {
		if(Common.findByXpathAndClick(this.driver, CommonValues.logger, loginBtn)){
			return true;
		}
		return false;
	}

	public Boolean findByNameAndTypePassword(String password) {
		if(Common.findByNameAndType(this.driver, CommonValues.logger, location.LoginPage.password, password)){
			return true;
		}
		return false;
	}

	public LoginPage(WebDriver driver2) {
		this.driver = driver2;
	}
	
	public Boolean findByNameAndTypeUserId(String UserId) {
		if(Common.findByNameAndType(this.driver, CommonValues.logger, location.LoginPage.name, UserId)){
			return true;
		}
		return false;
	}

	public Boolean findByNameAndTypeOrgCode(String orgCode) {
		if(Common.findByNameAndType(this.driver, CommonValues.logger, location.LoginPage.orgCode, orgCode)){
			return true;
		}
		return false;
	}
	
	
}
