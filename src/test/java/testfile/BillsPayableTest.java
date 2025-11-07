package testfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseSetup;
import objectrepository.BillsPayablePage;
import utilities.LoginHelper;

public class BillsPayableTest extends BaseSetup {

	static BillsPayablePage billspay_page;
	static LoginHelper login_helper;
	static Properties prop = new Properties();

	@BeforeMethod
	public void init() throws IOException {
		billspay_page = new BillsPayablePage(driver);
		login_helper = new LoginHelper(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/TestData/billspayablepage.properties");
		prop.load(fr);
	}

	@Test
	public void TC1() throws InterruptedException {
		SoftAssert sfassert = new SoftAssert();
		login_helper.doStaffValidLogin();
		login_helper.openModule("Bills Payable");
		billspay_page.clickOnGlobalReportIcon();
		billspay_page.selectAgedSupplierBalanceReport();
		billspay_page.switchToChildWin();
		boolean isavailable = billspay_page.verifyOptionAvailable("Combined");
		sfassert.assertEquals(isavailable, true, "'Combined' option is not available.");
		boolean isselectable = billspay_page.verifyOptionSelectable("Combined");
		sfassert.assertEquals(isselectable, true, "'Combined' option is not selectable.");
		sfassert.assertAll();
	}

	@Test
	public void TC2() throws InterruptedException {
		SoftAssert sfassert = new SoftAssert();
		login_helper.doStaffValidLogin();
		login_helper.openModule("Bills Payable");
		billspay_page.clickOnGlobalReportIcon();
		billspay_page.selectAgedSupplierBalanceReport();
		billspay_page.switchToChildWin();
		boolean isavailable = billspay_page.verifyOptionAvailable("Both");
		sfassert.assertEquals(isavailable, true, "'Both' option is not available.");
		boolean isselectable = billspay_page.verifyOptionSelectable("Both");
		sfassert.assertEquals(isselectable, true, "'Both' option is not selectable.");
		billspay_page.clickOnShowBtn();
		sfassert.assertAll();
	}

}
