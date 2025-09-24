package testfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseSetup;
import objectrepository.AdmissionsPage;
import utilities.LoginHelper;
import utilities.MyListener;

@Listeners(MyListener.class)
public class AdmissionsTest extends BaseSetup {

	static AdmissionsPage adm_page;
	static LoginHelper login_helper;
	static Properties prop = new Properties();
	static String newCreatedAdmID;

	@BeforeMethod
	public void init() throws IOException {
		adm_page = new AdmissionsPage(driver);
		login_helper = new LoginHelper(driver);
		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "/src/main/resources/TestData/admissionspage.properties");
		prop.load(fr);
	}

	@Test
	public void addNewAdmission() throws InterruptedException {
		login_helper.doStaffValidLogin();
		adm_page.selectAdmissionsTab();
		adm_page.clickAddIcon();
		adm_page.switchToDetailsFrame();
		adm_page.fillFirstName(prop.getProperty("fname"));
		adm_page.fillMiddleName(prop.getProperty("mname"));
		adm_page.fillSurname(prop.getProperty("lname"));
		adm_page.fillPrefName(prop.getProperty("prefname"));
		adm_page.selectGender(prop.getProperty("gender"));
		adm_page.fillDOB(prop.getProperty("dob"));
		adm_page.fillBirthPlace(prop.getProperty("birthplace"));
		adm_page.fillPassNo(prop.getProperty("passno/id"));
		adm_page.selectType(prop.getProperty("type"));
		adm_page.fillAdmNo(prop.getProperty("admno"));
		adm_page.fillPosition(prop.getProperty("position"));
		adm_page.fillEmail(prop.getProperty("email"));
		adm_page.fillCell(prop.getProperty("cell"));
		adm_page.selectParent(prop.getProperty("parentid"));
		adm_page.selectRelationToParent(prop.getProperty("relationtoparent"));
		adm_page.selectGrade(prop.getProperty("grade"));
		adm_page.fillDateOfEntry(prop.getProperty("doe"));
		adm_page.selectLivingWith(prop.getProperty("livingwith"));
		adm_page.fillCurrentGrade(prop.getProperty("currgrade"));
		adm_page.fillPrevInstitution(prop.getProperty("previnst"));
		adm_page.selectStatus(prop.getProperty("status"));
		adm_page.fillResidentalAddress(prop.getProperty("residentaladdress"));
		adm_page.fillCurrentSchoolAddress(prop.getProperty("currschooladdress"));
		adm_page.fillGrouping(prop.getProperty("grouping"));
		adm_page.fillKeyword(prop.getProperty("keyword"));
		newCreatedAdmID = adm_page.clickSaveBtn();
		System.out.println("ID of admission is : " + newCreatedAdmID);
		adm_page.verifyNewAdmission(newCreatedAdmID);
		Assert.assertEquals(newCreatedAdmID.isBlank(), false,"ID not displayed");
		//Thread.sleep(10000);

	}
	
	@Test
	public void recordIsDisplayinAdmissionAnalysisReportv2() throws InterruptedException
	{
		login_helper.doStaffValidLogin();
		adm_page.selectAdmissionsTab();
		adm_page.clickReportsIcon();
		adm_page.selectAdmissionAnalysisReport();
		adm_page.switchToReportWindow();
		adm_page.selectCurrYear();
		adm_page.selectCampus();
		adm_page.selectAllGrade();
		boolean exist = adm_page.verifyInAARReport(newCreatedAdmID);
		SoftAssert sfassert = new SoftAssert();
		sfassert.assertEquals(exist, true,"Record is not in the report");
		
	}

}
