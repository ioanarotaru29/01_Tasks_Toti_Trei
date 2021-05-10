package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutPage extends PageObject {

    @FindBy(name = "firstName")
    private WebElementFacade firstNameField;

    @FindBy(name = "lastName")
    private WebElementFacade lastNameField;

    @FindBy(name = "postalCode")
    private WebElementFacade postalCodeField;

    public void fill_form(String fname, String lname, String code){
        firstNameField.type(fname);
        lastNameField.type(lname);
        postalCodeField.type(code);
    }

    @FindBy(name = "continue")
    private WebElementFacade nextBtn;

    public void click_next(){
        nextBtn.click();
    }
}