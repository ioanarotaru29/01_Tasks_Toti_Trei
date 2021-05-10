package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {

    @FindBy(name = "checkout")
    private WebElementFacade checkoutBtn;

    public List<WebElement> getCartItems(){
        return find(By.className("cart_list"))
                .findElements(By.className("cart_item")).stream().collect(Collectors.toList());
    }

    public void go_to_checkout(){
        checkoutBtn.click();
    }
}