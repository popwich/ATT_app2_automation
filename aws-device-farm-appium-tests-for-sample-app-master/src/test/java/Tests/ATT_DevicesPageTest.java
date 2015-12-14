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

import Pages.ATT_DevicesPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Tests for Devices page
 */
public class ATT_DevicesPageTest extends TestBase {
     private ATT_DevicesPage ATT_DevicesPage;
     
     @Override
     public String getName() {
         return "Devices";
     }
     
    /**
     * Sets up Devices page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
    	ATT_DevicesPage = new ATT_DevicesPage(driver);
    }

    /**
     * Asserts the Devices page tab
     */
    @Test
    public void testATT_DevicesPage_Tab1() {
       	Assert.assertTrue(ATT_DevicesPage.checkTab_Alldevices());
    }
    
    @Test
    public void testATT_DevicesPage_Tab2() {
       	Assert.assertTrue(ATT_DevicesPage.checkTab_Cameras());
    }
    
    
    
    @Test
    public void testATT_DevicesPage_Tab3() {
       	Assert.assertTrue(ATT_DevicesPage.checkTab_Devcelog());
    }
    
 
    @Test
    public void testATT_DevicesPage_Tab4() {
       	Assert.assertTrue(ATT_DevicesPage.checkTab_Devicesettings());
    }
   
 }
