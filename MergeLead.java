package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		 //Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		 //Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		 //Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 
		 //Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//WindowHandles
		Set<String> window1=driver.getWindowHandles();
		List<String> wd1=new ArrayList(window1);
		driver.switchTo().window(wd1.get(1));
				
		//Click on First Resulting Contact(second Window)
		driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]//a)[1]")).click();
		
		 //Click on Widget of To Contact(first window)
		driver.switchTo().window(wd1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//WindowHandles
		Set<String> window2=driver.getWindowHandles();
		List<String> wd2=new ArrayList(window2);
		driver.switchTo().window(wd2.get(1));
		
		 //Click on Second Resulting Contact(second window)
		driver.findElement(By.xpath("(//div[contains(@class,'col-partyId')]//a)[2]")).click();
		
		 //Click on Merge button using Xpath Locator(first window)
		driver.switchTo().window(wd2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		 //Accept the Alert
		driver.switchTo().alert().accept();
		 
		 //Verify the title of the page
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectTitle="View Contact | opentaps CRM";
		if(actualTitle.equals(expectTitle)) {
			System.out.println("Same title");
		}else
			System.out.println("Different title");
	}

}