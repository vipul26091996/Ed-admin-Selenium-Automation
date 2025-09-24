package testfile;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import objectrepository.EnquiryPage;
import utilities.LoginHelper;

public class EnquiryTest extends BaseSetup {

	static EnquiryPage enquiry_page;
	static LoginHelper login_helper;
	static Properties prop = new Properties();

	@BeforeMethod
	public void init() throws IOException {
		enquiry_page = new EnquiryPage(driver);
		login_helper = new LoginHelper(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/TestData/enquirypage.properties");
		prop.load(fr);
	}

	@Test(priority=1)
	public void addEnquiry() throws InterruptedException, AWTException {
		String enquiry_id;
		login_helper.doStaffValidLogin();
		enquiry_page.acceptAlert();
		enquiry_page.selectEnquiryTab();
		enquiry_page.clickonNewEnquiryBtn();
		enquiry_page.switchtoEnquiryDetailsFrame();
		enquiry_page.selectStatus(prop.getProperty("status"));
		enquiry_page.fillEnquiryFrom(prop.getProperty("enquiryfrom"));
		enquiry_page.fillEnquiryFor(prop.getProperty("enquiryfor"));
		enquiry_page.fillEmail(prop.getProperty("email"));
		enquiry_page.fillCell(prop.getProperty("cell"));
		enquiry_page.fillPhone(prop.getProperty("phone"));
		enquiry_page.fillAddress(prop.getProperty("address"));
		enquiry_page.fillCity(prop.getProperty("city"));
		enquiry_page.selectYearofEntry(prop.getProperty("yearofentry"));
		enquiry_page.selectSource(prop.getProperty("source"));
		enquiry_page.fillNotes(prop.getProperty("notes"));
		enquiry_page.switchtoParentFrame();
		enquiry_id = enquiry_page.clickonSaveBtn();
		enquiry_page.verifyNewEnquiry(enquiry_id);
		// enquiry_page.verifyinDB(enquiry_id);

	}

	@Test(priority=2)
	public void verifyNewRecord() throws Exception {
		login_helper.doStaffValidLogin();
		enquiry_page.acceptAlert();
		enquiry_page.selectEnquiryTab();
		enquiry_page.verifyNewEnquiry("23");
		// enquiry_page.verifyinDB("23");

	}

	@Test(priority=3)
	@SuppressWarnings("deprecation")
	public void demo() {
		driver.get("https://practice-automation.com/");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		try {
			for (WebElement listelement : list) {
				String href = listelement.getAttribute("href");
				if (href == null || href.isEmpty()) {
					System.out.println("Blank link");
					continue;
				}
				URL url = new URL(href);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect();
				if (conn.getResponseCode() >= 400) {
					System.out.println(href + " = broken link");
				}
			}
		} catch (Exception e) {

		}
		throw new SkipException("Skipping due to missing config");
	}

}
