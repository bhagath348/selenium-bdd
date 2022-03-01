package steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShopPage;
import utils.Base;

public class ShopPageSteps  extends Base {

    public ShopPage shopPage;
    
    public ShopPageSteps(Base base) {
        shopPage = PageFactory.initElements(Driver, ShopPage.class);
    }
    Map<String, Integer> itemsMap=new HashMap<String, Integer>();  

    @When("I click buy button {int} times on {string}")
    public void i_click_buy_button_times_on(Integer quantity, String item) throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I click buy button "+quantity+" times on "+item);
    	
    	itemsMap.put(item, quantity);
    	waitForElement(shopPage.fluffyBunnyBuyButton, 30);
    	shopPage.buyItem(item, quantity);
    }

    @When("I click the cart menu")
    public void i_click_the_cart_menu()throws Throwable{
    	Base.scenarioDef.createNode(new GherkinKeyword("When"), "I click the cart menu");

        shopPage.cartLink.click();
    }

    @Then("I should see the items are in the cart")
    public void i_should_see_the_items_are_in_the_cart()  throws Throwable {
    	Base.scenarioDef.createNode(new GherkinKeyword("Then"), "I should see the items are in the cart");
    	waitForElement(shopPage.checkoutButton, 60);
      shopPage.validateCartItems(itemsMap);
    }
}
