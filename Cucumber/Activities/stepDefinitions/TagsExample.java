package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TagsExample extends BaseClass{
    private String homePageTitle;
    @Given("^user opens a page$")
    public void user_opens_a_page(){
        driver.get("https://training-support.net");
    }

    @When("^user performs an action$")
    public void user_performs_action(){
        homePageTitle= driver.getTitle();
    }

    @Then("do action for first scenario")
    public void do_action_for_first_scenario(){
        Assert.assertEquals(homePageTitle,"Training Support");
    }


}
