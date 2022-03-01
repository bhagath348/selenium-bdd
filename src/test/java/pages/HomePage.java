package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author 
 * 
 */
public class HomePage {


    @FindBy(linkText = "Shop")
    public WebElement shopCTA;
    
    @FindBy(linkText = "Contact")
    public WebElement contactCTA;
    
    @FindBy(id = "password")
    public WebElement passwordTextField;
    
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    
    @FindBy(css = "[data-test='error']")
    public WebElement errorMessage;
    
}
