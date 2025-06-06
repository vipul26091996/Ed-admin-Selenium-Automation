package objectrepository;

import java.sql.ResultSet;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BaseSetup;
import utilities.DBUtils;

public class EnquiryPage {

	static Select select;
	WebDriver driver;
	boolean isInFrame = false;

	@FindBy(xpath = "(//*[@title='Enquiry'])[1]//parent::a")
	WebElement enquiry_tab;

	@FindBy(xpath = "//button[.//span[@title='New Enquiry']]")
	WebElement newenquiry_btn;

	@FindBy(id = "detailsFrame")
	WebElement enquiry_detailsframe;

	@FindBy(xpath = "//div[@class='ed-inquiry-list-details-header']/div[2]")
	WebElement header_enquiryid;

	@FindBy(xpath = "//div[@class='ed-inquiry-list-details-header']/div[1]")
	WebElement header_enquiryname;

	@FindBy(id = "Status")
	WebElement status_ddn;

	@FindBy(id = "RecDate")
	WebElement date_txtbox;

	@FindBy(id = "RecFrom")
	WebElement enquiryfrom_txtbox;

	@FindBy(id = "inquiryFrom")
	WebElement enquiryfor_txtbox;

	@FindBy(id = "RecEmail")
	WebElement email_txtbox;

	@FindBy(id = "RecCell")
	WebElement cell_txtbox;

	@FindBy(id = "RecPhone")
	WebElement phone_txtbox;

	@FindBy(id = "address")
	WebElement address_txtbox;

	@FindBy(id = "City")
	WebElement city_txtbox;

	@FindBy(id = "EntryYear")
	WebElement yearofentry_ddn;

	@FindBy(id = "RecSource")
	WebElement source_ddn;

	@FindBy(id = "RecFollow")
	WebElement notes_txtarea;

	@FindBy(id = "saveButton")
	WebElement save_btn;

	@FindBy(id = "deleteButton")
	WebElement delete_btn;

	@FindBy(id = "inquiryListFrame")
	WebElement enquiryListFrame;

	public EnquiryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectEnquiryTab() throws InterruptedException {
		BaseSetup.explicitwait.until(ExpectedConditions.elementToBeClickable(enquiry_tab));
		for (int i = 1; i <= 10; i++) {
			try {
				enquiry_tab.click();
				return;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		throw new RuntimeException("Enquiry tab not clickable after retries");
	}

	public void clickonNewEnquiryBtn() throws InterruptedException {
//		for (int i = 1; i <= 10; i++) {
//			try {
//
//				BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(newenquiry_btn));
//				((JavascriptExecutor) BaseSetup.driver).executeScript("arguments[0].scrollIntoView(true);",
//						newenquiry_btn);
//				Thread.sleep(1000);
//				BaseSetup.explicitwait.until(ExpectedConditions.elementToBeClickable(newenquiry_btn));
//				newenquiry_btn.click();
//				System.out.println("Click" + i);
//				return;
//			} catch (Exception e) {
//				Thread.sleep(1000);
//			}
//		}
//		throw new RuntimeException("New Enquiry Element not clickable after retries");
		Thread.sleep(2000);
		int i = 1;
		do {
			try {
				BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(newenquiry_btn));
				BaseSetup.explicitwait.until(ExpectedConditions.elementToBeClickable(newenquiry_btn));
				newenquiry_btn.click();
				System.out.println("Click " + i);
			} catch (Exception e) {
				Thread.sleep(1000);
			}
			if (enquiry_detailsframe.isDisplayed()) {
				driver.switchTo().frame(enquiry_detailsframe);
				if (status_ddn.isDisplayed()) {
					isInFrame = true;
					System.out.println("Enquiry Details is displaying");
					break;
				}
				driver.switchTo().parentFrame();
			}
			i++;
		} while (i <= 10);

	}

	public void switchtoEnquiryDetailsFrame() {
		if (isInFrame == false) {
			BaseSetup.explicitwait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(enquiry_detailsframe));
		}
		System.out.println("Switch to IFrame");
	}

	public void switchtoParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void fillEnquiryFrom(String enqfrom) {
		enquiryfrom_txtbox.sendKeys(enqfrom);
	}

	public void fillEnquiryFor(String enqfor) {
		enquiryfor_txtbox.sendKeys(enqfor);
	}

	public void fillEmail(String email) {
		email_txtbox.sendKeys(email);
	}

	public void fillCell(String cell) {
		cell_txtbox.sendKeys(cell);
	}

	public void fillPhone(String phone) {
		phone_txtbox.sendKeys(phone);
	}

	public void fillAddress(String address) {
		address_txtbox.sendKeys(address);
	}

	public void fillCity(String city) {
		city_txtbox.sendKeys(city);
	}

	public void fillNotes(String notes) {
		notes_txtarea.sendKeys(notes);
	}

	public void clickonDeleteBtn() {
		delete_btn.click();
	}

	public String clickonSaveBtn() {
		save_btn.click();
		driver.switchTo().frame(enquiry_detailsframe);
		WebElement enquiryid = driver.findElement(By.xpath("//div[@class='ed-inquiry-list-details-header']/div[2]"));
		BaseSetup.explicitwait.until(ExpectedConditions.visibilityOf(enquiryid));
		String id = enquiryid.getText();
		System.out.println(id);
		String[] idpart = id.split(": ");
		String idstr = idpart[1].trim();
		System.out.println(idstr);
		return idstr;

	}

	public void selectStatus(String value) {
		WebElement status_value = driver
				.findElement(By.xpath("//div[@id='Status']//descendant::li[@data-value='" + value + "']"));
		status_ddn.click();
		status_value.click();
	}

	public void selectYearofEntry(String value) {
		WebElement yoe_value = driver
				.findElement(By.xpath("//div[@id='EntryYear']//descendant::li[@data-value='" + value + "']"));
		yearofentry_ddn.click();
		yoe_value.click();
	}

	public void selectSource(String value) {
		WebElement source_value = driver
				.findElement(By.xpath("//div[@id='RecSource']//descendant::li[@data-value=" + value + "]"));
		source_ddn.click();
		source_value.click();
	}

	public void verifyinDB(String id) {
		DBUtils.connectToDB();
		ResultSet rs = DBUtils.executeQuery("Select * from where Inquiry where InquiryID = " + id);
		try {
			String value = rs.getString(2);
			System.out.println(value);
		} catch (Exception t) {
			t.getMessage();
		}
		DBUtils.closeConnection();
	}

	public void verifyNewEnquiry(String id) {
		driver.switchTo().defaultContent();
		int pagecount = 2;
		boolean recordfound = false;
		driver.switchTo().frame(enquiryListFrame);

		while (recordfound == false) {
			try {
				By rowLocator = By.xpath("//tr[contains(@id,'ROW" + id + "')]");
				BaseSetup.explicitwait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
				recordfound = true;
				System.out.println("Record added sccessfully");
				break;

			} catch (Exception e) {

			}

			try {
				By nextPageLocator = By
						.xpath("//a[contains(@onclick,'Page(" + pagecount + ")') and text()='" + pagecount + "']");
				WebElement nextPageBtn = BaseSetup.explicitwait
						.until(ExpectedConditions.elementToBeClickable(nextPageLocator));
				nextPageBtn.click();
				pagecount++;

			} catch (Exception e1) {
				System.out.println("Record not Found after checking all pages");
				break;
			}
		}
		if (!recordfound) {
			throw new NoSuchElementException("Enquiry record with ID " + id + " not found.");
		}

	}

	public void acceptAlert() {
		try {
			Alert myalert = BaseSetup.explicitwait.until(ExpectedConditions.alertIsPresent());
			if (myalert != null) {
				myalert = driver.switchTo().alert();
				myalert.getText();
				myalert.accept();
			}
		} catch (Exception e) {
		}
	}
}
