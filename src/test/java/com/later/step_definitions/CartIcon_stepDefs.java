package com.later.step_definitions;

import com.later.pages.Later.LaterPage;
import com.later.utilities.Driver;
import com.later.utilities.LaterUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.later.utilities.LaterUtils.waitFor;
import static com.later.utilities.LaterUtils.waitForClickablility;


public class CartIcon_stepDefs {


    LaterPage laterPage = new LaterPage();
    int dropdownSize = laterPage.dropdowns.size();
    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        //set up the environment
        LaterPage.setUp();
    }
    @Then("user should be able to click product with cart icon")
    public void user_should_be_able_to_click_product_with_cart_icon() {
        // use clickRandomCartProduct method to randomly click cart icon products
        LaterUtils.clickRandomCartProduct();

    }
    @Then("user should click add to cart")
    public void user_should_click_add_to_cart() {

        //amount of options in each select dropdown
        int optionsSize = laterPage.dropdownOptions.size();
        //amount of possible item types
        int itemTypeSize = laterPage.itemType.size();



        // if addToCard button is enabled then click else means there is a dropdown
        if (!laterPage.addToCartButton.getAttribute("class").contains("disabled")) {
            laterPage.addToCartButton.click();
            waitFor(3);
        } else {
            //first check if the item has more than one option
            if(itemTypeSize > 1){
                //use randomSelect() method to randomly select values from item options
                LaterUtils.randomSelect(itemTypeSize,laterPage.itemType);
                waitFor(2);
            }

            // if there is one dropdown in the list then use one Select
            if (laterPage.dropdowns.size() == 1) {
                  LaterUtils.randomSelect(optionsSize,laterPage.dropdownOptions);
            } else {
                for (int i = 0; i <= dropdownSize; i++) {

                    //use randomSelect() method to randomly select values from dropdowns
                    LaterUtils.randomSelect(optionsSize, laterPage.dropdownOptions);
                }

            }



            // click to addToCard button
            waitFor(3);
            laterPage.addToCartButton.click();
        }

    }

    @And("user verifies products have conventional e-commerce functionality")
    public void userVerifiesProductsHaveConventionalECommerceFunctionality() {
        String expectedItemName = laterPage.expectedItemName.getText();
        String expectedItemPrice = laterPage.expectedItemPrice.getText();

        int infoSize = laterPage.expectedProductInfo.size();

        String infoWithOneOption = "";
        String infoWithMoreOption = "";
        String expectedInfo = "";

        //for loop for going through product info size and concatenation the string for expected output
        for (int i = 0; i <infoSize - 1; i++) {

            waitFor(2);
            if (infoSize <=2) {
                infoWithOneOption = laterPage.expectedProductInfo.get(i).getText();
            }else {
                // add " / " in between string if there are more than one info
                infoWithMoreOption += laterPage.expectedProductInfo.get(i).getText() + " / ";
            }
        }

        //assign your string
        if(infoSize==2){
            expectedInfo = infoWithOneOption;
        }else if(infoSize==3){
            // substring your string so you don't have " / " at the end of the string
            expectedInfo = infoWithMoreOption.substring(0,infoWithMoreOption.length()-3);
        }

        waitFor(3);
        String actualItemName = laterPage.actualItemName.getText();
        String actualItemPrice = laterPage.actualPrice.getText();
        String actualInfo = laterPage.actualInfo.getText();


        System.out.println("expectedItemName = " + expectedItemName);
        System.out.println("expectedItemPrice = " + expectedItemPrice);
        System.out.println("expectedInfo = " + expectedInfo);
        System.out.println("actualItemName = " + actualItemName);
        System.out.println("actualItemPrice = " + actualItemPrice);
        System.out.println("actualInfo = " + actualInfo);


        Assert.assertEquals(expectedItemName,actualItemName);
        Assert.assertEquals(expectedItemPrice,actualItemPrice);
        Assert.assertEquals(expectedInfo,actualInfo);


    }


        @Then("user should be able to checkout")
        public void userShouldBeAbleToCheckout () {

            //click on checkout button
            waitForClickablility(laterPage.checkout,3);
            laterPage.checkout.click();
            waitFor(2);

            //verify user is on the checkout page
            Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));
        }

    }
