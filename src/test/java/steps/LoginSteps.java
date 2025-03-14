package steps; 

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 
import Pages.LoginPage;
import utilities.Configuration;
import utilities.Driver;
import utilities.BrowserUtils;


public class LoginSteps { 
   WebDriver driver = Driver.getDriver(); 
   LoginPage login = new LoginPage();
	

  
       @Given("I open the TSCTI homepage")
       public void openUSDAHomepage() {
          
           driver.get(Configuration.getProperty("tsctiurl"));
       }

       @Then("I should see the Our Services text")
       public void verifyUSDAVisibleText() throws IOException {
          
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));          
           WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Our Services']")));
         
           // Verify that the element is displayed
           if (element != null && element.isDisplayed()) {
               System.out.println("The text 'Our Services' is visible on the page.");
           } else {
               System.out.println("The text 'Our Services' is NOT visible on the page.");
           }
           
           
       }
}
