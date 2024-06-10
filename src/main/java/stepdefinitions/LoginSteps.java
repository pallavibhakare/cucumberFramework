package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import tests.BaseTest;
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
//		driver = BaseTest.getDriver();
//        lp = new LoginPage(driver);
        driver.get(DataUtils.readLoginTestData("url"));
        Assert.assertTrue(lp.isLoginPageOpen(driver));
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() throws IOException {
	   String expectedUsername = DataUtils.readLoginTestData("username");
	   lp.usernameField.sendKeys(expectedUsername );
//	   lp.enterUserName();
	   Assert.assertTrue(lp.isUserNameValueEntered(expectedUsername));
	}

	
	
	@When("I leave the password field empty")
	public void i_leave_the_password_field_empty() throws IOException {
		lp.passwordField.clear();
		Assert.assertTrue(lp.isPasswordEmpty());
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		lp.clickLoginButton();
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		Assert.assertTrue(lp.isErrorMessageDisplayed());		
	}
	@When("I enter a valid password")
	public void i_enter_a_valid_password() throws IOException {
	    lp.enterPassword();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() throws IOException {
		Assert.assertTrue(lp.isHomePageLoaded(driver));
	}
	

	@When("I select the {string} checkbox")
	public void i_select_the_checkbox(String string) {
	    lp.selectRememberMeCheckbox();
	}

	@Then("I log out")
	public void i_log_out() {
	    lp.logoutFromSFDC(driver);
	}

	@Then("I should see the login page again")
	public void i_should_see_the_login_page_again() throws IOException {
	    Assert.assertTrue(lp.isLoginPageOpen(driver));
	}

	@Then("the username field should be populated")
	public void the_username_field_should_be_populated() throws IOException {
	    Assert.assertTrue(lp.isUserSaved(driver));
	}

	
	@Then("the \"Remember Me\" checkbox should be checked")
	public void the_checkbox_should_be_checked(String string) throws IOException {
	
	    Assert.assertTrue(lp.isRememberMeSelected());
	}

	@When("I click the \"Forget Password\" link")
	public void i_click_the_link(String string) {
	    lp.clickForgetPasswordLink();
	}

	@Then("I should be redirected to the forget password page")
	public void i_should_be_redirected_to_the_forget_password_page() throws IOException {
	    Assert.assertTrue(lp.isForgetPasswordPage(driver));
	}

	@When("I request to reset my password")
	public void i_request_to_reset_my_password() throws IOException {
	    lp.forgetPassword();
	}

	@Then("I should see the {string} confirmation page")
	public void i_should_see_the_confirmation_page(String string) throws IOException {
	 Assert.assertTrue(lp.isCheckYourEmailPage(driver));   
	}

	@When("I enter an invalid username")
	public void i_enter_an_invalid_username() throws IOException {
	    lp.enterWrongUserName();
//	    Assert.assertTrue(lp.isUserNameValueEntered(DataUtils.readLoginTestData("username")));
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() throws IOException {
	    lp.enterWrongPassword();
	}

}
