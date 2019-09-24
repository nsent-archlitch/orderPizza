//@RunWith(DataProviderRunner.class)
package ru.pizzaSushiWok;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer {
    String name;
    String number;
    String metro;
    String street;
    String homeNumber;
    String change;

    Customer() {
        this.name = CustomerRegistrationTests.name;
        this.number =  CustomerRegistrationTests.number;
        this.metro =  CustomerRegistrationTests.metro;
        this.street =  CustomerRegistrationTests.street;
        this.homeNumber =  CustomerRegistrationTests.homeNumber;
        this.change =  CustomerRegistrationTests.change;
    }

    Customer(String name, String number, String metro, String street, String homeNumber, String change) {
        this.name = name;
        this.number = number;
        this.metro = metro;
        this.street = street;
        this.homeNumber = homeNumber;
        this.change = change;

    }


    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getMetro() {
        return metro;
    }

    public String getStreet() {
        return street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getChange() {
        return change;
    }

}
