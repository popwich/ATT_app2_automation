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

package Tests;

import Pages.ATT_HomePage;
import Pages.HomePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for homepage
 */
public class ATT_HomePageTest extends TestBase {
    private final String ATT_HOMEPAGE_HEADLINE = "Hi, Melissa";
    private ATT_HomePage ATT_HomePage;

    /**
     * Sets up att_homepage
     */
    @BeforeTest
    @Override
    public void setUpPage(){
    	ATT_HomePage = new ATT_HomePage(driver);
    }

    /**
     * Asserts the att_homepage headline
     */
    @Test
    public void testATTHomePageHeadline() {
        Assert.assertEquals(ATT_HomePage.getHeadlineValue(), ATT_HOMEPAGE_HEADLINE);
    }

    /**
     * Asserts the att_homepage hamburger menu
     */
    @Test
    public void testATTHambugerMenu() {
       	Assert.assertTrue(ATT_HomePage.isCurrentPage());
    }

    @Override
    public String getName() {
        return "Home";
    }
}
