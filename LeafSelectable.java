//https://jqueryui.com/selectable
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafSelectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Open //https://jqueryui.com/selectable
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//switch to outerframe
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(ele);
		
		//perform action on item1 and item6
		WebElement img1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement img6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		Actions action=new Actions(driver);
		action.moveToElement(img1).click().perform();
		action.moveToElement(img6).click().perform();
		
	}

}