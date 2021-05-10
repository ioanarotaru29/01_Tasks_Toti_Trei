package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/successful_test_data.csv")
public class TestSuccessfulLogin {

    String username, password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;
    @Issue("#TestLogin")
    @Test
    public void successful_login() {
        anna.is_the_home_page();
        anna.enters_credentials(username,password);
        anna.submits_credentials();
        anna.should_display_main_page();
    }
}
