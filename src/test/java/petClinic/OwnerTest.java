package petClinic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.NewOwnersPage;
import pageObject.ownersPage;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//public class OwnerTest extends TestBase {

  //  ownersPage ownerPage;
    //Owners owner;
    //NewOwnersPage newOwnerPage;
    //String firstName = "First name";
    //String lastName = "Last name";
    //String telephone = "Phone number";
    //String isRequired = " is required";
    //String isMoreThan = " must be more than 2 characters";
    //String isDigitsOnly = "digits only";

    //@BeforeClass
    //public void beforeClass() {
      //  owner = new Owners();
        //ownerPage = new ownersPage (driver);
        //ownersPage.openPage();
        //newOwnerPage = ownersPage.clickAddOwnerBtn();
    //}

    //@Test
    //public void addNewOwnerTest() {
      //  owner.setFirstName("Shadow");
        //owner.setLastName("Moon");
        //owner.setAddress("Unknown");
        //owner.setCity("Unknown");
        //owner.setTelephone("11111111");


       // newOwnerPage.fillOwner(owner);
        //ownerPage = newOwnerPage.clickAddOwnerButton();

        //ArrayList<Owner> ownersNames = ownersPage.getOwnersList();
        //assertThat(ownersNames).contains(owner);

   // private Collection<Object> assertThat(ArrayList<Owner> ownersNames) {
    //}

    //@Test
    //public void VerifyFirstNameLength() {
      //  newOwnerPage.setFirstName("1");
        //assertThat(newOwnerPage.errorMessage(firstName + isMoreThan).isDisplayed());
    //}

    //@Test
    //public void VerifyLastNameLength() {
      //  newOwnerPage.setLastName("1");
        //assertThat(newOwnerPage.errorMessage(lastName + isMoreThan).isDisplayed());
   // }

    //@Test
    //public void VerifyPhone() {
      //  newOwnerPage.setTelephone("lsjfljlfjslfj");
        //assertThat(newOwnerPage.errorMessage(telephone + isDigitsOnly).isDisplayed());
    //}

    //@Test
    //public void VerifyFirstNameRequired() {
      //  newOwnerPage.clearField("firstName");
        //assertThat(newOwnerPage.errorMessage(firstName + isRequired).isDisplayed());
    //}

    //@Test
    //public void VerifyLastNameRequired() {
      //  newOwnerPage.clearField("Last name");
        //assertThat(newOwnerPage.errorMessage(lastName + isRequired).isDisplayed());
   // }

    //@Test
    //public void VerifyPhoneRequired() {
      //  newOwnerPage.clearField("Phone");
        //assertThat(newOwnerPage.errorMessage(telephone + isRequired).isDisplayed());
    //}
//}
