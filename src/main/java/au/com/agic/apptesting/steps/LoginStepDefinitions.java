package au.com.agic.apptesting.steps;

import au.com.agic.apptesting.State;
import au.com.agic.apptesting.constants.Constants;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import cucumber.api.java.en.When;

/**
 * Step defininitions for logging into a web page
 */
@Component
public class LoginStepDefinitions {

	/**
	 * This code is supposed to populate the login dialog, but it actually doesn't work with most modern
	 * browsers. https://github.com/w3c/webdriver/issues/385
	 *
	 * @param username The username
	 * @param password The password
	 * @param exists   If this text is set, an error that would be thrown because the element was not found is
	 *                 ignored. Essentially setting this text makes this an optional statement.
	 */
	@When("I log in with username \"([^\"]*)\" and password \"([^\"]*)\"( if it exists)?$")
	public void login(final String username, final String password, final String exists) {
		try {
			final WebDriver webDriver = State.THREAD_DESIRED_CAPABILITY_MAP.getWebDriverForThread();
			final WebDriverWait wait = new WebDriverWait(
				webDriver,
				State.getFeatureStateForThread().getDefaultWait(),
				Constants.ELEMENT_WAIT_SLEEP_TIMEOUT);
			final Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.authenticateUsing(new UserAndPassword(username, password));
		} catch (final TimeoutException | NoSuchElementException ex) {
			if (StringUtils.isBlank(exists)) {
				throw ex;
			}
		}
	}
}
