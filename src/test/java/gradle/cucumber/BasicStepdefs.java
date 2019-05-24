package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;


public class BasicStepdefs {

    @When("^I run a failing step")
    public void I_run_a_failing_step() throws Throwable {
        new Production().doWork();
    }
    @Then( "all Run" )
    public void all_run(){
        assertTrue(true);
    }

}
