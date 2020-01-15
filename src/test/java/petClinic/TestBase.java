package petClinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObject.ownersPage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";
    public WebDriver driver;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected ownersPage goToOwnersPage() {
        goToUrl(BASE_URL + "/owners", "Owners");
        return new ownersPage(driver);
    }

    protected void goToNewOwnerPage() {
        goToUrl(BASE_URL + "/owners/add", "New Owner");
    }

    protected void goToVetsPage() {
        goToUrl(BASE_URL + "/vets", "Veterinarians");
    }

    protected void goToPetTypesPage() {
        goToUrl(BASE_URL + "/pettypes", "Pet Types");
    }

    protected void goToSpecialtiesPage() {
        goToUrl(BASE_URL + "/specialties", "Specialties");
    }

    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 5);
    }

    private void goToUrl(String url, String title) {
        driver.get(url);
        waitFor().withMessage(title + " page is not opened!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

    protected void setField(String fieldValue, String fieldName, By fieldPath) {
        WebElement field = driver.findElement(fieldPath);
        field.clear();
        field.sendKeys(fieldValue);
    }
}
