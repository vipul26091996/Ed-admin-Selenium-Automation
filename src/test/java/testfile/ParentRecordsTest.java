package testfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseSetup;
import objectrepository.ParentRecordsPage;
import utilities.LoginHelper;
import utilities.MyListener;

@Listeners(MyListener.class)
public class ParentRecordsTest extends BaseSetup {

	static ParentRecordsPage parentrec_page;
	static LoginHelper login_helper;
	static Properties prop = new Properties();

	@BeforeMethod
	public void init() throws IOException {
		parentrec_page = new ParentRecordsPage(driver);
		login_helper = new LoginHelper(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/TestData/parentrecordspage.properties");
		prop.load(fr);
	}

	@Test
	public void createCustomFields() throws InterruptedException {
		login_helper.doStaffValidLogin();
		login_helper.openModule(prop.getProperty("modulename"));
		parentrec_page.clickOnMenu();
		parentrec_page.openCustomeFieldsMenu();
		parentrec_page.clickOnNewTabField();
		System.out.println("Rename tab");
		Thread.sleep(10000);
		parentrec_page.renameTab();
		System.out.println("Enter field name;");
		Thread.sleep(20000);
		parentrec_page.enterFieldName();
		Thread.sleep(20000);
		System.out.println("Field name entered.");
		parentrec_page.selectFieldType();
		parentrec_page.enterTextField();
		parentrec_page.selectTextFieldType();
		parentrec_page.clickSave();

	}

}
