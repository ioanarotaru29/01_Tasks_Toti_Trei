package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class MainShopPage extends PageObject {

    @FindBy(id = "shopping_cart_container")
    private WebElementFacade cart;


    public List<WebElement> getProducts(){
        return find(By.className("inventory_list"))
                .findElements(By.className("inventory_item")).stream().collect(Collectors.toList());
    }

    public int getNrProductsInCart(){
        return Integer.parseInt(cart.find(By.className("shopping_cart_badge")).getText());
    }

    public void go_to_cart(){
        cart.find(By.className("shopping_cart_link")).click();
    }

    public void click_add_to_cart(WebElement productContainer){
        productContainer.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }

//    @FindBy(name="search")
//    private WebElementFacade searchTerms;
//
//    @FindBy(name="go")
//    private WebElementFacade lookupButton;
//
//    public void enter_keywords(String keyword) {
//        searchTerms.type(keyword);
//    }
//
//    public void lookup_terms() {
//        lookupButton.click();
//    }
//
//    public List<String> getDefinitions() {
//        WebElementFacade definitionList = find(By.tagName("ol"));
//        return definitionList.findElements(By.tagName("li")).stream()
//                .map( element -> element.getText() )
//                .collect(Collectors.toList());
//    }
}