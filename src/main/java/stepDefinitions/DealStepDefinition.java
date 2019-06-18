package stepDefinitions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class DealStepDefinition 
{
	WebDriver driver;
	@Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\anjut\\Desktop\\cu\\CucumberSeleniumFramework\\drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.crmpro.com/index.html");
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials)
	{
		List<List<String>> data=credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
	 WebElement loginBtn =
	 driver.findElement(By.xpath("//input[@type='submit']"));
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", loginBtn);
	 }
	  
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("CRMPRO", title);
	 }
	 
	@Then("^user moves to deals page$")
	public void user_moves_to_deals_page() throws InterruptedException
	{
		Thread.sleep(5000);
	   WebElement deals=driver.findElement(By.xpath("//div[@id='navmenu']/ul/li[5]/a"));
		Actions action=new Actions(driver);
	    action.moveToElement(deals).perform();
	}

	@Then("^click on new deal$")
	public void click_on_new_deal() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement newdeals=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a"));
			Actions action=new Actions(driver);
		    action.moveToElement(newdeals).click().perform();
	}

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	

}
