package cl.tecnova.cal.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import cl.tecnova.cal.helpers.Helper;

		public class AbrirTableroPage {
		//Atributos
		private WebDriver driver; // EstSo Siempre va ser igual para todo 
		private ExtentTest test;
		private Boolean TAKE_SS;
		
		private By abrirTablero;
		
		//Construcctor
		public AbrirTableroPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
			
			this.driver = driver; 	//Esto Siempre va ser igual para todo
			this.test = test;
			this.TAKE_SS = TAKE_SS;
			this.abrirTablero = By.partialLinkText("Tablero de Jose de Prueba");
			
}		//Metodo
		public void abrirTablero(String subDir) {
		Helper.waitSeconds(1);
		driver.findElement(abrirTablero).click();
		Helper.waitSeconds(2);
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Acceso Tablero Creado", subDir, "TableroCreado");		
		Helper.waitSeconds(4);

	}
		

}







