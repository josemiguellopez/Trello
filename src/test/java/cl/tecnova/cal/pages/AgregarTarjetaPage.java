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
			
			//Atributos Crear Tablero
			
			private By clickcrearuntablero;
			private By agregartitulo;
			private By creartablero;
			
			
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
			
			//Atributos Eliminar Tablero
			private By btnmas;
			private By cerrar;
			private By cerrar2;
			private By cerrar3;
			private By cerrar4;
			
			
			//Assert
			private By validaicontarjeta;
			private By validaciontablerocreado;
	
			public AgregarTarjetaPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
				
			this.driver = driver; 	//Esto Siempre va ser igual para todo
			this.test = test;
			this.TAKE_SS = TAKE_SS;
			
			//costructor crear tablero
			
			this.clickcrearuntablero = By.xpath("//div[@class='board-tile mod-add']");
			this.agregartitulo = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/div/div/div[1]/input");
			this.creartablero = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/div/form/button");	
			
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
			
			//Constructor Eliminar Tablero	
			this.btnmas = By.xpath("//a[contains(.,'Más')]");
			this.cerrar = By.xpath("//a[contains(.,'Cerrar tablero...')]");
			this.cerrar2 = By.xpath("//input[@value='Cerrar']");
			this.cerrar3 = By.xpath("//a[contains(.,'Eliminar el tablero de forma permanente...')]");
			this.cerrar4 = By.xpath("//input[@value='Eliminar']");	
			
			
			//Assert
			this.validaicontarjeta = By.xpath("//span[contains(.,'Añada una lista')]");
			this.validaciontablerocreado = By.xpath("//span[contains(.,'Tablero de Jose de Prueba')]");						
			}	
			
			//Metodo Crear Tablero

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
			
			
			
			
			
			//Metodo Para Abrir Tablero

			public void abrirTablero(String subDir) {
			Helper.waitSeconds(1);
			driver.findElement(abrirTablero).click();
			Helper.waitSeconds(2);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Acceso Tablero Creado", subDir, "TableroCreado");		
			Helper.waitSeconds(4);
			}
			
			
			//Metodo Para Agregar Tarjeta
			public void AgregarTarjetaListaPrueba(String subDir) {
			Helper.waitSeconds(3);
			driver.findElement(nombredelista).click();
			Helper.waitSeconds(2);
			driver.findElement(agregarnombredelista).sendKeys("Lista de Prueba");
			Helper.waitSeconds(1);
			driver.findElement(botonagregarnombrelista).click();
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Tarjeta Lista de Prueba", subDir, "AgregarTarjetaListaPrueba");

			}
			//Metodo Para Agregar Prueba Automatizada

			public void AgregarTarjetaPruebaAutomatizada(String subDir) {
			driver.findElement(agregartarjeta).click();
			driver.findElement(titulodetarjeta).sendKeys("Prueba Automatizada");
			Helper.waitSeconds(1);
			driver.findElement(botonagregartarjeta).click();
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Tarjeta Prueba Automatizada", subDir, "AgregarTarjetaListaPruebaAutomatizada");
			Helper.waitSeconds(2);
			}
			//Metodo Para Agregar Tarjeta Proceso

			public void AgregarTablaProceso(String subDir) {
			driver.findElement(titulootratarjeta).sendKeys("Proceso");
			driver.findElement(botonagregarotro).click();			
			Helper.waitSeconds(1);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Lista Proceso", subDir, "AgregarTarjeta Proceso");
			Helper.waitSeconds(2);
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
			
			
			public void assertAgregarNuevaTarjetaValidacion() { //metodo para validar agregar tarjeta 	
			Assert.assertTrue(driver.findElement(validaicontarjeta).getText().equals("Añada una lista"));
				}
	}
