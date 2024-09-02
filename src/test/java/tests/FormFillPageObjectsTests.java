package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormFillPage;
import helpers.Attach;

public class FormFillPageObjectsTests extends TestBase {
    FormFillPage fillForm = new FormFillPage();
    TestData testData = new TestData();

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }


    @Test
    @Tag ("fill_form")
    void fillFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.genderWrapper)
                .setMobile(testData.phoneNumber)
                .clickSubmit()
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Gender", testData.genderWrapper)
                .checkResults("Mobile", testData.phoneNumber);
    }


    @Test
    @Tag ("fill_all")
    void fillAllFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .setMobile(testData.phoneNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject("Maths")
                .setHobby(testData.selectedHobby)
                .setPictureUpload("student.jpg")
                .setAddress(testData.currentAddress)
                .setState(testData.selectedState)
                .setCity(testData.selectedCity)
                .clickSubmit()
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Student Email", testData.userEmail)
                .checkResults("Gender", testData.genderWrapper)
                .checkResults("Mobile", testData.phoneNumber)
                .checkResults("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Music")
                .checkResults("Picture", "student.jpg")
                .checkResults("Address", testData.currentAddress)
                .checkResults("State and City", testData.selectedState + " " + testData.selectedCity);
    }

    @Test
    @Tag ("fill_negative")
    void fillFormNegativeTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .clickSubmit()
                .checkNoTable();
    }
}
