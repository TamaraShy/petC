package petClinic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.SpecPage;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SpecTest extends TestBase {

    Spec specialties;
    SpecPage specialtiesPage;


    @BeforeClass
    public void beforeClass() {
        specialties = new Spec();
        specialtiesPage = new SpecPage(driver);
        specialtiesPage.openPage();
        specialtiesPage.clickAddSpecialitiestButton();
    }


    @Test
    public void verifyAddNewSpecialist()    {
        specialtiesPage.addSpeciality("Teacher");

        assertFalse(specialtiesPage.verifySaveBtnIsDisabled());
    }

    @Test
    public void verifySpecNameIsRequired()    {
        specialtiesPage.addSpeciality("");
        assertTrue(specialtiesPage.verifySaveBtnIsDisabled());
    }
}
