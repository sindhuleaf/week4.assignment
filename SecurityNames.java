/*1. Launch the URL https://www.chittorgarh.com/
2. Click on stock market
3. Click on NSE bulk Deals
4. Get all the Security names
5. Ensure whether there are duplicate Security names*/

package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecurityNames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Launch the URL https://www.chittorgarh.com/

		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on stock market

		driver.findElement(By.id("navbtn_stockmarket")).click();

		// Click on NSE bulk Deals

		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

		// Number of rows including header

		int rowsize = driver.findElements(By.xpath("//table//tbody//tr")).size();
		System.out.println("No of rows " + rowsize);

		// Number of Columns

		int colsize = driver.findElements(By.xpath("//table//thead//tr//th")).size();
		System.out.println("No of Column " + colsize);

		/* Printing the rows and Columns value
		for (int i = 1; i < rowsize; i++) // when i<=rowsize got NoSuchElementException
		{
			for (int j = 1; j <= colsize; j++) {
				System.out.println(
						driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]")).getText());
			}
		}*/

		// Get all the Security names
		System.out.println("Security Names are as follows");
		for (int i = 1; i < rowsize; i++) // when i<=rowsize got NoSuchElementException
		{
			for (int j = 3; j <= 3; j++) {

				System.out.println(
						driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]")).getText());

			}

		}

		// converted to List first
		
		List<String> nameList = new ArrayList<String>();

		// Ensure whether there are duplicate Security names(converted to Set which not allow duplicates)

		Set nameSet = new HashSet(nameList);
		int setsize = nameSet.size();
		System.out.println("No. of Security names without duplicates : " + setsize);
		if (nameSet.size() < nameList.size()) 
		{
			System.out.println("Duplicates are available in the list");
		} else {
			System.out.println("No Duplicates in the list");
		}

	}

}