package objectrepository;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseSetup;

public class CommunicationsPage {

	WebDriver driver;

	@FindBy(id = "moreButton")
	private WebElement moreicon;

//	@FindBy(xpath = "//*[@title='Communications']/following-sibling::span")
//	WebElement comm_tab;

	@FindBy(xpath = "//button[@title='New Email']")
	private WebElement new_email;

	@FindBy(xpath = "//*[@id='new_menu_navigation']")
	private WebElement breadcrumb_menu;

	@FindBy(xpath = "//a[normalize-space(text())='Notifications']")
	private WebElement notifications_submenu;

	@FindBy(xpath = "//button[@title='New Notification']")
	private WebElement new_notification;

	@FindBy(xpath = "//textarea[@id='NotificationText']")
	private WebElement subwin_subject_textarea;

	@FindBy(xpath = "//textarea[@id='Details']")
	private WebElement subwin_details_textarea;

	@FindBy(xpath = "//input[@value='Next']")
	private WebElement subwin_next_btn;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement subwin_save_btn;

	@FindBy(xpath = "//input[@value='Close']")
	private WebElement subwin_close_btn;

	@FindBy(xpath = "//input[@id='audiancetype_1']")
	private WebElement subwin_acad_radiobtn;

	@FindBy(xpath = "//input[@id='Parents']")
	private WebElement subwin_parentsaudience;

	@FindBy(xpath = "//input[@id='Students']")
	private WebElement subwin_studentsaudience;

	@FindBy(xpath = "//input[@id='Staff']")
	private WebElement subwin_staffaudience;

	@FindBy(xpath = "//input[@value='Send Notification']")
	private WebElement subwin_sendnotification_btn;

	@FindBy(xpath = "//input[@value='Send Test Notification']")
	private WebElement subwin_sendtestnotification_btn;

	@FindBy(xpath = "//select[@name='Status']")
	private WebElement subwin_status_ddn;

	@FindBy(xpath = "//button[@type='button']")
	WebElement subwin_category_ddn;

	public CommunicationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openCommunicationsTab() {
		try {
			try {
				driver.findElement(By.xpath("(//*[@title='Communications'])[1]//parent::a")).click();
			} catch (Exception e) {
				moreicon.click();
				driver.findElement(By.xpath("(//*[@title='Communications'])[2]//parent::a")).click();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickonNewEmailbtn() {
		new_email.click();
	}

	public void clickonBreadcrumbMenu() {
		breadcrumb_menu.click();
	}

	public void selectNotifications() throws InterruptedException {
		BaseSetup.explicitwait.until(ExpectedConditions.elementToBeClickable(notifications_submenu));
		Thread.sleep(1000);
		notifications_submenu.click();
	}

	public void clickOnNewNotificationBtn() {
		System.out.println(driver.getWindowHandles());
		new_notification.click();
	}

	public void switchToWindow(String value) {
		Set<String> winhandle = driver.getWindowHandles();
		Iterator<String> iterator = winhandle.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		System.out.println("Parent : " + parentwindow + " | Child : " + childwindow);
		if (value.equalsIgnoreCase("parent")) {
			driver.switchTo().window(parentwindow);
		}
		if (value.equalsIgnoreCase("child")) {
			driver.switchTo().window(childwindow);
		}
	}

	public void fillNotificationSubject(String value) {
		subwin_subject_textarea.sendKeys(value);
	}

	public void fillNotificationDetails(String value) {
		subwin_details_textarea.sendKeys(value + " = " + LocalDateTime.now());
	}

	public void clickOnNextBtn() {
		subwin_next_btn.click();
	}

	public void selectAcademic() {
		subwin_acad_radiobtn.click();
	}

	public void selectParentsAudience() {
		subwin_parentsaudience.click();
	}

	public void selectStudentsAudience() {
		subwin_studentsaudience.click();
	}

	public void selectStaffAudience() {
		subwin_staffaudience.click();
	}

	public void clickOnSaveBtn() {
		subwin_save_btn.click();
	}

	public void clickOnCloseBtn() {
		subwin_close_btn.click();
	}

	public void clickOnSendNotificationBtn() {
		subwin_sendnotification_btn.click();
	}

	public void acceptSendNotificationAlert() {
		Alert sendnotif_alert = driver.switchTo().alert();
		sendnotif_alert.accept();
	}

	public void dismissNotificationAlert() {
		Alert sendnotif_alert = driver.switchTo().alert();
		sendnotif_alert.dismiss();
	}

	public void selectCategory(String value) {
		subwin_category_ddn.click();
		if (value.equalsIgnoreCase("Academic")) {
			driver.findElement(By.xpath("//ul[@id='customCatList']/li/span[text()='Academic']")).click();
		} else if (value.equalsIgnoreCase("Activities")) {
			driver.findElement(By.xpath("//ul[@id='customCatList']/li/span[text()='Activities']")).click();
		} else if (value.equalsIgnoreCase("Admin")) {
			driver.findElement(By.xpath("//ul[@id='customCatList']/li/span[text()='Admin']")).click();
		} else if (value.equalsIgnoreCase("Emergency")) {
			driver.findElement(By.xpath("//ul[@id='customCatList']/li/span[text()='Emergency']")).click();
		} else if (value.equalsIgnoreCase("General")) {
			driver.findElement(By.xpath("//ul[@id='customCatList']/li/span[text()='General']")).click();
		}
	}
}
