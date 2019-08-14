/**
 * 
 */
package cl.tecnova.cal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.cal.helpers.Helper;

/**
 * @author jlopez.ex
 *
 */
public class MoverTarjetaPage {
	
	
	
	//Atributos
			private WebDriver driver;     //Esto Siempre va ser igual para todo                                  //#Paso 1 
			private ExtentTest test;
			private Boolean TAKE_SS;
			private By clickpruebauto;
			private By mover;
			private By botonmover;
			private By cerrar;
			
		
			//Construcctor
					public MoverTarjetaPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
						
						//Esto Siempre va ser igual para todo
						this.driver = driver; 	
						this.test = test;
						this.TAKE_SS = TAKE_SS;
						//Esto Siempre va ser igual para todo
						this.clickpruebauto = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/a/div[1]");
						this.mover = By.xpath("//span[contains(.,'Mover')]");
						this.botonmover = By.xpath("//input[@class='primary wide js-submit']");
						this.cerrar = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/a");
						
								}
			public void MoverTarjeta(String subDir ){
				driver.findElement(clickpruebauto).click();
				Helper.waitSeconds(3);
				driver.findElement(mover).click();
				Helper.waitSeconds(2);
				
				Select selector = new Select(driver.findElement(By.xpath("//select[contains(@class,'js-select-list')]"))); // con esto seleccionamos los comboxbox
				selector.selectByVisibleText("Proceso");// con esto seleccionamos los comboxbox
				Helper.waitSeconds(1);
				driver.findElement(botonmover).click();
				Helper.waitSeconds(1);

				Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Mover Tarjeta", subDir, "MoverTarjeta");		

				Helper.waitSeconds(1);
				driver.findElement(cerrar).click();

			}
	
	
	
}