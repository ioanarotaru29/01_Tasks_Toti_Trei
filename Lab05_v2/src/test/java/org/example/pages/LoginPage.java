package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(name = "user-name")
    private WebElementFacade usernameField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(id="login-button")
    private WebElementFacade loginBtn;

    @FindBy(className = "error-message-container")
    private WebElementFacade errorMessageContainer;

    public void enter_credentials(String username, String password){
        usernameField.type(username);
        passwordField.type(password);
    }

    public void submit_credentials(){
        loginBtn.click();
    }

    public String get_error_messages(){
       return errorMessageContainer.getText();
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