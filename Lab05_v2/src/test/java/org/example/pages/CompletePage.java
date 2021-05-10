package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-complete.html")
public class CompletePage extends PageObject {

    @FindBy(id = "react-burger-menu-btn")
    private WebElementFacade menuBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElementFacade logoutBtn;

    public void click_menu(){
        menuBtn.click();
    }

    public void click_logout(){
        logoutBtn.click();
    }
}