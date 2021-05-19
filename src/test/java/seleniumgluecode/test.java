package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test {
	
	WebDriver driver;

	@Given("user is  on homepage")
	public void user_is_on_homepage() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
	}

	@When("user navigates to Login Page")
	public void user_navigates_to_login_page() {
		driver.findElement(By.linkText("Sign in")).click();
	}

	@When("user enters username and Password")
	public void user_enters_username_and_password() {
		driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("success message is displayed")
	public void success_message_is_displayed() {
		String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
	}

}
