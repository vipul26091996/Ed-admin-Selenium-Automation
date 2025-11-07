package objectrepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillsPayablePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@title='Add new Bill']")
	WebElement addnewbill;

	@FindBy(xpath = "//div[@title='Select a Global Report']")
	WebElement globalreport_icon;

	@FindBy(xpath = "//div[@id='PrintDropdown']//div[text()='Aged Supplier Balance Report (1)']")
	WebElement agedbalancesupplier_report;

	@FindBy(xpath = "//form[@name='frmMain']/select[@name='Type']")
	WebElement suppliercategory_ddn;

	@FindBy(xpath = "//input[@value='Show']")
	WebElement show_btn;

	public BillsPayablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewBillIcon() {
		addnewbill.click();
	}

	public void switchToChildWin() {
		Set<String> win_handle = driver.getWindowHandles();
		Iterator<String> iterate = win_handle.iterator();
		String parent_win = iterate.next();
		String child_win = iterate.next();
		driver.switchTo().window(child_win);
	}

	public void clickOnGlobalReportIcon() {
		globalreport_icon.click();
	}

	public void selectAgedSupplierBalanceReport() {
		agedbalancesupplier_report.click();
	}

	public boolean verifyOptionAvailable(String option) {
		boolean available = false;
		Select select = new Select(suppliercategory_ddn);
		List<WebElement> alloptions = select.getOptions();
		for (WebElement e : alloptions) {
			String value = e.getDomAttribute("value");
			if (value.equalsIgnoreCase(option)) {
				available = true;
			}
		}
		System.out.println("Available value is : " + available);
		return available;
	}

	public boolean verifyOptionSelectable(String option) {
		boolean selectable = false;
		Select select = new Select(suppliercategory_ddn);
		select.selectByValue(option);
		WebElement value = select.getFirstSelectedOption();
		if (value.isSelected()) {
			selectable = true;
		}
		System.out.println("Selectable value is : " + selectable);
		return selectable;
	}

	public void clickOnShowBtn() {
		show_btn.click();
	}
}
