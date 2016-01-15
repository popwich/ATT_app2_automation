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
 * EnterPin page inherited from HamburgerMenuPage as result of Arming 
 */
public class ATT_SystemCannotTurnOnPage extends BasePage{
    @AndroidFindBy(name = "System Cannot Turn On")
    private WebElement systemcannotturnon;
        
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/bypassButton")
    private WebElement bypassButton;
    
    public ATT_SystemCannotTurnOnPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * check whether is at current page
     */
    public Boolean isCurrentPage() {
      	try {
      		return systemcannotturnon.isDisplayed(); 
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
         	return false;
        }
    }	
    
	public void clickBypassButton() {
		bypassButton.click();
	}	
}