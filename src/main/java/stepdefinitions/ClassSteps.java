package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DataUtils;

public class ClassSteps {
	
	static WebDriver driver;
	static LoginPage lp;
	
	@BeforeAll
	public static void before_or_after_all() {
		 driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}
	
	@Given("user launched login page")
	public void user_launched_login_page() throws IOException {
	 
	   driver.get(DataUtils.readLoginTestData("url"));
	}

	@When("User enters valid username")
	public void user_enters_valid_username() throws IOException {
	   lp.usernameField.sendKeys(DataUtils.readLoginTestData("username"));
	}

	@When("User enters valid password")
	public void user_enters_valid_password() throws IOException {
	    lp.passwordField.sendKeys(DataUtils.readLoginTestData("password"));
	}

	@When("User Click on login button")
	public void user_click_on_login_button() {
	    lp.clickLoginButton();
	}

	@Then("User should be seeing homepage")
	public void user_should_be_seeing_homepage() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

	

}
