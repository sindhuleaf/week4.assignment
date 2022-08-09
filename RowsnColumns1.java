/*1. Launch the URL https://html.com/tags/table/
2. Get the count of number of rows
3. Get the count of number of columns*/
package week4.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsnColumns1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Launch the URL https://html.com/tags/table/

		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Get the count of number of rows(1st table)

		int rowsize1 = driver.findElements(By.xpath("//div[@class='render']//table//tr")).size();
		System.out.println("No of rows for 1st table :" + rowsize1);

		// Get the count of number of columns(1st table)

		int colsize1 = driver.findElements(By.xpath("//div[@class='render']//table//tr//th")).size();
		System.out.println("No of Coloumns for 1st table :" + colsize1);

		// Get the count of number of rows(2nd table)

		int rowsize2 = driver.findElements(By.xpath("//table[@class=\"attributes-list\"]//tbody//tr")).size();
		System.out.println("No of Rows for 2nd Table :" + rowsize2);

		// Get the count of number of columns(2nd table)

		int colsize2 = driver.findElements(By.xpath("//table[@class=\"attributes-list\"]//tbody//tr//th")).size();
		System.out.println("No of Coloumns for 2nd table :" + colsize2);

	}

}