package choiceParamInJenkin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetChoiceParameterFromJenkin {
	WebDriver driver;
	@Test
	public void test() {
		String browsername=System.getProperty("BROWSERNAME");
		if(browsername.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("chrome browser is launched");
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("firefox browser is launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
