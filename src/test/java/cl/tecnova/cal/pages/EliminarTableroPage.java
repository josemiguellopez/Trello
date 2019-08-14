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
public class EliminarTableroPage {

	private WebDriver driver; // EstSo Siempre va ser igual para todo 
	private ExtentTest test;
	private Boolean TAKE_SS;
	private By btnmas;
	private By cerrar;
	private By cerrar2;
	private By cerrar3;
	private By cerrar4;
	
	
	
	//Construcctor
	public EliminarTableroPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		
		this.driver = driver; 	//Esto Siempre va ser igual para todo
		this.test = test;
		this.TAKE_SS = TAKE_SS;
		this.btnmas = By.xpath("//a[contains(.,'Más')]");
		this.cerrar = By.xpath("//a[contains(.,'Cerrar tablero...')]");
		this.cerrar2 = By.xpath("//input[@value='Cerrar']");
		this.cerrar3 = By.xpath("//a[contains(.,'Eliminar el tablero de forma permanente...')]");
		this.cerrar4 = By.xpath("//input[@value='Eliminar']");
		
		
}		//Metodo
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
	
	
	
}
