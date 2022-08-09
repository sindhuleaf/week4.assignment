//https://jqueryui.com/sortable
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Open //https://jqueryui.com/sortable
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        //switch to frame
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(ele);
		
		//Perform action
		WebElement item1 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[1]"));
		WebElement item2 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[2]"));
		WebElement item3 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[3]"));
		WebElement item4 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[4]"));
		WebElement item5 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[5]"));
		WebElement item6 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[6]"));
		WebElement item7 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[7]"));
		Point location1=item1.getLocation();
		int x1=location1.getX();
		int y1=location1.getY();
		Point location7=item7.getLocation();
		int x7=location7.getX();
		int y7=location7.getY();
		Point location6=item6.getLocation();
		int x6=location6.getX();
		int y6=location6.getY();
		Point location5=item5.getLocation();
		int x5=location5.getX();
		int y5=location5.getY();
		Point location4=item4.getLocation();
		int x4=location4.getX();
		int y4=location4.getY();
		Point location3=item3.getLocation();
		int x3=location3.getX();
		int y3=location3.getY();
		Point location2=item2.getLocation();
		int x2=location2.getX();
		int y2=location2.getY();
		Actions action=new Actions(driver);
		action.clickAndHold(item7).dragAndDropBy(item1,x1,y1).release().perform();
		action.clickAndHold(item6).dragAndDropBy(item1,x1,y1).release().perform();
		action.clickAndHold(item5).dragAndDropBy(item1,x1,y1).release().perform();
		action.clickAndHold(item4).dragAndDropBy(item1,x1,y1).release().perform();
		action.clickAndHold(item3).dragAndDropBy(item1,x1,y1).release().perform();
		action.clickAndHold(item2).dragAndDropBy(item1,x1,y1).release().perform();
	}

}