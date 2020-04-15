package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoignTest {

	WebDriver driver;
    
	  @Given("^user is on login page$")
	  public void user_is_on_login_page(){
		  System.out.println("User login Page");
		  
		  //open chrome driver from path
		  System.setProperty("webdriver.chrome.driver", "F:\\Softs\\chromedriver.exe");
		  
		  // Initialize browser
		  driver=new ChromeDriver();
		  driver.get("http://smarthomes.atwebpages.com/index.php"); 
		  
		  // Maximize browser
		  driver.manage().window().maximize();
	  }
	  
	  @When("^user enters correct username and password$")
	  public void user_enters_correct_username_and_password(){
		  System.out.println("checking username and password");
		  
		  driver.findElement(By.name("username")).sendKeys("14A21A0522");
		  driver.findElement(By.name("password")).sendKeys("14A21A0522");
		  driver.findElement(By.name("btn-login")).click();
	  }
	  
	  
	 
	  @When("^user enters correct email (.*)$")
	  public void user_enters_correct_email(String username){
		  System.out.println("checking username...."+username);
		  
		  driver.findElement(By.name("username")).sendKeys(username);
		
	  }
	  
	  @And("^user enters correct password (.*)$")
	  public void user_enters_correct(String password){
		  System.out.println("checking password..");
		 
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("btn-login")).click();
		
	  }

	  
	  @Then("^user gets confirmation$")
	  public void user_gets_confirmation(){
		  System.out.println("User gets confirmation");
		  if(!driver.getTitle().equals("Smart Home")) {
			  System.out.println("Invalid Credentials");
		  }else {
			  Assert.assertTrue(driver.findElement(By.id("menu-icon")).getText().contains("")); 
			  System.out.println("Success");
		  }
			 
		
	  }
	  
	  
	  @After
	  public void closeDriver() {
		  driver.quit();
	  }

}