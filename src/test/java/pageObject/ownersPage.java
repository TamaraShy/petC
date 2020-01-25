package pageObject;

import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import petClinic.Owners;

import java.security.acl.Owner;
import java.util.ArrayList;

public class ownersPage extends BasePage{
    private By addOwnerBtnPath = By.xpath("//*[text()='Add Owner']");
    private static By ownersTablePath = By.cssSelector(".ownerFullName>a");

    public ownersPage (WebDriver driver) {
        super(driver);
    }

    public ownersPage openPage() {
        goToUrl("/owners", "Owners");
        return this;
    }

    public List<String> getOwnersNames() {
        List<String> Owners = new List<>();
        waitUtilTableVisible(ownersTablePath);
        java.util.List<WebElement> elements = driver.findElements(ownersTablePath);
        for (WebElement fullName : elements) {
            Owners.add(fullName.getText());
        }

        return Owners;
    }

    public ArrayList<Owner> getOwnersList() {
        ArrayList<Owner> owners = new ArrayList<>();
        WebElement ownersTable = driver.findElement(By.xpath("//*[@class='table-responsive']"));
        waitUtilTableVisible(ownersTablePath);
        java.util.List<WebElement> ownersList = ownersTable.findElements(By.xpath(".//tbody/tr"));
        for (WebElement userRow : ownersList) {
            owners.add((Owner) createOwner(userRow));
        }

        return owners;
    }

    public NewOwnersPage clickAddOwnerBtn() {
        WebElement addOwnerBtn = driver.findElement(addOwnerBtnPath);
        waitUntilClickable("Add Owner", addOwnerBtnPath);
        addOwnerBtn.click();
        return new NewOwnersPage(driver);
    }

    private Owners createOwner(WebElement userRow) {
        Owners owners = new Owners();
        String fullName = userRow.findElement(By.xpath("./td/a")).getText();
        String[] fullNameArray = fullName.split(" ");
        if (fullNameArray.length > 1) {
            owners.setFirstName(fullNameArray[0]);
            owners.setLastName(fullNameArray[1]);
        } else {
            owners.setFirstName(fullNameArray[0]);
        }
        owners.setAddress(userRow.findElement(By.xpath("./td[2]")).getText());
        owners.setCity(userRow.findElement(By.xpath("./td[3]")).getText());
        owners.setTelephone(userRow.findElement(By.xpath("./td[4]")).getText());

        String pets = userRow.findElement(By.xpath("./td[5]")).getText();
        if (!pets.isEmpty()) {
            owners.setPets(pets);
        }

        return owners;
    }
}