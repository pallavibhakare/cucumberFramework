package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.DataUtils;

public class LoginSteps {
	static WebDriver driver;
	static LoginPage lp;
	
	@BeforeAll
	public static void before_or_after_all() {
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() throws IOException {
		driver.get(DataUtils.readLoginTestData("url"));
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() throws IOException {
	   lp.usernameField.sendKeys(DataUtils.readLoginTestData("username"));
	}

	@When("I leave the password field empty")
	public void i_leave_the_password_field_empty() throws IOException {
		lp.passwordField.clear();
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		lp.clickLoginButton();
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
	   lp.isErrorMessageDisplayed();
	}
}
