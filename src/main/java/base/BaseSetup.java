package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	public static WebDriver driver;
	public static FileReader setupfr;
	public static Properties setupprop = new Properties();
	public static WebDriverWait explicitwait;

	@BeforeClass
	public static void setup() throws IOException {

		if (driver == null) {
			setupfr = new FileReader(
					System.getProperty("user.dir") + "\\src\\main\\resources\\PropertyFile\\basesetup.properties");
			setupprop.load(setupfr);

		}
		if (setupprop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-save-password-bubble");
			options.setExperimentalOption("prefs", new HashMap<String, Object>() {
				{
					put("credentials_enable_service", false);
					put("profile.password_manager_enabled", false);
				}
			});
			driver = new ChromeDriver(options);
		} else if (setupprop.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		explicitwait = new WebDriverWait(driver, Duration.ofMinutes(2));
		driver.get(setupprop.getProperty("url"));
		System.out.println("Base Setup Successful");

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
		System.out.print("Tear Down Successful");
	}

}
