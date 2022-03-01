package steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import utils.Base;

public class ContactPageSteps extends Base {

    public ContactPage contactPage;
    
    public String foreName = "Sindhu";
    public ContactPageSteps(Base base) {
        contactPage = PageFactory.initElements(Driver, ContactPage.class);
    }
    
    @When("I click on Submit button")
    public void i_click_on_Submit_button() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I click on Submit button");
    	waitForElement(contactPage.submitButton, 30);
    	contactPage.submitButton.click();
    }
    
    @Then("I should see error messages")
    public void i_should_see_error_messages() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Then"), "I should see error messages");
    	Assert.assertTrue(contactPage.headerMessage.getText().contains("We welcome your feedback - but we won't get it unless you complete the form correctly."));
    	Assert.assertTrue(contactPage.forenameErrorText.getText().contains("Forename is required"));
    	Assert.assertTrue(contactPage.emailErrorText.getText().contains("Email is required"));
    	Assert.assertTrue(contactPage.messageErrorText.getText().contains("Message is required"));
    }
    
    @When("I populate mandatory fields")
    public void i_populate_mandatory_fields() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I populate mandatory fields");
    	waitForElement(contactPage.forenameInputField, 30);
    	contactPage.forenameInputField.sendKeys(foreName);
    	contactPage.emailInputField.sendKeys("test@test.com");
    	contactPage.messageInputField.sendKeys("Jupiter Toys");
    }
    
    @Then("I should not see error messages")
    public void i_should_not_see_error_messages() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Then"), "I should not see error messages");
    	Assert.assertTrue(contactPage.headerMessage.getText().contains("We welcome your feedback - tell it how it is."));
    }
    
    @Then("I should see successful submission message")
    public void i_should_see_successful_submission_message() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Then"), "I should see successful submission message");
    	waitForElement(contactPage.progressBar, 60);
    	waitForElement(contactPage.backButton, 120);
    	Assert.assertTrue(contactPage.headerMessage.getText().contains("Thanks "+foreName+", we appreciate your feedback."));
    }
    
    @When("I populate mandatory fields with invalid data")
    public void i_populate_mandatory_fields_with_invalid_data() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I populate mandatory fields with invalid data");
    	waitForElement(contactPage.forenameInputField, 30);
    	contactPage.emailInputField.sendKeys("1234567890");
    }
    @Then("I should see error message for invalid data")
    public void i_should_see_error_message_for_invalid_data() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Then"), "I should see error message for invalid data");
    	Assert.assertTrue(contactPage.emailErrorText.getText().contains("Please enter a valid email"));
    }

}