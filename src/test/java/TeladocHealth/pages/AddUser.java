package TeladocHealth.pages;

import TeladocHealth.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddUser {

    public AddUser(){PageFactory.initElements(Driver.get(), this); }

    @FindBy(xpath = "//*[contains(@class,'btn btn-link pull-right')]")
    public WebElement AddUserBtn;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password;

    @FindBy(xpath = "//label[@class='radio ng-scope ng-binding'][1]")
    public WebElement companyAAA;

    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement role;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement cellPhone;

    @FindBy(xpath = "//button[contains(@class, 'btn-success') and text()='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "/html/body/table/tbody/tr[1]")
    public WebElement row;


    //row verification for new user
    @FindBy(xpath = "//body/table/tbody/tr[1]/td[1]")
    public WebElement newFirstName;
    @FindBy(xpath = "//body/table/tbody/tr[1]/td[2]")
    public WebElement newLastName;
    @FindBy(xpath = "//body/table/tbody/tr[1]/td[3]")
    public WebElement newUserName;


    /**
     * returns the delete button the user we want to delete dynamic
     * @param name
     * @return
     */

    public WebElement getDeleteBtn (String name){
        String locator = "//td[text()='"+name+"']/../td[last()]/button";
        return Driver.get().findElement(By.xpath(locator));
    }

    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//tr//td[3]")
    public List<WebElement> userNames;

    //
    public void verifyUserDeleted (String name){
        for (WebElement userName : userNames) {
            Assert.assertFalse(userName.getText().equals(name));
            System.out.println(userName.getText());

        }
    }














}
