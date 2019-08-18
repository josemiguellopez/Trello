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
	
	
	//Atributos Eliminar Tablero
	private By btnmas;
	private By cerrar;
	private By cerrar2;
	private By cerrar3;
	private By cerrar4;
	
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
	
	
	//Constructor Eliminar Tablero
	
	this.btnmas = By.xpath("//a[contains(.,'Más')]");
	this.cerrar = By.xpath("//a[contains(.,'Cerrar tablero...')]");
	this.cerrar2 = By.xpath("//input[@value='Cerrar']");
	this.cerrar3 = By.xpath("//a[contains(.,'Eliminar el tablero de forma permanente...')]");
	this.cerrar4 = By.xpath("//input[@value='Eliminar']");
	
	
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
	
	public void EliminarTablero(String subDir) {
		Helper.waitSeconds(1);
		driver.findElement(btnmas).click();
		Helper.waitSeconds(1);
		driver.findElement(cerrar).click();
		Helper.waitSeconds(1);
		driver.findElement(cerrar2).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Cerrar Tablero", subDir, "CerrarTablero");
		Helper.waitSeconds(1);
		
		driver.findElement(cerrar3).click();
		Helper.waitSeconds(1);
		driver.findElement(cerrar4).click();
		Helper.waitSeconds(1);

		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Tablero Eliminado", subDir, "TableroEliminado");



	}

	
	
	
	
	
	
		public void assertCrearTableroValidacion() { //metodo para validar ingreso correcto      //#Paso 5 	
		Assert.assertTrue(driver.findElement(validaciontablerocreado).getText().equals("Tablero de Jose de Prueba"));

		}
		
		
		
}
