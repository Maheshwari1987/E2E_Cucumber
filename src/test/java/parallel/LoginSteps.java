package parallel;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String loginTitle;
	 
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");	    
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginTitle = loginpage.getLoginPageTitle();
	    System.out.println("Page Title is " + loginTitle);
	
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	    Assert.assertTrue(loginTitle.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayes")
	public void forgot_your_password_link_should_be_displayes() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());

	}

	@When("user enter the username {string}")
	public void user_enter_the_username(String username) {
		loginpage.enterUserName(username);
	
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	  loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();
	
	}

	@Then("user gets the title of the account page")
	public void user_gets_the_title_of_the_account_page() {
	loginpage.getLoginPageTitle();
	}


}
