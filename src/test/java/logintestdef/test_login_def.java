package logintestdef;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test_login_def {
	WebDriver driver;

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("user should be at login page")

	public void userShouldBeAtLoginPage() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
	}   
	
	@When("put the valied value for")
	public void putTheValiedValueFor(DataTable datatable) {

		List< List<String>> data=datatable.asLists();
		
		WebElement usename = driver.findElement(By.name("username"));
		usename.sendKeys(data.get(0).get(0));

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(data.get(0).get(1));
	}
	
	

	@When("put the credential value")//login tag1
	public void putTheCredentialValue() {

		WebElement usename = driver.findElement(By.name("username"));
		usename.sendKeys("sa123");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1234");
	}

	@When("click the login button")
	public void clickTheLoginButton() {
		driver.findElement(By.cssSelector("input.button ")).click();
	}

	@Then("open a home page")
	public void openAHomePage() {

		WebElement logout = driver.findElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));

		org.junit.Assert.assertTrue(logout.isDisplayed());

	}

	@After
	public void after() {
		driver.quit();
	}
}
