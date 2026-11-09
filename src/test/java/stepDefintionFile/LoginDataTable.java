package stepDefintionFile;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class LoginDataTable {
	
	WebDriver driver;
	LoginPageObject obj;
	
	@Before
	public void browsersetup()
	{
		driver=new ChromeDriver();
		obj=new LoginPageObject(driver);
	}
	
	@Given("Login page was launched")
	public void login_page_was_launched() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("I enter the following credentials")
	public void i_enter_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
		
		List<Map<String,String>>data= dataTable.asMaps();
		
		for(Map<String,String>row:data)
		{
			obj.enterUserName(row.get("username"));
			obj.enterPassword(row.get("password"));
			obj.clickSubmit();
			
			driver.get("https://practicetestautomation.com/practice-test-login/");
		}
		
	}
	
	@After
	public void tearDown()
	{
	    if(driver!=null)
	    {
	    	driver.quit();
	    }
	}

}
