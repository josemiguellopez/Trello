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
	public class LoginTrelloPage {
	//ATRIBUTOS = SON LAS COSAS CON LAS QUE VAMOS A INTERACTUAR 
		
	private WebDriver driver;     //Esto Siempre va ser igual para todo                                  //#Paso 1 
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	//Se Declara variables que vamos a manipular de la pagina
	private By usuario;           		//Campo Usuario  
	private By clave;			  		//Campo Clave
	private By iniciarsesion;		  	//Boton Ingresar
	private By validacionlogin;
	private By botonperfil; // el boton perfil
	private By botoncerrarsesion; // cerrar sesion
	
	
	// AQUI USAMOS LAS VARIBALES PARA VALIDAR
	

	private By validacionloginincorecto;
	private By validaicontarjeta;

	
	//CONSTRUCTOR= RECIBE TODAS LAS COSAS CON LA QUE VAMOS A INTERACTUAR ( SIEMPRE RECIBE DRIVER TEST Y FOTO PRUEVA)  //#Paso2 
	public LoginTrelloPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) { 
	this.driver = driver; 	//Esto Siempre va ser igual para todo
	this.test = test;		//Esto Siempre va ser igual para todo
	this.TAKE_SS = TAKE_SS;	//Esto Siempre va ser igual para todo
	
	this.usuario = By.name("user"); 
	this.clave = By.name("password");	
	this.iniciarsesion = By.id("login"); 
	this.validacionlogin = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div/h3"); //Tableros personales
	this.validacionloginincorecto = By.xpath("//p[@class='error-message']"); //Tableros personales

	
	
	this.botonperfil = By.xpath("//span[contains(.,'TQAT')]");
	this.botoncerrarsesion = By.xpath("//span[contains(.,'Cerrar sesión')]");
	
	//de aqui pa aca metemos las varibales que usamos para validar 
	
	this.validaicontarjeta = By.xpath("//span[@class='js-add-a-card'][contains(.,'Añada una tarjeta')]");

	
	}

	//Metodo Login "Es la suma de todo" aqui vamos a interactuar (le mandamos los datos de los campos )    //#Paso 3 
		
	public void LoginUsuario(String user, String pass, String subDir ) {  		  
		
		driver.findElement(usuario).sendKeys(user);       
		driver.findElement(clave).sendKeys(pass);
		Helper.addEvidence(TAKE_SS, driver, test, "Ingreso de Usuario & Clave", subDir, "Imagen01");
		driver.findElement(iniciarsesion).click();
		Helper.waitSeconds(2);
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Inicio", subDir, "Imagen02");		
	}
			
	public void CerrarSesion(String subDir) {
		Helper.waitSeconds(2);
		driver.findElement(botonperfil).click();				
		driver.findElement(botoncerrarsesion).click();
		Helper.addEvidence(TAKE_SS, driver, test, "Pantalla de Cerrar Sesion", subDir, "Imagen03");
	}
	
	public void assertLoginCorrecto() { //metodo para validar ingreso correcto      //#Paso 5 		
	Assert.assertTrue(driver.findElement(validacionlogin).getText().equals("Tableros personales"));
	}
	public void assertLoginiNCorrecto() { //metodo para validar ingreso clave incorrecto      //#Paso 5 		
	Assert.assertTrue(driver.findElement(validacionloginincorecto).getText().equals("Contraseña no válida"));
	}
	
	
	
	public void assertAgregarNuevaTarjetaValidacion() { //metodo para validar ingreso correcto      //#Paso 5 	
	Assert.assertTrue(driver.findElement(validaicontarjeta).getText().equals("Añada una tarjeta"));

	//hola3
	}
	
}
