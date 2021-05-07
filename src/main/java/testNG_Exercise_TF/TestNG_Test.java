package testNG_Exercise_TF;



import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Test {
	
	
	WebDriver driver;

	@BeforeMethod
	public void stratBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://techfios.com/test/101/");
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void validUserSouldAbleToAddCatagory() throws InterruptedException {
	
		
		//  the category has been added and display.
		
			driver.findElement(By.cssSelector("input[name^='categorydata']")).sendKeys("QA AUTOMATION");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input[value$='Add category']")).click();
			
			
			boolean displayed = driver.findElement(By.xpath("//span[text()='QA AUTOMATION']")).isDisplayed();
			System.out.println("The Catagory should Display : "  + " " +  displayed);
			
		/*
			 User not able to add a duplicated category and message will display:
			"The category you want to add already exists: <duplicated category name>."
		*/
			Thread.sleep(1000);
			driver.findElement(By.linkText("Nevermind")).click();
			
			
			// all the months has been validate from the Due Date dropdown section.
			
			WebElement month = driver.findElement(By.name("due_month"));
			Select sel3 = new Select(month);
			
			
			 List<WebElement> dropdown_list = sel3.getOptions();
			 
			 for (int i = 1; i < dropdown_list.size(); i++) {

				   String dropdown_value = dropdown_list.get(i).getText();

				//   System.out.println("dropdown values are " +  dropdown_value);
				   System.out.println(dropdown_value);
				   
				   

				 }
		
	}


}
