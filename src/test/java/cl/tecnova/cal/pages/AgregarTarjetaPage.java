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
public class AgregarTarjetaPage {

			private WebDriver driver; // EstSo Siempre va ser igual para todo 
			private ExtentTest test;
			private Boolean TAKE_SS;
			
			//Atributos para Abrir Tablero
			private By abrirTablero;

			//Atributos para Agregar Tarjeta
			private By nombredelista;
			private By agregarnombredelista;
			private By botonagregarnombrelista;
			private By agregartarjeta;
			private By titulodetarjeta;
			private By botonagregartarjeta;			
			private By titulootratarjeta;
			private By botonagregarotro;
			
			//Assert
			private By validaicontarjeta;

			
	
			public AgregarTarjetaPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
				
			this.driver = driver; 	//Esto Siempre va ser igual para todo
			this.test = test;
			this.TAKE_SS = TAKE_SS;
			
			//Constructor Para Abrir Tablero

			this.abrirTablero = By.partialLinkText("Tablero de Jose de Prueba");

					
			//Construcctor para Agregar Tarjeta

			this.nombredelista = By.xpath("//*[@id=\"board\"]/div/form/a");
			this.agregarnombredelista= By.xpath("//*[@id=\"board\"]/div/form/input");
			this.botonagregarnombrelista = By.xpath("//input[@type='submit']");
			this.agregartarjeta = By.xpath("//span[@class='js-add-a-card']");
			this.titulodetarjeta = By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']");
			this.botonagregartarjeta = By.xpath("//input[@class='primary confirm mod-compact js-add-card']");				
			this.titulootratarjeta = By.xpath("//input[@name='name']");
			this.botonagregarotro = By.xpath("//input[@value='Añadir lista']");
			
			//Assert
			this.validaicontarjeta = By.xpath("//span[contains(.,'Añada una lista')]");

									
			}	
			
			//Metodo Para Abrir Tablero

			public void abrirTablero(String subDir) {
			Helper.waitSeconds(1);
			driver.findElement(abrirTablero).click();
			Helper.waitSeconds(2);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Acceso Tablero Creado", subDir, "TableroCreado");		
			Helper.waitSeconds(4);
			}
			
			
			//Metodo Para Agregar Tarjeta
			public void AgregarTarjeta(String subDir) {
			Helper.waitSeconds(3);
			driver.findElement(nombredelista).click();
			Helper.waitSeconds(2);
			driver.findElement(agregarnombredelista).sendKeys("Lista de Prueba");
			Helper.waitSeconds(1);
			driver.findElement(botonagregarnombrelista).click();
			driver.findElement(agregartarjeta).click();
			driver.findElement(titulodetarjeta).sendKeys("Prueba Automatizada");
			Helper.waitSeconds(1);
			driver.findElement(botonagregartarjeta).click();
			Helper.waitSeconds(2);
			driver.findElement(titulootratarjeta).sendKeys("Proceso");
			driver.findElement(botonagregarotro).click();
			Helper.waitSeconds(1);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Tarjeta", subDir, "AgregarTarjeta");
			Helper.waitSeconds(2);
			}
	
			public void assertAgregarNuevaTarjetaValidacion() { //metodo para validar agregar tarjeta 	
			Assert.assertTrue(driver.findElement(validaicontarjeta).getText().equals("Añada una lista"));
				}
	}
