import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6_Challenge {

	public static void main(String[] args) throws InterruptedException {
		int count = 0;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// 1. Launch the Incognito chrome browser
		options.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(options);
		// 2. Print the window dimensions
		System.out.println("Dimension of the window is:" + driver.manage().window().getSize());
		// 3. Goto "https://www.myntra.com"
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		// 4. In searchBox, enter sunglasses and hit enter
		driver.findElementByClassName("desktop-searchBar").sendKeys("Sunglasses", Keys.ENTER);
		// 5. In result page, filter the glasses with brand "poloroid"
		driver.findElementByClassName("brand-more").click();
		WebElement webPolaroid = driver.findElementByXPath("//input[@value='Polaroid']");

		Actions build = new Actions(driver);
		build.moveToElement(webPolaroid).click().perform();
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();
		// 6. Print the product size of 'Men Rectangle Glasses"
		WebElement webMenRectGlass = driver.findElementByXPath("(//h4[text()='Men Rectangle Sunglasses'])[1]");
		build.moveToElement(webMenRectGlass).perform();
		Thread.sleep(2000);
		String sizesL = driver
				.findElement(
						By.xpath("//div[@id='desktopSearchResults']/div[2]/section[1]/ul[1]/li[7]/a[1]/div[2]/h4[2]"))
				.getText();
		System.out.println("Size of the product :" + sizesL);

		WebElement webFirstProduct = driver.findElementByXPath("//ul[@class='results-base']//li[1]");
		build.moveToElement(webFirstProduct).perform();

		// 7. Move to the first element and view similar results
		Thread.sleep(2000);

		driver.findElementByXPath(
				"//span[@class='myntraweb-sprite image-grid-similarColorsIcon sprites-similarProductsIcon']").click();

		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(0));

		// 8. Find the number of similar items
		List<WebElement> similarItems = driver.findElementsByXPath("//li[@class='product-base']");
		for (WebElement webElement : similarItems) {
			count++;
		}
		System.out.println("Number of similar items: " + count);

	}
}
