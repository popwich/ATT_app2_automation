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

import Pages.ATT_SystemSettingsPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Tests for Devices page
 */
public class ATT_SystemSettingsPageTest extends TestBase {
     private ATT_SystemSettingsPage ATT_SystemSettingsPage;
     
     @Override
     public String getName() {
         return "System settings";
     }
     
    /**
     * Sets up SystemSettings page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
    	ATT_SystemSettingsPage = new ATT_SystemSettingsPage(driver);
    }

    /**
     * Asserts the Devices page tab exists
     */
    @Test
    public void ATT_SystemSettingsPage_Tab1_checkonly() {
       	Assert.assertTrue(ATT_SystemSettingsPage.checkTab(1));   	
    }
    
    @Test
    public void ATT_SystemSettingsPage_Tab2_checkonly() {
       	Assert.assertTrue(ATT_SystemSettingsPage.checkTab(2));
    }       
    
    @Test
    public void ATT_SystemSettingsPage_Tab3_checkonly() {
       	Assert.assertTrue(ATT_SystemSettingsPage.checkTab(3));
    }     
       
    /**
     * Asserts the System settings page tab can be selected
     */
    @Test
    public void testATT_DevicesPage_Tab1_selectcheck() {
       	Assert.assertTrue(ATT_SystemSettingsPage.selectCheckTab(1));    
    }
    
    @Test
    public void testATT_SystemSettingsPage_Tab2_selectcheck() {
       	Assert.assertTrue(ATT_SystemSettingsPage.selectCheckTab(2));
    }       
    
    @Test
    public void testATT_SystemSettingsPage_Tab3_selectcheck() {
       	Assert.assertTrue(ATT_SystemSettingsPage.selectCheckTab(3));
    }        
   
 }
