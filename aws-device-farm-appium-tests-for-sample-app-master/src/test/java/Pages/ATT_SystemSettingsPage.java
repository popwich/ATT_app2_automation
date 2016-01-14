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
public class ATT_SystemSettingsPage extends BasePage{
	
    @AndroidFindBy(name = "Overview")
    private WebElement Tab_Overview;

    @AndroidFindBy(name = "Global preferences")
    private WebElement Tab_Globalpreferences;
 
    @AndroidFindBy(name = "User profiles")
    private WebElement Tab_Userprofiles;
    
    public ATT_SystemSettingsPage(AppiumDriver driver) {
        super(driver);
    }
    
    public Boolean checkTab(int tab_no) {
    	switch (tab_no) {
        case 1:  
        	return (Tab_Overview.isDisplayed() && Tab_Overview.isEnabled());
        case 2:
        	return (Tab_Globalpreferences.isDisplayed() && Tab_Globalpreferences.isEnabled());
        case 3:
        	return (Tab_Userprofiles.isDisplayed() && Tab_Userprofiles.isEnabled());
       }
    	return null;
    } 
    
    public Boolean selectCheckTab(int tab_no){
    	switch (tab_no) {
        case 1:  Tab_Overview.click();
        	return Tab_Overview.isSelected();
        case 2: Tab_Globalpreferences.click();
        	return Tab_Globalpreferences.isSelected();
        case 3: Tab_Userprofiles.click();
    		return Tab_Userprofiles.isSelected();
     	}
		return null;
    }
 }

