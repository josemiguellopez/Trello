/**
 * 
 */
package cl.tecnova.cal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import cl.tecnova.cal.helpers.Helper;

/**
 * @author jlopez.ex
 *
 */
public class CrearTableroPage {
		
	//Atributos
	private WebDriver driver; // EstSo Siempre va ser igual para todo 
	private ExtentTest test;
	private Boolean TAKE_SS;
	private By clickcrearuntablero;
	private By agregartitulo;
	private By creartablero;
	
	//Atributos_Asserts
	private By validaciontablerocreado;

	
	
	//Construcctor
	public CrearTableroPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
				
	this.driver = driver; 	//Esto Siempre va ser igual para todo
	this.test = test;
	this.TAKE_SS = TAKE_SS;
	this.clickcrearuntablero = By.xpath("//div[@class='board-tile mod-add']");
	this.agregartitulo = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/div/div/div[1]/input");
	this.creartablero = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/button");
	
	//Constructor_Assert
	this.validaciontablerocreado = By.xpath("//span[contains(.,'Tablero de Jose de Prueba')]");

	
	
	}
	
	//Metodos
	public void CrearTablero(String subDir){
		driver.findElement(clickcrearuntablero).click();
		Helper.waitSeconds(1);
		driver.findElement(agregartitulo).sendKeys("Tablero de Jose de Prueba");
		Helper.waitSeconds(2);
		driver.findElement(creartablero).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Nombre Tablero ", subDir, "NuevoTableritoNombre");	
		Helper.waitSeconds(3);
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Tablero Creado ", subDir, "NuevoTableritoCreado");		
		Helper.waitSeconds(4);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void assertCrearTableroValidacion() { //metodo para validar ingreso correcto      //#Paso 5 	
		Assert.assertTrue(driver.findElement(validaciontablerocreado).getText().equals("Tablero de Jose de Prueba"));

		}
}
