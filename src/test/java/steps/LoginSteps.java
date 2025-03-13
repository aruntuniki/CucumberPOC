package steps; 

import java.time.Duration;

import org.openqa.selenium.By;
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

public class LoginSteps { 
   WebDriver driver = null; 
   LoginPage login = new LoginPage();
	

  
       @Given("I open the USDA homepage")
       public void openUSDAHomepage() {
           // Set the correct path to ChromeDriver
    	   System.setProperty("webdriver.chrome.driver", "C:\\SoftwareDistribution\\chromedriver.exe"); // Replace with your path to ChromeDriver

           // Initialize WebDriver for Chrome
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--start-maximized"); // Start browser maximized
           driver = new ChromeDriver(options);

           // Navigate to USDA homepage
           driver.get("https://www.usda.gov");
       }

       @Then("I should see the U.S. Department of Agriculture text")
       public void verifyUSDAVisibleText() {
           // Wait for the element containing "U.S. Department of Agriculture" to be visible
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           
           // Find the element containing the text "U.S. Department of Agriculture"
          // login.homeButton.click();
           WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'U.S. Department of Agriculture')]")));
         
           // Verify that the element is displayed
           if (element != null && element.isDisplayed()) {
               System.out.println("The text 'U.S. Department of Agriculture' is visible on the page.");
           } else {
               System.out.println("The text 'U.S. Department of Agriculture' is NOT visible on the page.");
           }

           // Close the browser after the test
           driver.quit();
       }
}
