package cl.tecnova.cal.tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.*;

import cl.tecnova.cal.pages.*;


public class Test_Login_Trello_GC {

			private WebDriver driver;
			private ExtentReports extent;
			private ExtentTest test;
			private static String SUBDIR = "Trello\\";
			private static Boolean TAKE_SS = true;
	
			@BeforeSuite
			public void configExtentReports() {
			// ExtentReports config
			this.extent = new ExtentReports("ExtentReports/Trello.html", true);
			}

			@BeforeMethod
			public void configSelenium() {
			// Selenium config
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("Empresa", "Trello");
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("https://trello.com/login");
			}
	
			//Este Test es Para Iniciar Sesion Correctamente 
			@Test(priority = 1) 	
			public void IniciarSesion() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Login correcto en la aplicacion Trello","Caso de Prueba 1");
			test.log(LogStatus.INFO,"Prueba Login Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 
			//Inicio de Sesion
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir); 
			//Assert Inicio de Sesion Correcto
			login.assertLoginCorrecto(); 
			//Cerrar Sesion
		    login.CerrarSesion(subDir);		
			}
	
			//Este Test es Para Iniciar Sesion Incorrecto
			@Test(priority = 2) 	
			public void IniciarSesionIncorrecto() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Login incorrecto en la aplicacion Trello","Caso de Prueba 2");
			test.log(LogStatus.INFO,"Prueba Login Incorrecto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 
			//Inicio de Sesion Incorrecto
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "LoginIncorrecto", subDir); 
			//Assert Inicio de  Sesion Incorrecto
			login.assertLoginiNCorrecto();
			}

			// Este Test Es Para Crear Nombre De Tablero
			@Test(priority = 3) 
			public void CrearTabero() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Crear un nuevo tablero con su nombre","Caso de Prueba 3");
			test.log(LogStatus.INFO,"Prueba Tablero Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 
			//Inicio de Sesion
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir);
			//Assert Inicio de Sesion
			login.assertLoginCorrecto();
			//Crear Clase Crear Tablero
			AgregarTarjetaPage AgregarTarjeta = new AgregarTarjetaPage(driver, test, TAKE_SS);				//Crear Tablero
			AgregarTarjeta.CrearTablero(subDir);
			//Assert Tablero Creado
			AgregarTarjeta.assertCrearTableroValidacion();
			//Cerrar Sesion
			login.CerrarSesion(subDir);
			}

			// Este Test Para Añadir nueva tarjeta en la lista de tareas
			@Test(priority = 4) 	
			public void AgregarNuevaTarjeta() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Agregar Nueva Tarjeta ","Caso de Prueba 4 ");
			test.log(LogStatus.INFO,"Prueba De Agregar Nueva Tarjeta Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS);
			//Iniciar Sesion
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir); 
			//Crear Clase Tarjeta
			AgregarTarjetaPage AgregarTarjeta = new AgregarTarjetaPage(driver, test, TAKE_SS);			
			//Accion Abrir Tablero
			AgregarTarjeta.abrirTablero(subDir);
			//Assert Validar Agregar Tarjeta
			AgregarTarjeta.assertAgregarNuevaTarjetaValidacion();
			//Agregar Tarjeta Lista de Prueba
			AgregarTarjeta.AgregarTarjetaListaPrueba(subDir);
			//Agregar Descripcion de Prueba Automatizada
			AgregarTarjeta.AgregarTarjetaPruebaAutomatizada(subDir);
			//Agregar Lista Proceso
			AgregarTarjeta.AgregarTablaProceso(subDir);
			//Cerrar Sesion
			login.CerrarSesion(subDir);
			}
			
			// Este Test Para Validacion de Edicion Tablero Creado Correcto
			@Test(priority = 5) 	
			public void EditarListaDePrueba() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Editar Tarjeta ","Caso de Prueba 5");
			test.log(LogStatus.INFO,"Prueba De Edicion a Nueva Tarjeta Creado Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 
			//Inicio de Sesion
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir); 
			//Crear Clase Tarjeta
			AgregarTarjetaPage AgregarTarjeta = new AgregarTarjetaPage(driver, test, TAKE_SS);			
			//Accion Abrir Tablero
			AgregarTarjeta.abrirTablero(subDir);
			//Crear Clase Editar Lista
			EditarListaPage EditarLista = new EditarListaPage(driver, test, TAKE_SS);
			//Ingreso a Tabla Prueba Automatizada
			EditarLista.TarjetaPruebaAutomatizada(subDir);
			//Agregar Descripcion
			EditarLista.Descripcion(subDir);
			//Agregar Eriqueta
			EditarLista.Etiqueta(subDir);
			//Agregar Vencimiento
			EditarLista.Vencimiento(subDir);
			//Agregar Archivo Adjunto
			EditarLista.ArchivoAdjunto(subDir);
			//Agregar Comentarios
			EditarLista.Comentarios(subDir);     
			//Cerrar Sesion
			login.CerrarSesion(subDir);
					
			}
			
			//Este Test Para Mover Tarjeta y Cerrar Sesion 
			@Test(priority = 6) 	
			public void MoverTarjeta() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Mover la tarjeta a la lista Proceso ","Caso de Prueba 6 ");
			test.log(LogStatus.INFO,"Prueba De Mover Tarjeta Creado Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 			
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir); 
			AgregarTarjetaPage AgregarTarjeta = new AgregarTarjetaPage(driver, test, TAKE_SS);			
			//Accion Abrir Tablero
			AgregarTarjeta.abrirTablero(subDir);
			//Crear Clase Editar Lista
			EditarListaPage EditarLista = new EditarListaPage(driver, test, TAKE_SS);
			//Ingreso a Tabla Prueba Automatizada
			EditarLista.TarjetaPruebaAutomatizada(subDir);			
			//Mover Tarjeta
			EditarLista.MoverTarjeta(subDir);
			//Cerrar Sesion
			login.CerrarSesion(subDir);
			}
			
			// Este Test Para Eliminar Tablero
			@Test(priority = 7) 	
			public void CerrarTablero() { 
			String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
			test = extent.startTest("Eliminar Tablero  Creado ","Caso de Prueba 7 ");
			test.log(LogStatus.INFO,"Prueba De Eliminar Tarjeta Creado Correcto");		
			LoginTrelloPage login = new LoginTrelloPage(driver, test, TAKE_SS); 			
			login.LoginUsuario("testing.qa.tecnova@gmail.com", "087654321", subDir); 
			AgregarTarjetaPage AgregarTarjeta = new AgregarTarjetaPage(driver, test, TAKE_SS);			
			//Accion Abrir Tablero
			AgregarTarjeta.abrirTablero(subDir);			
			//Eliminar Tablero
			AgregarTarjeta.EliminarTablero(subDir);	
			//Cerrar Sesion
			login.CerrarSesion(subDir);
			}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// writing everything to document.
		extent.flush();
	}
}

