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
public class EditarListaPage {
	
	//Atributos
		private WebDriver driver; // EstSo Siempre va ser igual para todo 
		private ExtentTest test;
		private Boolean TAKE_SS;
		private By clickpruebaautomatizada;
		private By clickdescripcion;
		private By descripcion;
		private By etiqueta;
		private By coloretiqueta;
		private  By cerraretiqueta;
		private By vencimiento;
		private By campofecha;
		private By campohora;
		private By guardar;
		private By agregarcomentario;
		private By adjunto;
		private By txtadjunto;
		private By adjuntar;
		private By guardarprueba;
		private By cerrar;


		
		
		//Construcctor
				public EditarListaPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
					
					this.driver = driver; 	//Esto Siempre va ser igual para todo
					this.test = test;
					this.TAKE_SS = TAKE_SS;
					this.clickpruebaautomatizada = By.xpath("//*[@id=\"board\"]/div[1]/div/div[2]/a[1]");
					this.clickdescripcion = By.xpath("//textarea[contains(@class,'field field-autosave js-description-draft description card-description')]");
					this.descripcion = By.xpath("//textarea[@placeholder='Añadir una descripción más detallada...']");
					this.etiqueta = By.xpath("//span[contains(.,'Etiquetas')]");
					this.coloretiqueta = By.xpath("//span[@data-color='green']");
					this.cerraretiqueta = By.xpath("//a[@class='pop-over-header-close-btn icon-sm icon-close']");
					this.vencimiento = By.xpath("//a[contains(.,'Vencimiento')]");
					this.campofecha = By.xpath("//input[@tabindex='101']");
					this.campohora = By.xpath("//input[@placeholder='Introducir la hora']");
					this.guardar = By.xpath("//input[@tabindex='103']");
					this.agregarcomentario = By.xpath("//textarea[@placeholder='Escriba un comentario...']");
					this.adjunto = By.xpath("//a[@title='Adjunto']");
					this.txtadjunto = By.xpath("//input[@placeholder='Pegue un vínculo aquí...']");
					this.adjuntar = By.xpath("//input[@value='Adjuntar']");
					this.guardarprueba = By.xpath("//input[contains(@class,'primary confirm mod-no-top-bottom-margin js-add-comment')]");
					this.cerrar = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/a");

					
					
					
					
					
							}
				
				
		public void TarjetaPruebaAutomatizada(String subDir) {
			Helper.waitSeconds(3);
			driver.findElement(clickpruebaautomatizada).click();
			Helper.waitSeconds(2);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Ingreso Prueba Automatizada", subDir, "IngresoPruebaAutomatizada");

					}
		public void Descripcion(String subDir) {
			driver.findElement(clickdescripcion).click();
			Helper.waitSeconds(1);
			driver.findElement(descripcion).sendKeys("Hola soy una descripcion automatizada");
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Descricpion", subDir, "AgregarDescripcion");

			Helper.waitSeconds(2);			
		}
		public void Etiqueta(String subDir) {
			driver.findElement(etiqueta).click();
			Helper.waitSeconds(1);
			driver.findElement(coloretiqueta).click();
			Helper.waitSeconds(1);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Etiqueta", subDir, "AgregarEtiqueta");

			driver.findElement(cerraretiqueta).click();
			Helper.waitSeconds(1);			
		}
		
		public void Vencimiento(String subDir) {
			
			driver.findElement(vencimiento).click();
			Helper.waitSeconds(1);
			driver.findElement(campofecha).sendKeys("31/08/2019");
			Helper.waitSeconds(1);
			driver.findElement(campohora).sendKeys("12:55");
			Helper.waitSeconds(1);
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Vencimiento", subDir, "AgregarVencimiento");

			driver.findElement(guardar).click();
			
		}
		
		public void ArchivoAdjunto(String subDir) {
			Helper.waitSeconds(1);
			driver.findElement(adjunto).click();
			driver.findElement(txtadjunto).sendKeys("https://avatarfiles.alphacoders.com/991/thumb-99177.jpg");
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Agregar Archivo Adjunto", subDir, "AgregarArchivoAdjunto");

			driver.findElement(adjuntar).click();
					
		}
		
							
		public void Comentarios(String subDir){
			
			
			driver.findElement(agregarcomentario).sendKeys("Hola, Soy un comentario automatizado ;)");
			Helper.waitSeconds(1);
			driver.findElement(guardarprueba).click();
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Editar Tarjeta", subDir, "EditarTarjetaCoemntarios");
			Helper.waitSeconds(1);
			driver.findElement(cerrar).click();

			
		}

	
	
	
}
