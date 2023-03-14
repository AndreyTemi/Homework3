package tests;

import com.github.javafaker.Faker;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestDataDemoQA {

    Faker faker = new Faker();
    String firstName, lastName, userEmail, userPhoneNumber, subject, currentAddress, city, state, gender,
            birthDateDay, birthDateMonth, birthDateYear, file, hobbies;

    String[] subjects, cities, setHobbies;
    Date birthDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd", new Locale("en"));
    public void setBirthDate() {
        birthDate = faker.date().birthday();
        birthDateDay = sdf.format(birthDate);
        sdf.applyPattern("M");
        birthDateMonth = sdf.format(birthDate);
        sdf.applyPattern("yyyy");
        birthDateYear = sdf.format(birthDate);
    }

    public void setStateAndCity() {
        Map<String, String[]> stateAndCity = new HashMap<>();

        stateAndCity.put("NCR", new String[] {"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Haryana", new String[] {"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[] {"Jaipur", "Jaiselmer"});

        state = faker.options().option(stateAndCity.keySet().toArray()).toString();
        city = faker.options().option(stateAndCity.get(state));
    }
    public void setTestData()
    {
        subjects = new String[] {"English", "Arts", "Commerce", "Social Studies", "Accounting", "Hindi"};
        cities = new String[] {"Delhi", "Gurgaon", "Noida"};
        setHobbies = new String[] {"sports", "music", "reading"};
        file = "test.png";
        hobbies = "Sports, Reading, Music";
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
        subject = faker.options().option(subjects);
        currentAddress = faker.address().fullAddress();
        city = faker.options().option(cities);
        gender = faker.demographic().sex();

        setBirthDate();
        setStateAndCity();
    }
}
