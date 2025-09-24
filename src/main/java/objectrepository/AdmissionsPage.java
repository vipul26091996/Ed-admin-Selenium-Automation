package objectrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BaseSetup;

public class AdmissionsPage {

	WebDriver driver;

	@FindBy(xpath = "(//*[@title='Admissions'])[1]//parent::a")
	WebElement admission_tab;

	@FindBy(xpath = "//iframe[@name='WList']")
	WebElement admlist_iframe;

	@FindBy(xpath = "//iframe[@name='WDetails']")
	WebElement admdetails_iframe;

	@FindBy(xpath = "//*[@title='New Application']")
	WebElement newadmission_icon;

	@FindBy(xpath = "//input[@id='RecFName']")
	WebElement firstname_txtbox;

	@FindBy(xpath = "//input[@id='RecMName']")
	WebElement middlename_txtbox;

	@FindBy(xpath = "//input[@id='RecLName']")
	WebElement surname_txtbox;

	@FindBy(xpath = "//input[@id='RecOName']")
	WebElement prefname_txtbox;

	@FindBy(xpath = "//select[@name='RecSex']")
	WebElement gender_ddn;

	@FindBy(xpath = "//input[@id='RecBirth']")
	WebElement dob_txtbox;

	@FindBy(xpath = "//img[@id='cal1']")
	WebElement dob_icon;

	@FindBy(xpath = "//input[@id='RecBPlace']")
	WebElement placeofbirth_txtbox;

	@FindBy(xpath = "//input[@id='RecPassNo']")
	WebElement passno_txtbox;

	@FindBy(xpath = "//select[@id='StudType']")
	WebElement studtype_ddn;

	@FindBy(xpath = "//input[@id='AdmNo']")
	WebElement admno_txtbox;

	@FindBy(xpath = "//input[@id='WaitListNo']")
	WebElement position_txtbox;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email_txtbox;

	@FindBy(xpath = "//input[@id='Cell']")
	WebElement cell_txtbox;

	@FindBy(xpath = "//select[@id='RelationID']")
	WebElement relation_ddn;

	@FindBy(xpath = "//select[@id='StYear']")
	WebElement grade_ddn;

	@FindBy(xpath = "//input[@id='EntryDate']")
	WebElement dateofentry_txtbox;

	@FindBy(xpath = "//select[@id='LivingWithID']")
	WebElement livingwith_ddn;

	@FindBy(xpath = "//input[@id='Class']")
	WebElement curringrade_txtbox;

	@FindBy(xpath = "//input[@id='PrevSchool']")
	WebElement previnstitution_txtbox;

	@FindBy(xpath = "//select[@id='StStatus']")
	WebElement status_ddn;

	@FindBy(xpath = "//textarea[@name='RecAddr']")
	WebElement residentaladdress_txtarea;

	@FindBy(xpath = "//input[@id='Sponsor']")
	WebElement currschooladdress_txtbox;

	@FindBy(xpath = "//input[@id='Grouping']")
	WebElement grouping_txtbox;

	@FindBy(xpath = "//label[text()='Keyword']//following::input[@id='Keyword']")
	WebElement keyord_txtbox;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement del_btn;

	@FindBy(xpath = "//input[@id='Save']")
	WebElement save_btn;

	@FindBy(xpath = "//span[contains(text(),'ID:')]")
	WebElement id_text;

	@FindBy(xpath = "//input[@id='RecSearch']")
	WebElement parent_searchbox;

	@FindBy(xpath = "//input[@title='Seach Parent']")
	WebElement search_icon;

	@FindBy(xpath = "//input[@id='SName' and @placeholder='Search']")
	WebElement search_field;

	@FindBy(xpath = "//div[@title='Reports']/span/img")
	WebElement reports_icon;

	@FindBy(xpath = "//div[@id='PrintDropdown']//child::div[contains(text(),'Admission Analysis Report')]")
	WebElement adm_analysis_report;

	@FindBy(xpath = "//div[@class='tabone']/a[1]")
	WebElement curr_year;

	@FindBy(xpath = "//div[@class='tab-item']//a[text()='Primary']")
	WebElement primary_campus;

	@FindBy(xpath = "//div[@class='tabtwo InnerTabColor']//a[text()='All']")
	WebElement all_grade;

	public AdmissionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectAdmissionsTab() {
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOfAllElements(admission_tab));
		admission_tab.click();
	}

	public void clickAddIcon() {
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(newadmission_icon));
		newadmission_icon.click();
	}

	public void switchToDetailsFrame() {
		BaseSetup.explicitwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(admdetails_iframe));
	}

	public void fillFirstName(String fname) {
		firstname_txtbox.sendKeys(fname);
	}

	public void fillMiddleName(String mname) {
		middlename_txtbox.sendKeys(mname);
	}

	public void fillSurname(String lname) {
		surname_txtbox.sendKeys(lname);
	}

	public void fillPrefName(String pname) {
		prefname_txtbox.sendKeys(pname);
	}

	public void selectGender(String gen) {
		Select select = new Select(gender_ddn);
		select.selectByVisibleText(gen);
	}

	public void fillDOB(String dob) {
		dob_txtbox.sendKeys(dob);
	}

	public void fillBirthPlace(String birthplace) {
		placeofbirth_txtbox.sendKeys(birthplace);
	}

	public void fillPassNo(String passno) {
		passno_txtbox.sendKeys(passno);
	}

	public void selectType(String type) {
		Select select = new Select(studtype_ddn);
		select.selectByVisibleText(type);
	}

	public void fillAdmNo(String admno) {
		admno_txtbox.sendKeys(admno);
	}

	public void fillPosition(String position) {
		position_txtbox.sendKeys(position);
	}

	public void fillEmail(String email) {
		email_txtbox.sendKeys(email);
	}

	public void fillCell(String cell) {
		cell_txtbox.sendKeys(cell);
	}

	public void selectRelationToParent(String relation) {
		Select select = new Select(relation_ddn);
		select.selectByVisibleText(relation);
	}

	public void selectGrade(String grade) {
		Select select = new Select(grade_ddn);
		select.selectByVisibleText(grade);
	}

	public void fillDateOfEntry(String doe) {
		dateofentry_txtbox.sendKeys(doe);
	}

	public void selectLivingWith(String living) {
		Select select = new Select(livingwith_ddn);
		select.selectByVisibleText(living);
	}

	public void fillCurrentGrade(String currgrade) {
		curringrade_txtbox.sendKeys(currgrade);
	}

	public void fillPrevInstitution(String previnst) {
		previnstitution_txtbox.sendKeys(previnst);
	}

	public void selectStatus(String status) {
		Select select = new Select(status_ddn);
		select.selectByVisibleText(status);
	}

	public void fillResidentalAddress(String residenceaddress) {
		residentaladdress_txtarea.sendKeys(residenceaddress);
	}

	public void fillCurrentSchoolAddress(String currschooladd) {
		currschooladdress_txtbox.sendKeys(currschooladd);
	}

	public void fillGrouping(String grouping) {
		grouping_txtbox.sendKeys(grouping);
	}

	public void fillKeyword(String keyword) {
		keyord_txtbox.sendKeys(keyword);
	}

	public String clickSaveBtn() {
		save_btn.click();
		if (BaseSetup.explicitwait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			alert.getText();
			alert.accept();
		}
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(id_text));
		String[] arr_id = id_text.getText().split(":");
		String id = arr_id[1].trim();
		return id;
	}

	public void selectParent(String parent_id) {
		search_icon.click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> iterate = win.iterator();
		String parentwin = iterate.next();
		String childwin = iterate.next();
		driver.switchTo().window(childwin);
		parent_searchbox.sendKeys(parent_id);
		parent_searchbox.sendKeys(Keys.ENTER);
		WebElement searchresult = driver.findElement(
				By.xpath("//table[contains(@class,'TableUIStyle')]//child::td[text()='" + parent_id + "']"));
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(searchresult));
		searchresult.click();
		driver.switchTo().window(parentwin);
		driver.switchTo().frame(admdetails_iframe);
	}

//	public void searchRecord(String id)
//	{
//		driver.switchTo().defaultContent();
//		search_field.sendKeys(id);
//		search_field.sendKeys(Keys.ENTER);
//		driver.switchTo().frame(admlist_iframe);
//		WebElement newrecord = driver.findElement(By.xpath("//tr[@id='ROW" + id + "']"));
//		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(newrecord));
//	}

	public void verifyNewAdmission(String id) {
		driver.switchTo().defaultContent();
		search_field.sendKeys(id);
		search_field.sendKeys(Keys.ENTER);
		driver.switchTo().frame(admlist_iframe);
		WebElement newrecord = driver.findElement(By.xpath("//tr[@id='ROW" + id + "']"));
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(newrecord));
		if (newrecord.isDisplayed()) {
			System.out.println("Successfully Created");
		} else {
			System.out.println("Not Created");
		}
	}

	public void clickReportsIcon() {
		reports_icon.click();
	}

	public void selectAdmissionAnalysisReport() {
		adm_analysis_report.click();
	}

	public void switchToReportWindow() {
		Set<String> win = driver.getWindowHandles();
		Iterator<String> iterate = win.iterator();
		String parentwindow = iterate.next();
		String childwindow = iterate.next();
		driver.switchTo().window(childwindow);
	}

	public void selectCurrYear() {
		curr_year.click();
	}

	public void selectCampus() {
		primary_campus.click();
	}

	public void selectAllGrade() {
		all_grade.click();
	}

	public boolean verifyInAARReport(String id) {
		boolean exist = false;
		int row = 2;
		while (driver.findElement(By.xpath("//table[@class='TableUIStyle']/tbody/tr[" + row + "]/td[1]"))
				.isDisplayed()) {
			String adm_id = driver.findElement(By.xpath("//table[@class='TableUIStyle']/tbody/tr[" + row + "]/td[1]"))
					.getText();
			System.out.println(adm_id);
			if (adm_id.equalsIgnoreCase(id)) {
				exist = true;
				break;
			}
			row++;
		}
		
		return exist;
	}
}
