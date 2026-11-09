package stepDefintionFile;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class ValidLoginSDF {
	WebDriver driver;
	LoginPageObject obj;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	    obj=new LoginPageObject(driver);
	    obj.enterUserName(uname);
	    obj.enterPassword(pwd);
	}

	@When("clicks on submit  button")
	public void clicks_on_submit_button() {
		obj.clickSubmit();
	}

	@Then("user navigated to next page")
	public void user_navigated_to_next_page() {
		String actual=obj.geturl();
		String expected="https://practicetestautomation.com/logged-in-successfully/";
		Assertions.assertEquals(actual, expected);
	}
	
	@After
	public void teardown()
	{
		if (driver != null) {
	        driver.quit();
	    }
	}
}
