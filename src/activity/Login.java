package activity;

import org.openqa.selenium.WebDriver;

import common.Common;
import exceptionLogText.CommonExceptionMsg;
import exceptionLogText.DashboardPageExceptionMsg;
import exceptionLogText.LoginPageExceptionMsg;
import pages.Dashboard;
import pages.LoginPage;
import values.IndexPageValues;

public class Login {

	public static void getUrl(WebDriver driver, String url, String expectedTitle) throws Exception {

		try {
			driver.get(url);
			if (!(driver.getTitle().equals(expectedTitle))) {

				throw new Exception(CommonExceptionMsg.pageTitleMismatched);
			}
		} catch (Exception e) {
			Common.loggerWithScreenshot(driver, CommonExceptionMsg.getURLFailed);
			// CommonValues.logger.log(Level.INFO,
			// CommonExceptionMsg.getURLFailed);
		}
	}

	public static Boolean doLogin(WebDriver driver) throws Exception {

		try {
			LoginPage loginPage = new LoginPage(driver);
			try {
				loginPage.findByNameAndTypeUserId(IndexPageValues.userId);
				loginPage.findByNameAndTypePassword(IndexPageValues.password);
				loginPage.findByNameAndTypeOrgCode(IndexPageValues.orgCode);
				loginPage.findByXpathAndClickLoginBtn(location.LoginPage.loginBtnXpath);
				Common.WriteToFile(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			} catch (Exception e) {
				Common.loggerWithScreenshot(driver, LoginPageExceptionMsg.doLoginFailed);
				System.out.println("1");
				// CommonValues.logger.log(Level.INFO,
				// LoginPageExceptionMsg.doLoginFailed);
			}
		} catch (Exception e) {
			Common.loggerWithScreenshot(driver, LoginPageExceptionMsg.LoginPageObjectCreationFailed);
			System.out.println("2");
			// CommonValues.logger.log(Level.INFO,
			// LoginPageExceptionMsg.LoginPageObjectCreationFailed);
		}
		return true;
	}

	public static void logout(WebDriver driver) throws Exception {

		try {
			Dashboard dashboard = new Dashboard(driver);
			try {
//				dashboard.findByXpathAndClickLogoutBtn(location.Dashboard.myProfileIcon);
				dashboard.findByClassNameAndClickLogoutBtn(location.Dashboard.myProfileIconClassName);
				Thread.sleep(2000);
				dashboard.findByXpathAndClickLogoutBtn(location.Dashboard.logOut);
				Common.WriteToFile(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			} catch (Exception e) {
				Common.loggerWithScreenshot(driver, DashboardPageExceptionMsg.logoutBtnClickFailed);
			}
		} catch (Exception e) {
			Common.loggerWithScreenshot(driver, DashboardPageExceptionMsg.DashboardPageObjectCreationFailed);
		}
	}
}
