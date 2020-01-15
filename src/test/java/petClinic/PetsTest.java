package petClinic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.PetsPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class PetsTest extends TestBase {

    Pets pets;
    PetsPage petsPage;


    @BeforeClass
    public void beforeClass() {
        pets = new Pets();
        petsPage = new PetsPage(driver);
        petsPage.openPage();
        petsPage.clickAddPetButton();
    }


    @Test
    public void verifyAddNewPet()    {
        petsPage.addPet("Mouse");
        assertFalse(petsPage.verifySaveBtnIsDisabled());
    }
    @Test
    public void verifyPetNameIsRequired()    {
        petsPage.addPet("");
        assertTrue(petsPage.verifySaveBtnIsDisabled());
    }
}
