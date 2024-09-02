package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormFillPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userMobileInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement hobbyChoosing = $("#hobbiesWrapper");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement tableResults = $(".table-responsive");
    private final SelenideElement checkResults = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    public FormFillPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FormFillPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FormFillPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FormFillPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FormFillPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FormFillPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public FormFillPage setMobile(String value) {
        userMobileInput.setValue(value);
        return this;
    }

    public FormFillPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormFillPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public FormFillPage setHobby(String value) {
        hobbyChoosing.$(byText(value)).click();
        return this;
    }

    public FormFillPage setPictureUpload(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public FormFillPage setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public FormFillPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public FormFillPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public FormFillPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public FormFillPage checkNoTable() {
        tableResults.shouldNotBe(visible);
        return this;
    }

    public FormFillPage checkResults(String key, String value) {
        checkResults.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
