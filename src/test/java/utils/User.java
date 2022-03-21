package utils;

import com.github.javafaker.Faker;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    private final Faker faker = new Faker();

    public User() {
        this.firstName = faker.name().firstName();;
        this.lastName = faker.name().lastName();;
        this.email = faker.internet().emailAddress();;
        this.phone = faker.phoneNumber().phoneNumber();;
        this.password = faker.internet().password();;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
