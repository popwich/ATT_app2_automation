/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * A page representing a static homepage
 */
public class ATT_HomePage extends BasePage{

    /**
     * The headline of the homepage
     */
    @AndroidFindBy(id = "android:id/action_bar_title")
    private WebElement headline;

    /**
     * the hamburger menu of the homepage
     */
    @AndroidFindBy(id = "android:id/home")
    private WebElement hamburger_menu;

    public ATT_HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return the header text content
     */
    public String getHeadlineValue() {
        return headline.getText();
    }

    /**
     */
    public Boolean checkHamburgerMenu() {
        return hamburger_menu.isDisplayed(); //return true if hamburger_menu is displayed
    }
}
