package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import base.BaseSetup;
import objectrepository.LoginPage;

public class LoginHelper {

	WebDriver driver;
	LoginPage login_page;
	Properties prop = new Properties();

	public LoginHelper(WebDriver driver) throws IOException {
		this.driver = driver;
		login_page = new LoginPage(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\loginpage.properties");
		prop.load(fr);
	}

	public void doStaffValidLogin() throws InterruptedException {
		login_page.selectStaffTab();
		login_page.enterUserID(prop.getProperty("staffuserid"));
		login_page.enterPassword(prop.getProperty("staffpwd"));
		login_page.clickLogin();
		BaseSetup.explicitwait.until(ExpectedConditions.titleIs("Dashboard"));
		Assert.assertEquals(driver.getTitle(), "Dashboard", "Staff login should redirect to Dashboard");
	}
}
