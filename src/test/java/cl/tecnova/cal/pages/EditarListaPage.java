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
//		private By campohora;
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
//					this.campohora = By.xpath("//input[@tabindex='102']");
					this.guardar = By.xpath("//input[@tabindex='103']");
					this.agregarcomentario = By.xpath("//textarea[@placeholder='Escriba un comentario...']");
					this.adjunto = By.xpath("//a[@title='Adjunto']");
					this.txtadjunto = By.xpath("//input[@placeholder='Pegue un vínculo aquí...']");
					this.adjuntar = By.xpath("//input[@value='Adjuntar']");
					this.guardarprueba = By.xpath("//input[contains(@class,'primary confirm mod-no-top-bottom-margin js-add-comment')]");
					this.cerrar = By.xpath("//*[@id=\"chrome-container\"]/div[3]/div/div/a");

					
					
					
					
					
							}
		public void EditarLista(String subDir){
			
			Helper.waitSeconds(3);
			driver.findElement(clickpruebaautomatizada).click();
			Helper.waitSeconds(2);
			driver.findElement(clickdescripcion).click();
			Helper.waitSeconds(1);
			driver.findElement(descripcion).sendKeys("Hola soy una descripcion automatizada");
			Helper.waitSeconds(2);
			driver.findElement(etiqueta).click();
			Helper.waitSeconds(1);
			driver.findElement(coloretiqueta).click();
			Helper.waitSeconds(1);
			driver.findElement(cerraretiqueta).click();
			Helper.waitSeconds(1);
			// hasta aqui la vaina va bien, no cambies nada, cualquier error es cosa de chrome !
			driver.findElement(vencimiento).click();
			Helper.waitSeconds(1);
			driver.findElement(campofecha).sendKeys("31/05/2019");
			Helper.waitSeconds(1);
//			driver.findElement(campohora).sendKeys("12:55");
//			Select sel=new Select(campohora);
//		    sel.selectByVisibleText("12:55"); //This will select the 'Option' from 'Select' List who's visibility text is "Cycle". 
			
			
			Helper.waitSeconds(1);
			driver.findElement(guardar).click();
			
			Helper.waitSeconds(1);
			
			driver.findElement(adjunto).click();
			driver.findElement(txtadjunto).sendKeys("https://avatarfiles.alphacoders.com/991/thumb-99177.jpg");
			driver.findElement(adjuntar).click();
			driver.findElement(agregarcomentario).sendKeys("Hola, Soy un comentario automatizado ;)");
			Helper.waitSeconds(1);
			driver.findElement(guardarprueba).click();
			Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Editar Tarjeta", subDir, "EditarTarjeta");
			Helper.waitSeconds(1);
			driver.findElement(cerrar).click();

			
		}

	
	
	
}
