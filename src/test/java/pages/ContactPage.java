package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 
 * 
 */
public class ContactPage {

	
	@FindBy(css = ".alert")
	public WebElement headerMessage; 
	
    @FindBy(id = "forename")
    public WebElement forenameInputField;
    
    @FindBy(id = "forename-err")
    public WebElement forenameErrorText;
    
    @FindBy(id = "email")
    public WebElement emailInputField;
    
    @FindBy(id = "email-err")
    public WebElement emailErrorText;
    
    @FindBy(id = "message")
    public WebElement messageInputField;
    
    @FindBy(id = "message-err")
    public WebElement messageErrorText;
    
    @FindBy(css = ".btn-contact")
    public WebElement submitButton;
    
    @FindBy(css = ".bar")
    public WebElement progressBar;
    
    @FindBy(partialLinkText = "Back")
    public WebElement backButton;
    
}
