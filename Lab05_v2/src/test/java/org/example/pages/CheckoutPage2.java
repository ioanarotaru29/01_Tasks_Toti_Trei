package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-step-two.html")
public class CheckoutPage2 extends PageObject {
    @FindBy(name = "finish")
    private WebElementFacade nextBtn;

    public void click_next(){
        nextBtn.click();
    }
}