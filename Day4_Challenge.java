import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4_Challenge {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(options);

		Capabilities cap = driver.getCapabilities();
		options.merge(cap);
		System.out.println("Edge Driver  version : "+ cap.getVersion());

		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement webChennai = driver.findElementByXPath("//input[@class='db']");
		webChennai.sendKeys("Chennai");
		Thread.sleep(1000);
		webChennai.sendKeys(Keys.TAB);
		Thread.sleep(1000);
	    WebElement webBangalore = driver.findElementByXPath("(//input[@class='db'])[2]");
	    webBangalore.sendKeys("Bangalore");
	    Thread.sleep(1000);
	    webBangalore.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElementByXPath("(//input[@class='db'])[3]").click();
		driver.findElementByXPath("//button[text()='>']").click();
		LocalDate dt = LocalDate.now();
		int dayOfMonth = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)).plusDays(7).getDayOfMonth();
		driver.findElementByXPath("//td[text()='" + dayOfMonth + "']").click();
		driver.findElementById("search_btn").click();
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(0));

		String noOfBuses = driver.findElementByXPath("//span[@class='f-bold busFound']").getText();
		System.out.println("No. of buses:" + noOfBuses );
	}

}
