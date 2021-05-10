package org.example.steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.example.pages.*;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    LoginPage loginPage;
    MainShopPage mainShopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutPage2 checkoutPage2;
    CompletePage completePage;

    private int nrProducts=0;


    @Step
    public void is_the_home_page() {
        loginPage.open();
    }

    @Step
    public void enters_credentials(String username, String password) {
        loginPage.enter_credentials(username,password);
    }

    @Step
    public void submits_credentials(){
        loginPage.submit_credentials();
    }

    @Step
    public void should_display_main_page(){
        mainShopPage.shouldBeDisplayed();
    }

    @Step
    public void should_display_error(){
        assertThat(loginPage.get_error_messages(), containsString("Username and password do not match any user in this service"));
    }


    @Step
    public void logs_in(){
        is_the_home_page();
        enters_credentials("standard_user","secret_sauce");
        submits_credentials();
    }

    @Step
    public void adds_products_to_cart(int nr_of_products){
        nrProducts = nr_of_products;
        for(int i=0;i<nr_of_products;i++){
            List<WebElement> products = mainShopPage.getProducts();
            mainShopPage.click_add_to_cart(products.get(i));
        }
        assertThat(mainShopPage.getNrProductsInCart(), equalTo(nr_of_products));
    }

    @Step
    public void go_to_cart(){
        mainShopPage.go_to_cart();
        cartPage.shouldBeDisplayed();
        assertThat(cartPage.getCartItems(), hasSize(nrProducts));
    }


    @Step
    public void go_to_checkout(){
        cartPage.go_to_checkout();
        checkoutPage.shouldBeDisplayed();
    }

    @Step
    public void fill_checkout_form(String fname, String lname, String code){
        checkoutPage.fill_form(fname, lname, code);
    }

    @Step
    public void submit_checkout_form(){
        checkoutPage.click_next();
        checkoutPage2.shouldBeDisplayed();
    }

    @Step
    public void finish_shopping(){
        checkoutPage2.click_next();
        completePage.shouldBeDisplayed();
    }

    @Step
    public void logout(){
        completePage.click_menu();
        completePage.logoutBtn.shouldBeVisible();
        completePage.click_logout();
        loginPage.shouldBeDisplayed();
    }
//
//    @Step
//    public void starts_search() {
//        dictionaryPage.lookup_terms();
//    }
//
//    @Step
//    public void should_see_definition(String definition) {
//        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
//    }


//    @Step
//    public void looks_for(String term) {
//        enters(term);
//        starts_search();
//    }
}