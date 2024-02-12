package cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("driver.chromeDriver.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("btn-make-appointment")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		WebElement facilitySelection = driver.findElement(By.id("combo_facility"));
		Select facility = new Select(facilitySelection);
		Thread.sleep(2000);
		facility.selectByValue("Hongkong CURA Healthcare Center");
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.xpath("//input[@id='radio_program_none']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-calendar']")).click();
		Thread.sleep(2000);
		String expectedDatyear = "November 2023";
		WebElement navBack = driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[1]"));
		// System.out.println(datYear);
		while (true) {
			String datYear = driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
			if (expectedDatyear.equals(datYear)) {
				break;
			}
			else {
				navBack.click();
			}
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[5]/td[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Appointment for Nuerology Department");
		driver.findElement(By.id("btn-book-appointment")).click();
		String confirmation = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText();
		System.out.println(confirmation);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Go to Homepage")).click();
		
		//Side More Options
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.linkText("History")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
