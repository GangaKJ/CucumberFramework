package stepDefintionFile;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class LoginTestCases {
	WebDriver driver;
	LoginPageObject obj;
	
	@Before
	public void browserSetup()
	{
		driver=new ChromeDriver();
	}
	
	@Given("Application login page")
	public void application_login_page() {
	    
		driver.get("https://practicetestautomation.com/practice-test-login/");
		obj=new LoginPageObject(driver);
	}

	@When("user provide  credentials {string} and {string}")
	public void user_provide_credentials_and(String username, String pwd) {
	   
	    obj.enterUserName(username);
	    obj.enterPassword(pwd);
	}

	@When("clicks submit button")
	public void clicks_submit_button() {
	    obj.clickSubmit();
	}

	@Then("Success message {string}")
	public void success_message(String expected) {
		String actual=obj.geturl();
		Assertions.assertEquals(actual,expected);   
	}

	@Then("Error message {string}")
	public void error_message(String expected) {
	    String actual=obj.errorMessage();
	    Assertions.assertEquals(actual,expected);
	}
	
	@After
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
