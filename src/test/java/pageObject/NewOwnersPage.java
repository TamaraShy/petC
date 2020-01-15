package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import petClinic.Owners;

import java.security.acl.Owner;

public class NewOwnersPage {

    private WebDriver driver;
    private WebDriverWait waitFor;
    private WebElement lastNameField;
    private By firstNameId = By.id("firstName");
    private By lastNameId = By.id("lastName");
    private By addressId = By.id("address");
    private By telephoneId = By.id("telephone");
    private By cityId = By.id("city");
    private By addOwnerButton = By.xpath("//*[text()='Add Owner']");

    public NewOwnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public By returnByForField(String fieldName) {
        switch (fieldName) {
            case "Last name":
                return lastNameId;
            case "Address":
                return addressId;
            case "City":
                return cityId;
            case "Phone":
                return telephoneId;
            default:
                return firstNameId;
        }
    }

    public void fillOwner(Owners owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }


    public void setFirstName(String firstName) {
        WebElement name = driver.findElement(firstNameId);
        name.clear();
        name.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastNameId);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clearField(String fieldName) {
        WebElement nameField = driver.findElement(returnByForField(fieldName));
        nameField.sendKeys("234");
        while (nameField.getAttribute("value").length() > 0) {
            nameField.sendKeys("\u0008");
        }
    }


    public void setAddress(String address) {
        WebElement addressField = driver.findElement(addressId);
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void setCity(String city) {
        WebElement cityField = driver.findElement(cityId);
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void setTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(telephoneId);
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

   public ownersPage clickAddOwnerButton() {
       WebElement addOwnerBtn = driver.findElement(addOwnerButton);
       waitFor = new WebDriverWait(driver,1);
       waitFor.until(ExpectedConditions.elementToBeClickable(addOwnerButton));
       addOwnerBtn.click();
       return new ownersPage(driver);
    }

    public WebElement errorMessage(String errorMessage) {
        By xpathErrorMessage = By.xpath("//*[@class='help-block'][text()='" + errorMessage + "']");
        waitFor = new WebDriverWait(driver,1);
        waitFor.until(ExpectedConditions.textToBePresentInElementLocated(xpathErrorMessage, errorMessage));
        WebElement errorMessageElement = driver.findElement(xpathErrorMessage);
        return errorMessageElement;
    }

}
