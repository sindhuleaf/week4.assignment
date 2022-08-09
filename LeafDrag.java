//https://jqueryui.com/draggable
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDrag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Open //https://jqueryui.com/draggable
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to outerframe
        WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(ele);
        
       //perform drag action using getlocation
       WebElement ele1 = driver.findElement(By.xpath("//div[@id='draggable']"));
       Point location = ele1.getLocation();
       int x = location.getX();
       int y = location.getY();
       
       //Create object for Actions Class
         Actions action=new Actions(driver);
         action.dragAndDropBy(ele1, 100, 50).perform();
 	}
	}
