package com.later.step_definitions;

import com.later.pages.Later.LaterPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import static com.later.utilities.LaterUtils.*;

public class LinkIcon_stepDefs {

    LaterPage laterPage = new LaterPage();

    @Then("user should be able to click product with link icon")
    public void user_should_be_able_to_click_product_with_link_icon() {

        clickRandomLinkProduct();

    }

    @Then("user should be able to click view and taken to the linked UR")
    public void userShouldBeAbleToClickViewAndTakenToTheLinkedUR() {

        for (WebElement each : laterPage.viewButtons) {
            waitFor(2);
            each.click();




        }
    }
}