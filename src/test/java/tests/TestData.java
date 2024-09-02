package tests;

import com.github.javafaker.Faker;


public class TestData {

    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String phoneNumber = faker.numerify("##########");
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = Integer.toString(faker.number().numberBetween(1950, 2000));
    public String dayOfBirth = Integer.toString(faker.number().numberBetween(1, 28));
    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = faker.address().city();
    public String genderWrapper = faker.demographic().sex();
    public String selectedHobby = faker.options().option("Sports", "Reading", "Music");
    public String selectedState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String selectedCity = getCity();

    public String getCity() {
        if ("NCR".equals(selectedState)) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if ("Uttar Pradesh".equals(selectedState)) {
            return faker.options().option("Agra", "Lucknow", "Merrit");
        } else if ("Haryana".equals(selectedState)) {
            return faker.options().option("Karnal", "Panipat");
        } else {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
    }
}
