//@RunWith(DataProviderRunner.class)
package ru.pizzaSushiWok;


//import org.fluentlenium.configuration.WebDriverFactory;
import org.fluentlenium.configuration.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import ru.st.selenium.*;
//import ru.st.selenium.webdriver.WebDriverFactory;
//import com.selenium.test.*;

import java.util.HashMap;

//@UseDataProvider()
public class TestBase {
    /*
     public static WebDriver setDriver()
     {

         WebDriverFactory.startBrowser(true);

         return  WebDriverFactory.getDriver();
     }
     public static WebDriver driver = setDriver(); */



    public static HashMap<String, String> hashMap = new HashMap<>();


    public static void fillTheMap() {
        hashMap.put("Пепперони", "pizza-name-6");
        hashMap.put("Жульетта", "pizza-name-17");
        hashMap.put("4 Сыра", "pizza-name-11");
        hashMap.put("Барбекю", "pizza-name-279");
        hashMap.put("Вкусная", "pizza-name-404");
        hashMap.put("Дьябло", "pizza-name-593");
    }

    public static final String urlPizza = "https://pizzasushiwok.ru/pizza";
    public static final String urlCart = "https://pizzasushiwok.ru/cart";



    public static final ChromeDriver driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
    public static final WebDriverWait wait = new WebDriverWait(driver, 10);


    public void goTo(String url) throws Exception {

        driver.get(url);
        waitSec(2);
    }

    public void findPizza(String id) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id)))).click(); //addtocard

    }

    public void pushTheButton(String className) {
        WebElement element = driver.findElement(By.className(className));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void addToCard() {
        pushTheButton("noselect");
    }

    public void waitSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    public void choosePizza(String name) throws Exception {
        String id = hashMap.get(name);
        findPizza(id);
        addToCard();
        waitSec(2);

    }


    public void receiveOrder(CustomerOrder customerOrder) throws Exception {
        for (String pizzaName :
                customerOrder.order) {
            goTo(urlPizza);
            choosePizza(pizzaName);
            System.out.println("В заказе есть " + pizzaName);
        }

    }

    public void confirm() throws Exception {
        pushTheButton("btn");
        waitSec(2);
    }

    public void fillTheForm(Customer customer) throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_name"))).sendKeys(customer.getName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_phone"))).sendKeys(customer.getNumber());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_metro"))).sendKeys(customer.getMetro());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_street"))).sendKeys(customer.getStreet());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_home_user"))).sendKeys(customer.getHomeNumber());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("order_change"))).sendKeys(customer.getChange());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order_form\"]/div[1]/div/div/div[8]/div/div/textarea"))).sendKeys("Еей, неужели этот маленький бот доехал до конца и нигде по дороге не умер)))");
        waitSec(10);

    }


    public void quit() {
        driver.quit();
    }
}
