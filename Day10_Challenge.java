import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_Challenge {
    // Method to get the number of lower case letters in a string
	public static int getLowerCaseCharCount(String str) {
		int count=0;
		for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) >='a' && str.charAt(i)<='z') {
					count++;	
				}
		}
		return count;
	}
	
	// Method to get a string with maximum number of lowercase letters from a given list 
	public static String getChracterCountList(List<WebElement> strList) {
		int maxCount=0;
		int characterCount=0;
		String lowerCaseStr = null;
		for (int i = 0; i < strList.size(); i++) {
			
			characterCount = getLowerCaseCharCount(strList.get(i).getText());
			if(characterCount>maxCount) {
				maxCount=characterCount;
				lowerCaseStr = strList.get(i).getText();
			}
		}
		System.out.println("No of smallcase letters:"+ maxCount);
		System.out.println("String:" + lowerCaseStr);
		return lowerCaseStr;
		
	}
	
	// Method to check if the discount is sorted from highest to lowest
	public static boolean checkDiscountSort(List<WebElement> discountList) {
		boolean result = true;
		for (int j = 0; j < discountList.size(); j++) {
			String discountText = discountList.get(j).getText();
			int discountPercentage = Integer.parseInt(discountText.replaceAll("\\D", ""));
			System.out.println(discountPercentage);
			int checkValue = discountPercentage;
			int value = checkValue-discountPercentage;
			if(value<0)
				result = false;
		}
		return result;
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// 1. Launch chromeBrowser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 2. Go to https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement webWomen = driver.findElement(By.linkText("WOMEN"));
		//3. Mouse over on WOMEN
		Actions build = new Actions(driver);
		build.moveToElement(webWomen).perform();
		//4, Mouse over on BRANDS
		WebElement webBrands = driver.findElement(By.linkText("BRANDS"));
		build.moveToElement(webBrands).perform();
		//5. Click the link that has maximum number of lower case letters
		List<WebElement> webTextList = driver.findElementsByXPath("(//div[@class='menu-lsec menu-lsec-full-width '])[4]//div [@class='items'] //span");
	//	System.out.println(webTextList.size());
		String lowerCaseString = getChracterCountList(webTextList);
		driver.findElementByLinkText(lowerCaseString).click();
		//6. Print and store the number of items
		String items = driver.findElementByXPath("//div[@class='length']").getText();
		int itemValue = Integer.parseInt(items.replaceAll("\\D", ""));
		System.out.println("No of items:"+ itemValue);
		//7. Expand Size and Fit and choose S
		WebElement webSizeandFit = driver.findElementByXPath("//span[text()='size & fit']");
		js.executeScript("arguments[0].click()", webSizeandFit);
		driver.findElementByXPath("//label[@for='S']").click();
		Thread.sleep(1000);
		//8. Confirm that the number of items have reduced
		String itemsS = driver.findElementByXPath("//div[@class='length']").getText();
		int itemValue1 = Integer.parseInt(itemsS.replaceAll("\\D", ""));
	//	System.out.println("No of items:"+ itemValue1);
		if(itemValue>itemValue1)
			System.out.println("Items reduced");
		//9. Sort by Discount
		WebElement discountSort = driver.findElementByXPath("//div[@class='filter-dropdown']//select[1]");
		Select drpDwn = new Select(discountSort);
		drpDwn.selectByVisibleText("Discount");
		//10. Confirm if the results are sorted by higher discount first
		List<WebElement> WebDiscount = driver.findElementsByXPath("//span[@class='discount']");
		boolean isDiscountSorted = checkDiscountSort(WebDiscount);
		if (isDiscountSorted){
			System.out.println("Yes, the results are sorted by higher discount first");
		}
	}
}
