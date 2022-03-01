package steps;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.Base;

public class HomePageSteps  extends Base {

    private  Base base;
    public HomePage homePage;
    
    public HomePageSteps(Base base) {
        this.base = base;
        homePage = PageFactory.initElements(Driver, HomePage.class);
    }
    
    @Given("I navigate Jupiter Toys website") 
    public void i_navigate_to_Jupiter_Toys_website() throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Given"), "I navigate Jupiter Toys website");
        base.openBaseURL();
    }
    
    @When("I click on {string} CTA to navigate to {string}")
    public void i_click_on_cta_to_navigate_to(String cta, String page) throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I click on "+cta+" CTA to navigate to "+page+" page");
        if(cta.equals("Contact")) {
        	homePage.contactCTA.click();
        } else if(cta.equals("Shop")) {
        	homePage.shopCTA.click();
        }
    }
}
