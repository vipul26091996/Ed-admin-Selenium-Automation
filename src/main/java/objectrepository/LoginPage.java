package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// WebDriver driver;

	@FindBy(id = "nav-staff-tab")
	WebElement staff_tab;

	@FindBy(id = "nav-parent-tab")
	WebElement parent_tab;

	@FindBy(id = "nav-student-tab")
	WebElement student_tab;

	@FindBy(id = "nav-alumni-tab")
	WebElement alumni_tab;

	@FindBy(id = "UserID1")
	WebElement staffuserid_txtbox;

	@FindBy(id = "Pass1")
	WebElement staffpwd_txtbox;

	@FindBy(xpath = "//div[@id='nav-staff']//descendant::button[text()='Login']")
	WebElement stafflogin_btn;

	@FindBy(xpath = "//div[@id='nav-parent']//descendant::button[text()='Login']")
	WebElement parentlogin_btn;

	@FindBy(xpath = "//div[@id='nav-student']//descendant::button[text()='Login']")
	WebElement studentlogin_btn;

	@FindBy(xpath = "//div[@id='nav-alumni']//descendant::button[text()='Login']")
	WebElement alumnilogin_btn;

	@FindBy(className = "login_code")
	WebElement loginwithcodeinstead_link;

	@FindBy(className = "forget_pass")
	WebElement forgotpwd_link;

	@FindBy(xpath = "//input[@id='Pass1']//following-sibling::img")
	WebElement showstaffpwd_icon;

	@FindBy(xpath = "//input[@id='Pass2']//following-sibling::img")
	WebElement showparentpwd_icon;

	@FindBy(xpath = "//input[@id='Pass3']//following-sibling::img")
	WebElement showstudentpwd_icon;

	@FindBy(xpath = "//input[@id='Pass4']//following-sibling::img")
	WebElement showalumnipwd_icon;

	@FindBy(id = "UserID2")
	WebElement parentuserid_txtbox;

	@FindBy(id = "Pass2")
	WebElement parentpwd_txtbox;

	@FindBy(id = "UserID3")
	WebElement studentuserid_txtbox;

	@FindBy(id = "Pass3")
	WebElement studentpwd_txtbox;

	@FindBy(id = "UserID4")
	WebElement alumniuserid_txtbox;

	@FindBy(id = "Pass4")
	WebElement alumnipwd_txtbox;

	public LoginPage(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectStaffTab() {
		String staffselected = staff_tab.getDomAttribute("aria-selected");
		if (staffselected.equalsIgnoreCase("false")) {
			staff_tab.click();
		}
	}

	public void enterUserID(String user_id) {
		staffuserid_txtbox.sendKeys(user_id);
	}

	public void enterPassword(String user_pwd) {
		staffpwd_txtbox.sendKeys(user_pwd);
	}

	public void clickLogin() {
		try {
			if (staff_tab.getDomAttribute("aria-selected").equalsIgnoreCase("true")) {
				stafflogin_btn.click();
			} else if (parent_tab.getDomAttribute("aria-selected").equalsIgnoreCase("true")) {
				parentlogin_btn.click();
			} else if (student_tab.getDomAttribute("aria-selected").equalsIgnoreCase("true")) {
				studentlogin_btn.click();
			} else if (alumni_tab.getDomAttribute("aria-selected").equalsIgnoreCase("true")) {
				alumnilogin_btn.click();
			}
		} catch (Exception e) {
			System.out.println("login try catch error");
		}
	}
}
