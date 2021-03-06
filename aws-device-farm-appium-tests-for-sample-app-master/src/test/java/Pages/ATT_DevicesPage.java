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

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

/**
 * A page representing a static homepage
 */
public class ATT_DevicesPage extends BasePage{
	
    @AndroidFindBy(name = "All devices")
    private WebElement Tab_Alldevices;

    @AndroidFindBy(name = "Cameras")
    private WebElement Tab_Cameras;
 
    @AndroidFindBy(name = "Device log")
    private WebElement Tab_Devicelog;
    
    @AndroidFindBy(name = "Device settings")
    private WebElement Tab_Devicesettings;
    
    public ATT_DevicesPage(AppiumDriver driver) {
        super(driver);
    }
    
    public Boolean checkTab(int tab_no) {
    	switch (tab_no) {
        case 1:  
        	return (Tab_Alldevices.isDisplayed() && Tab_Alldevices.isEnabled());
        case 2:
        	return (Tab_Cameras.isDisplayed() && Tab_Cameras.isEnabled());
        case 3:
        	return (Tab_Devicelog.isDisplayed() && Tab_Devicelog.isEnabled());
        case 4:
        	return (Tab_Devicesettings.isDisplayed() && Tab_Devicesettings.isEnabled());	    
    	}
    	return null;
    } 
    
    public Boolean selectCheckTab(int tab_no){
    	switch (tab_no) {
        case 1:  Tab_Alldevices.click();
        	return Tab_Alldevices.isSelected();
        case 2: Tab_Cameras.click();
        	return Tab_Cameras.isSelected();
        case 3: Tab_Devicelog.click();
    		return Tab_Devicelog.isSelected();
        case 4: Tab_Devicesettings.click();
			return Tab_Devicesettings.isSelected();
    	}
		return null;
    }
 }

