//http://www.leafground.com/pages/table.html
package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// url http://www.leafground.com/pages/table.html

		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Row size

		int rowsize = driver.findElements(By.xpath("//table//tbody//tr")).size();
		System.out.println("No of rows: " + rowsize);

		// coloumn size
		int colsize = driver.findElements(By.xpath("//table//tbody//tr/th")).size();
		System.out.println("No of Columns :" + colsize);

		// Get the progress value of 'Learn to interact with Elements'

		System.out.println("Progress value of Learn to interact with Elements:");
		List<String> data = new ArrayList<String>();
		for (int i = 2; i <= 4; i++) {
			for (int j = 2; j < colsize; j++)

			{

				System.out.println(driver.findElement(By.xpath("//table//tr[" + i + "]/td[" + j + "]")).getText());

			}
			System.out.println();
		}

		// Check the vital task for the least completed progress.
		System.out.println("Converted to List ");
		List<String> list = new ArrayList<String>();
		for (int k = 2; k <=rowsize; k++) {
			for (int l = 2; l < colsize; l++) {
		String value1 = driver.findElement(By.xpath("//table//tr["+k+"]/td["+l+"]")).getText();
		list.add(value1);
		System.out.println(value1);
		
	
	}
	
}
		Set<String> set = new TreeSet<String>(list);
		System.out.println("After sort: " + set);
		for (String output : set) {
			if (output.contentEquals("20%")) {
				driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();

			}
		}
	}
}