package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class ShopForProduct {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void shop_for_product(){
        anna.logs_in();
        anna.should_display_main_page();

        anna.adds_products_to_cart(2);
        anna.go_to_cart();

        anna.go_to_checkout();
        anna.fill_checkout_form("user", "user","12345");
        anna.submit_checkout_form();

        anna.finish_shopping();
        anna.logout();
    }

} 