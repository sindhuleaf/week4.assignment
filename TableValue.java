/*1. Launch the URL https://html.com/tags/table/
2.You have to print the respective values based on given Library
(hint: if the library  was absolute usage, then print all its value)*/
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableValue {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Launch the URL https://html.com/tags/table/

		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		// Get the count of number of rows(1st table)

		int rowsize1 = driver.findElements(By.xpath("//div[@class=\"render\"]//table//tbody/tr")).size();//doubt
		System.out.println("No of rows for 1st table :" + rowsize1);

		// Get the count of number of columns(1st table)

		int colsize1 = driver.findElements(By.xpath("//div[@class=\"render\"]//table//thead//tr//th")).size();
		System.out.println("No of Coloumns for 1st table :" + colsize1);
		
		//You have to print the respective values based on given Library
		//(hint: if the library  was absolute usage, then print all its value)
		
		for(int i=2;i<=rowsize1;i++)
		{
			for (int j = 1; j <= colsize1; j++) 
			{
				System.out.print(driver.findElement(By.xpath("//div[@class=\"render\"]//tbody//tr[" + i + "]//td[" + j + "]")).getText()+ "  ");
		    } 
	     }
		
		
	}

}