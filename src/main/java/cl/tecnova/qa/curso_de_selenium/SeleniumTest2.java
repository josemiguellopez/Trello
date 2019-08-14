package cl.tecnova.qa.curso_de_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest2 {


	public static void main(String[] args) {
		
		//Configuramos el Driver del Navegador
		System.setProperty("webdriver.chrome.driver", "DRIVERS/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximizar Ventana
		driver.manage().window().maximize();		
		//Navegamos a la Pagina
		driver.get("C:\\LocalHost\\index.html");		
		//Buscar alguna wea
		driver.findElement(By.name("q")).sendKeys("holi");	
		//hacer click
		driver.findElement(By.name("btnG")).submit();	
		
		try {
			Thread.sleep(2000);//Generar Espera
			}
		catch (InterruptedException ex) {		// en caso que falle la vaina se genera automatico la validacion del error	
			ex.printStackTrace();
		}
		driver.navigate().back(); // le digo al navegador que vaye para atras
		
		driver.findElement(By.xpath("/html/body/div[2]/button")).click(); // el boton como no tiene nada de info lo busco por xpath
		driver.findElement(By.id("username")).sendKeys("Jose Miguel Lopez"); // le mando texto al campo
		driver.findElement(By.name("pass")).sendKeys("miclave"); //le mando mi clave al texto
		try {
			Thread.sleep(2000);//Generar Espera
		}
		catch (InterruptedException ex) {
			
			ex.printStackTrace();
		}
				driver.findElement(By.xpath("//*[@id=\"formulario1\"]/input")).click(); // hago click al boton
				
				driver.findElement(By.name("email")).sendKeys("josemiguellopez@lalalaaaaaaaaa.com"); //le meto mi correo
				driver.findElement(By.name("birth")).sendKeys("25-04-1990"); // le meto la edad
				
				driver.findElement(By.xpath("/html/body/div[2]/fieldset[2]/div/label[2]/input")).click(); // elijo un checkbox
				driver.findElement(By.xpath("/html/body/div[2]/fieldset[2]/div/label[3]/input")).click(); // elijo otro check box
				
				driver.findElement(By.xpath("/html/body/div[2]/fieldset[3]/label[3]/input")).click(); // tipo de sexo
				
				Select pais = new Select(driver.findElement(By.name("country"))); // con esto seleccionamos los comboxbox
				pais.selectByVisibleText("Venezuela");// con esto seleccionamos los comboxbox
				
				driver.findElement(By.name("mensaje")).sendKeys("mi nombre es jose mgiuel lopez esto e suna prueba automatizadaaaaaaaaaaaaaaaaaa"); // prueba de envio
				
				driver.findElement(By.xpath("/html/body/div[2]/div[1]/button")).click(); //click a boton
				
				
				
				
			/*	String mensaje = driver.switchTo().alert().getText();
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
							
				driver.switchTo().alert().accept();
				
				driver.switchTo().defaultContent(); // vamos a la paginan principal
				
				WebElement iFrame = driver.findElement(By.id("youtube")); // nos metemos en el inframe
				driver.switchTo().frame(iFrame);							// nos metemos en el inframe
				
				driver.findElement(By.id("player")).click(); //iniciamos el video
				
				
				driver.switchTo().defaultContent(); // vamos a la paginan principal
				
				driver.findElement(By.name("uploadedfile")).sendKeys("C:\\LocalHost\\1.jfif");
				driver.findElement(By.id("subir")).click();
				
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
				driver.switchTo().alert().accept();

				

				
				
	}

}
