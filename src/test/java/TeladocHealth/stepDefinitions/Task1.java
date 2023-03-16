package TeladocHealth.stepDefinitions;

import TeladocHealth.pages.AddUser;
import TeladocHealth.utilities.BrowserUtils;
import TeladocHealth.utilities.ConfigurationReader;
import TeladocHealth.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task1 {


    AddUser user = new AddUser();

    List<String> expectedNewUser = new ArrayList<>();

    @Given("user should navigate to the website")
    public void user_should_navigate_to_the_website() {
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }

    @When("user click on add user button")
    public void user_click_on_add_user_button() {
        user.AddUserBtn.click();
    }

    @When("user enter the following information")
    public void user_enter_the_following_information(Map<String, String> userInfo) {

        user.firstName.sendKeys(userInfo.get("First Name"));
        expectedNewUser.add(userInfo.get("First Name"));

        user.lastName.sendKeys(userInfo.get("Last Name"));
        expectedNewUser.add(userInfo.get("Last Name"));

        user.userName.sendKeys(userInfo.get("User Name"));
        expectedNewUser.add(userInfo.get("User Name"));

        user.password.sendKeys(userInfo.get("Password"));

    }

    @When("user should select company")
    public void user_should_select_company() {
        user.companyAAA.click();
    }

    @When("user should select the role")
    public void _should_select_the_role() {
        user.role.click();
        user.role.sendKeys("Customer");
        user.role.click();
    }

    @When("user continue following information")
    public void user_continue_following_information(Map<String, String> userInfo) {
        user.email.sendKeys(userInfo.get("E-mail"));
        user.cellPhone.sendKeys(userInfo.get("Cell Phone"));
    }

    @When("user click the save button")
    public void user_click_the_save_button() {
        BrowserUtils.waitForClickablility(user.saveBtn, 2000);
        user.saveBtn.click();
    }

    @Then("user should verify new user is added")
    public void user_should_verify_new_user_is_added() {
        List<String> actualUser = new ArrayList<>();
        actualUser.add(user.newFirstName.getText());
        actualUser.add(user.newLastName.getText());
        actualUser.add(user.newUserName.getText());

        Assert.assertEquals(expectedNewUser, actualUser);
    }

    @When("user click on the delete button of the user with the name {string}")
    public void userClickOnTheDeleteButtonOfTheUserWithTheName(String name) {
        user.getDeleteBtn(name).click();
    }

    @And("user should click on OK button")
    public void userShouldClickOnOKButton() {
        user.okButton.click();
    }

    @Then("user should verify novak is deleted")
    public void userShouldVerifyNovakIsDeleted() {
       user.verifyUserDeleted("novak");
    }

}
