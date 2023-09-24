package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountsPage = loginpage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Account page title is :" + title );
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> expAccountSectionList = sectionsTable.asList();
		System.out.println("Expected accounts section list:" + expAccountSectionList);
		
		
		List<String> actualAccountSectionList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list:" + actualAccountSectionList);
		
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer exceptedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == exceptedSectionCount);
	}

}
