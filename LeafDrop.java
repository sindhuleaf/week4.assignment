//https://jqueryui.com/droppable
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Open //https://jqueryui.com/droppable
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//Switch to outer frame
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(ele);
		
		//Perform Drag and Drop
		WebElement src=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement trg=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(src,trg).perform();
		
	}

}
