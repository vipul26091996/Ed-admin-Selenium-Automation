package testfile;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import utilities.LoginHelper;

public class StaffLoginTest extends BaseSetup {

//	static LoginPage login_page;
//	static FileReader fr;
//	static Properties prop = new Properties();
	LoginHelper login_helper;

	@BeforeMethod
	public void init() throws IOException {
//		login_page = new LoginPage(driver);
//		fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\loginpage.properties");
//		prop.load(fr);
		login_helper = new LoginHelper(driver);
	}

	@Test
	public void testValidLogin() throws InterruptedException {

//		login_page.selectStaffTab();
//		login_page.enterUserID(prop.getProperty("staffuserid"));
//		login_page.enterPassword(prop.getProperty("staffpwd"));
//		login_page.clickLogin();
//		explicitwait.until(ExpectedConditions.titleIs("Dashboard"));
//		Assert.assertEquals(driver.getTitle(), "Dashboard", "Staff login should redirect to Dashboard");
		try {
			login_helper.doStaffValidLogin();
			Thread.sleep(20000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(driver.manage().window().getSize());

	}

}
