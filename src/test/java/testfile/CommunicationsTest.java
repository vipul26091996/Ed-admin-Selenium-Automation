package testfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseSetup;
import objectrepository.CommunicationsPage;
import utilities.LoginHelper;

public class CommunicationsTest extends BaseSetup {

	static CommunicationsPage comm_page;
	static LoginHelper login_helper;
	static Properties prop = new Properties();

	@BeforeMethod
	public void init() throws IOException {
		comm_page = new CommunicationsPage(driver);
		login_helper = new LoginHelper(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/TestData/communicationspage.properties");
		prop.load(fr);
	}

	@Test
	public void emailtoParents() throws InterruptedException {
		login_helper.doStaffValidLogin();
		comm_page.openCommunicationsTab();
		Thread.sleep(5000);
	}

	@Test
	public void sendNotifications() throws InterruptedException {
		login_helper.doStaffValidLogin();
		login_helper.openModule("Communications");
		//comm_page.openCommunicationsTab();
		comm_page.clickonBreadcrumbMenu();
		comm_page.selectNotifications();
		comm_page.clickOnNewNotificationBtn();
		comm_page.switchToWindow("child");
		comm_page.selectCategory("general");
		comm_page.fillNotificationSubject(prop.getProperty("Subject"));
		comm_page.fillNotificationDetails(prop.getProperty("Details"));
		comm_page.clickOnNextBtn();
		comm_page.selectAcademic();
		//comm_page.selectStaffAudience();
		 comm_page.selectStudentsAudience();
		comm_page.clickOnNextBtn();
		comm_page.clickOnSendNotificationBtn();
		comm_page.acceptSendNotificationAlert();
		comm_page.clickOnCloseBtn();
		// comm_page.switchToWindow("parent");
		// comm_page.clickonBreadcrumbMenu();
		Thread.sleep(20000);
	}
}
