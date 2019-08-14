/**
 * 
 */
package cl.tecnova.cal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.cal.helpers.Helper;

/**
 * @author jlopez.ex
 *
 */
public class EditarTarjetaPage {

	
	//Atributos
		private WebDriver driver; // EstSo Siempre va ser igual para todo 
		private By clickcrearuntablero;
		private By agregartitulo;
		private By creartablero;
		
		
		//Construcctor
				public EditarTarjetaPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
					
					this.driver = driver; 	//Esto Siempre va ser igual para todo
					this.clickcrearuntablero = By.xpath("//div[@class='board-tile mod-add']");
					this.agregartitulo = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/div/div/div[1]/input");
					this.creartablero = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/button");
							}
		public void EditarTarjeta(String subDir){
			driver.findElement(clickcrearuntablero).click();
			Helper.waitSeconds(1);
			driver.findElement(agregartitulo).sendKeys("Soy Un Nuevo Tablero");
			Helper.waitSeconds(1);
			driver.findElement(creartablero).click();
			Helper.waitSeconds(5);
		}

	
	
}
