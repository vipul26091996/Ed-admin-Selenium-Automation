package testfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;  
import base.BaseSetup;
import objectrepository.LoginPage;

public class StaffLoginTest extends BaseSetup {

	static LoginPage login_page;
	static FileReader fr;
	static Properties prop = new Properties();

	@BeforeMethod
	public void init() throws IOException {
		login_page = new LoginPage(driver);
		fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\loginpage.properties");
		prop.load(fr);
	}

	@Test
	public void testValidLogin() throws InterruptedException {

		login_page.selectStaffTab();
		login_page.enterUserID(prop.getProperty("staffuserid"));
		login_page.enterPassword(prop.getProperty("staffpwd"));
		login_page.clickLogin();
		explicitwait.until(ExpectedConditions.titleIs("Dashboard"));
		Assert.assertEquals(driver.getTitle(), "Dashboard", "Title is Dashboard");
	}

}
