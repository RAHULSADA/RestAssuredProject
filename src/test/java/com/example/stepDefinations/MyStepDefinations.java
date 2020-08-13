package com.example.stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyStepDefinations {

    @Given("^User has an active Avion card$")
    public void user_has_an_active_Avion_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have an active Avion card");
    }

    @When("^user logs into website user name \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_into_website_user_name_password(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("My credentials: " + arg1 + " " + arg2);
    }

    @Then("^credit card home page should be displayed$")
    public void credit_card_home_page_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Credit card home page");
    }

    @Then("^Avion card details should be displayed in summary section$")
    public void avion_card_details_should_be_displayed_in_summary_section() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Here is your summary for Avion card");
    }

    @Given("^User has disabled card$")
    public void user_has_disabled_card() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I have a disabled card");
    }

    @Then("^disabled card section should not be displayed in summary$")
    public void disabled_card_section_should_not_be_displayed_in_summary() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Oh ho... my card details are not displayed");
    }
}
