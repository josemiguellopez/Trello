package cl.tecnova.qa.curso_de_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		
		//configurar driver chrome
		System.setProperty("webdriver.chrome.driver", "DRIVERS/chromedriver.exe");
		WebDriver driver  = new ChromeDriver(); 
		//driver.get("https://www.google.com");
		driver.navigate().to("https://www.google.com");
		//driver.close();
//
	}

}
