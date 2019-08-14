package cl.tecnova.cal.helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * <P>
 * Clase utilitaria con herramientas comunes a todas las páginas web.
 * <p>
 * Se presentan los siguientes utilitarios:
 * <ul>
 * <li>{@link #addEvidence(Boolean, WebDriver, ExtentTest, String, String, String)}</li>
 * <li>{@link #waitSeconds(int)}</li>
 * </ul>
 * 
 * @author Ernesto Urbina Figueroa
 * @version 2.0
 */
public class Helper {

	private static String PATH_EVIDENCE = "ExtentReports\\Evidence";
	private static String DIR_EVIDENCE = ".\\Evidence\\";

	/**
	 * <p>
	 * Agrega la evidencia de prueba al reporte a generar.
	 * 
	 * @param TAKE_SS
	 *            boolean que indica si se debe adjuntar la evidencia.
	 * @param driver
	 *            WebDriver del navegador utilizado.
	 * @param test
	 *            referencia al reporte de ExtentReports.
	 * @param imageTitle
	 *            título/descripción de la imagen.
	 * @param subDir
	 *            Subdirectorio en el cual se guardará la imagen.
	 * @param imageName
	 *            nombre de la imagen sin extensión.
	 * 
	 * @author Ernesto Urbina Figueroa
	 * @since 2.0
	 */
	public static void addEvidence(Boolean TAKE_SS, WebDriver driver, ExtentTest test, String imageTitle, String subDir,
			String imageName) {
		if (TAKE_SS) {
			Helper.takeScreenShot(driver, subDir, imageName);
			Helper.takeEvidence(test, imageTitle, subDir, imageName);
		}
	}

	/**
	 * <p>
	 * Detiene la ejecución la cantidad de segundos indicados por parámetro.
	 * <p>
	 * Utilitario para usarse en conjunto con los implicitWait.
	 *
	 * @param seconds
	 *            cantidad de segundos a detener la ejecución.
	 * @author Ernesto Urbina Figueroa
	 * @since 2.0
	 */
	public static void waitSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Toma una impresion de pantalla y la guarda en un directorio donde quedan
	 * todas las evidencias de prueba
	 *
	 * @param driver
	 *            driver navegador.
	 * @param subDir
	 *            directorio de las imágenes.
	 * @param imageName
	 *            nombre de la imagen sin extension.
	 * @author Ernesto Urbina Figueroa
	 * @since 1.0
	 */
	private static void takeScreenShot(WebDriver driver, String subDir, String imageName) {
		// Directorio donde quedaran las imagenes guardadas
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				// Toma la captura de imagen
				File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Mueve el archivo a la carga especificada con el respectivo nombre
				FileUtils.copyFile(imagen,
						new File(directory.getAbsolutePath() + "\\" + subDir + "\\" + imageName + ".png"));
			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Adjunta una imagen como evidencia de prueba, la imagen ya ha sido capturada
	 * por:
	 * <ul>
	 * <li>{@link #takeScreenShot(WebDriver, String, String)}</li>
	 * </ul>
	 *
	 * @param test
	 *            referencia a la instancia de ExtentReports.
	 * @param imageTitle
	 *            título de la imagen.
	 * @param subDir
	 *            subdirectorio de la imagen.
	 * @param imageName
	 *            nombre de la imagen sin extensión.
	 * @author Ernesto Urbina Figueroa
	 * @since 1.0
	 */
	private static void takeEvidence(ExtentTest test, String imageTitle, String subDir, String imageName) {
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				test.log(LogStatus.INFO,
						imageTitle + test.addScreenCapture(DIR_EVIDENCE + subDir + "\\" + imageName + ".png"));

			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

}
