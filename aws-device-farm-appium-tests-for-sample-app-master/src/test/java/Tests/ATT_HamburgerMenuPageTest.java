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
import Pages.ATT_HamburgerMenuPage;
import Pages.AlertPage;
import Pages.HomePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Tests for HamburgerMenuPage
 */
public class ATT_HamburgerMenuPageTest extends TestBase {
     private ATT_HamburgerMenuPage ATT_HamburgerMenuPage;
     
     @Override
     public String getName() {
         return "HamburgerMenu Page";
     }
     
    /**
     * Sets up att_hamburgermenupage
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        ATT_HamburgerMenuPage = new ATT_HamburgerMenuPage(driver);
    }

    /**
     * Asserts the att_homepage hamburger menu
     */
    @Test
    public void testATTHambuger_menuHome() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuHome());
    }
    
    @Test
    public void testATTHambuger_menuDevices() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuDevices());
    }
    
    @Test
    public void testATTHambuger_menuPrograms() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuPrograms());
    }
    
    @Test
    public void testATTHambuger_menuMyaccount() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuMyaccount());
    }
    
    @Test
    public void testATTHambuger_menuSystemsettings() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuSystemsettings());
    }
    
    @Test
    public void testATTHambuger_menuSignout() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuSignout());
    }
    
    @Test
    public void testATTHambuger_menuREPORTEMERGENCY() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuREPORTEMERGENCY());
    }
    
    @Test
    public void testATTHambuger_menuSolutioncenter() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuSolutioncenter());
    }
    
    @Test
    public void testATTHambuger_menuOtherservicesdevices() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuOtherservicesdevices());
    }
    
    @Test
    public void testATTHambuger_menuDigitalLifeTour() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuDigitalLifeTour());
    }
    
    @Test
    public void testATTHambuger_menuLegal() {
       	Assert.assertTrue(ATT_HamburgerMenuPage.checkHamburger_menuLegal());
    }
 }
