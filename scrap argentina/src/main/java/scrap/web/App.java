package scrap.web;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.MidiDevice.Info;

//import jxl.Sheet;
//import jxl.Workbook;
import java.io.FileInputStream;
import java.io.IOException;

public class App {
//Riplay, agregar método para que 
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://super.walmart.com.mx/");
		driver.get("https://super.walmart.com.mx/productos?Ntt=limpiador");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
		
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
			try {
				@SuppressWarnings("deprecation")
				FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

				WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions
						.visibilityOfElementLocated((By.className("text_text__1DYNl"))));
			} catch (TimeoutException d) {
				d.printStackTrace();
				System.out.println("TimeOut");
			} catch (NoSuchElementException o) {
				System.out.println("Except: no encontró el element");
			}
			//arranca en 0 la lista
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			List<WebElement> productos = driver.findElements(By.className("text_text__1DYNl")); 
			System.out.println (productos.size());
			List<String> productos2 = new ArrayList<>();
			for(int j = 0; j < productos.size(); j++) {
				System.out.println("ubicacion: " + j + " " +productos.get(j).getText());
				String p = productos.get(j).getText();
				if (p.length() > 26) {
					productos2.add(p);
					
				} else {
					System.out.println("no va");
					System.out.println("Aguante Velez");
				}
					
			}
			for (int i = 1; i < productos2.size(); i++) {
				System.out.println("ubicacion: " + i + " " +productos2.get(i));
			}
				
			
		driver.close();
		} catch (NoSuchElementException o) {
			System.out.println("404");
		}
	}
}
