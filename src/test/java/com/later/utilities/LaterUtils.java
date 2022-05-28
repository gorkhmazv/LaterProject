package com.later.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LaterUtils {

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Randomly clicks items that have CART icon
     */
    public static void clickRandomCartProduct() {

        //choose random file with cart icon and click
        List<WebElement> elementsWithCartImg = Driver.getDriver().findElements(By.xpath("//img[@alt='Shopify Link']//.."));
        int randomNumber = new Faker().number().numberBetween(1, elementsWithCartImg.size());
        Driver.getDriver().findElement(By.xpath("(//img[@alt='Shopify Link']//..)[4]")).click();

        waitFor(3);
    }

    /**
     * Randomly clicks items that have LINK icon
     */
    public static void clickRandomLinkProduct() {

        //choose random file with link icon and click
        List<WebElement> elementsWithLinkImg = Driver.getDriver().findElements(By.xpath("//img[@alt='Link']//.."));
        int randomNumber = new Faker().number().numberBetween(1, elementsWithLinkImg.size());
        Driver.getDriver().findElement(By.xpath("(//img[@alt='Link']//..)["+randomNumber+"]")).click();

        waitFor(3);
    }

    /**
     *
     * selects random value
     * @param n
     * @param list
     */
    public static void randomSelect(int n, List<WebElement> list){

        //create random value to be able to select different options
        int randomNumber = ThreadLocalRandom.current().nextInt(0, n);

        // Selecting random value
        list.get(randomNumber).click();
        waitFor(2);
    }

}
