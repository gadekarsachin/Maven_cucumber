package parameterstepdef;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Maps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class parameter {

	WebDriver driver;

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.close();
	}

	@Given("user should be at login page")
	public void user_should_be_at_login_page() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
	}

	@When("entermap the valied value help of Map")
	
	public void entermapTheValiedValueHelpOfMap(DataTable datatable) throws Throwable {

		List<List<String>> data = datatable.asLists();
		List<Map<String, String>> dmap = datatable.asMaps();

		String user= dmap.get(0).get("username");
		String pass= dmap.get(0).get("password");
		
		WebElement usename = driver.findElement(By.name("username"));
		usename.sendKeys(user);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
	}
	
	
	
	

	@When("put the valied value for") // parameterised
	public void putTheValiedValueFor(DataTable datatable) {

		List<List<String>> data = datatable.asLists();

		WebElement usename = driver.findElement(By.name("username"));
		usename.sendKeys(data.get(0).get(0));

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(data.get(0).get(1));
	}
	

	@When("click the login button")
	public void clickTheLoginButton() {
		driver.findElement(By.cssSelector("input.button ")).click();
	}

	@Then("get error")
	public void getError() throws Throwable {
		WebElement title = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"));
		System.out.println(title.getText());
		Assert.assertTrue("Error!", title.isDisplayed());
	}

	@After
	public void after() {
		driver.quit();
	}
}
