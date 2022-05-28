package com.later.pages.Later;

import com.later.utilities.ConfigurationReader;
import com.later.utilities.Driver;
import com.later.utilities.LaterUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaterPage {

    public LaterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        LaterUtils.waitFor(3);
    }

    @FindBy(xpath = "//span[@class='cDT--list__btn']")
    public List<WebElement> viewButtons;

    @FindBy(xpath = "//div[@class='cDT--post__btn']/a")
    public WebElement addToCartButton;

    // store the dropdowns in a list
    @FindBy(xpath = "//select[@class='o--form__select']")
    public List<WebElement> dropdowns;

    @FindBy(xpath = "//select[@class='o--form__select']//option")
    public List<WebElement> dropdownOptions;

    @FindBy(xpath = "//select[@class='o--form__select']//option")
    public WebElement dropdownOption;

    @FindBy(xpath = "(//select[@class='o--form__select'])[1]")
    public WebElement selectDropdown;

    @FindBy(xpath = "//div[@class='cDT--post__thumbnails']/div")
    public List<WebElement> itemType;

    @FindBy(xpath = "(//a[.='Checkout'])[2]")
    public WebElement checkout;

    @FindBy(xpath = "//*[@class='cDT--post__title']")
    public WebElement expectedItemName;

    @FindBy(xpath = "(//span[@class='cSC--li__title'])[1]")
    public WebElement actualItemName;
    @FindBy(xpath = "//*[@class='cDT--post__price u--m__b__lg']")
    public WebElement expectedItemPrice;

    @FindBy(xpath = "(//span[@class='cSC--li__price'])[1]")
    public WebElement actualPrice;

    @FindBy(xpath = "//div[@class='o--formWrapper']/p")
    public List<WebElement> expectedProductInfo;

    @FindBy(xpath = "(//div[@class='cSC--li__variant-title'])[1]")
    public WebElement actualInfo;




}
