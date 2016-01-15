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

public class ATT_HamburgerMenuPage_alarmtab_expanded extends BasePage{
	@AndroidFindBy(id = "com.att.digitallife.android.phone22:id/alarm_subtab_stay_text2") 
    private WebElement alarm_subtab_stay;
	
	@AndroidFindBy(id = "com.att.digitallife.android.phone22:id/alarm_subtab_away_text2") 
    private WebElement alarm_subtab_away;
	
	@AndroidFindBy(id = "com.att.digitallife.android.phone22:id/alarm_subtab_instant_text2") 
    private WebElement alarm_subtab_instant;
		
	@AndroidFindBy(id = "com.att.digitallife.android.phone22:id/alarm_subtab_disarmhome_text2") 
    private WebElement alarm_subtab_disarmhome;
	
    public ATT_HamburgerMenuPage_alarmtab_expanded(AppiumDriver driver) {
        super(driver);
    }
    
    public void armSystem() {
    	alarm_subtab_stay.click(); //use whichever to arm the system
    }
    
    public void disarmSystem() {
    	alarm_subtab_disarmhome.click(); //disarm the system
    }
 
    /**
    *
    * @return the EnterPin page
    */   
    public Pages.ATT_EnterPinPage returnEnterPinPage(){
	   return new ATT_EnterPinPage(driver);
   }
}

