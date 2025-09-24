package objectrepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ParentRecordsPage {

	WebDriver driver;

	@FindBy(xpath = "//ul[@id='main_ul']")
	WebElement square_icon;

	@FindBy(xpath = "//a[@id='nav_436']")
	WebElement setup_menu;

	@FindBy(xpath = "//a[@id='nav_437']")
	WebElement customfields_menu;

	@FindBy(xpath = "//input[@id='newtabname']")
	WebElement newtab_field;

	WebElement newfield_textbox;

	@FindBy(xpath = "//*[@id='scroll-style']/div/div[3]/table/tbody/tr/td[2]/select")
	WebElement selectfieldtype_ddn;

	@FindBy(xpath = "//*[@id='scroll-style']/div/div[3]/table/tbody/tr[2]/td[1]/input")
	WebElement textfield;

	@FindBy(xpath = "//*[@id='scroll-style']/div/div[3]/table/tbody/tr[2]/td[2]/select")
	WebElement texttype_ddn;

	@FindBy(xpath = "//input[@id='save']")
	WebElement save_btn;

	public ParentRecordsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMenu() {
		square_icon.click();
	}

	public void openCustomeFieldsMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(setup_menu).moveToElement(customfields_menu).click().perform();
	}

	public void clickOnNewTabField() {
		newtab_field.click();
	}

	public void renameTab() {
		LocalDate tod_date = LocalDate.now();
		DateTimeFormatter format_date = DateTimeFormatter.ofPattern("dd MMM");
		String date = tod_date.format(format_date);
		Actions action = new Actions(driver);
		action.click(newtab_field);
		newtab_field.sendKeys("QA Tab" + date);
		newtab_field.sendKeys(Keys.ENTER);
	}

	public void enterFieldName() {

		int count = 1;
		try {
			for (int i = 2;; i++) {
				if (driver
						.findElement(By.xpath("//*[@id='scroll-style']/div/div[" + i + "]/table/tbody/tr/td[1]/input"))
						.isDisplayed()) {
					count++;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("Count is : " + count);
		newfield_textbox = driver
				.findElement(By.xpath("//*[@id='scroll-style']/div/div[" + count + "]/table/tbody/tr/td[1]/input"));
		System.out.println(newfield_textbox);
		newfield_textbox.sendKeys("Section 1");
	}

	public void selectFieldType() {
		Select select = new Select(selectfieldtype_ddn);
		select.selectByContainsVisibleText("Section");
	}

	public void enterTextField() {
		textfield.sendKeys("QA Field");
	}

	public void selectTextFieldType() {
		Select select = new Select(texttype_ddn);
		select.selectByContainsVisibleText("Text 100");
	}

	public void clickSave() {
		save_btn.click();
	}

}
