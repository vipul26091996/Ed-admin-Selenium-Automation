package testfile;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

	@Test
	public void addEnquiry() throws InterruptedException, AWTException {
		login_helper.doStaffValidLogin();
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
		enquiry_page.clickonSaveBtn();

	}

}
