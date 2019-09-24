package ru.pizzaSushiWok;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class OrderPizza extends TestBase {


    @Before
    public void beforeTest()
    {
        System.out.println("Поехали");
        fillTheMap();    }

    @Test
    public void firstTest() throws Exception {
        goTo(urlPizza);
        receiveOrder(new CustomerOrder());
        goTo(urlCart);
        confirm();
        fillTheForm( new Customer()); //name, number, metro, street, homeNumber, change

    }

    @After
    public void afterTest()
    {
        System.out.println("Заказ оформлен");
        quit();

    }


}