package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author 
 * 
 */
public class ShopPage {


    @FindBy(xpath = "//h4[text()=\"Funny Cow\"]/parent::div//a[text()=\"Buy\"]")
    public WebElement funnyCowBuyButton;
    
    @FindBy(xpath = "//h4[text()=\"Fluffy Bunny\"]/parent::div//a[text()=\"Buy\"]")
    public WebElement fluffyBunnyBuyButton;
    
    @FindBy(xpath = "//a[@href=\"#/cart\"]")
    public WebElement cartLink;
    
    @FindBy(xpath = "//tr[contains(@class,\"cart-item\")]/td[1]")
    public List<WebElement> items;
    
    @FindBy(xpath = "//tr[contains(@class,\"cart-item\")]/td[3]/input")
    public List<WebElement> quantities;
    
    @FindBy(linkText = "Check Out")
    public WebElement checkoutButton;
    
 
    public void buyItem(String item, int quantity) {
    	if(item.equals("Funny Cow")) {
    		for(int i=0; i< quantity; i++)
    		funnyCowBuyButton.click();
    	} else if(item.equals("Fluffy Bunny")) {
    		for(int i=0; i< quantity; i++)
    		fluffyBunnyBuyButton.click();
    	}
    }
    
    public void validateCartItems(Map<String, Integer> itemsMap) {
        Map<String, Integer> actualtemsMap=new HashMap<String, Integer>();  
        String key;
        String value;
		for(int i=0; i<items.size(); i++) {
    		key = items.get(i).getText().trim();
    		value = quantities.get(i).getAttribute("value");
    		actualtemsMap.put(key, Integer.parseInt(value));
		}
		Assert.assertTrue(itemsMap.equals(actualtemsMap));
	}
}
