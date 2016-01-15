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

public class ATT_HamburgerMenuPage extends BasePage{
	@AndroidFindBy(id = "com.att.digitallife.android.phone22:id/alarm_tab_text1") 
    private WebElement alarm_tab;
	
	@AndroidFindBy(name = "ARMING") 
    private WebElement arming_in_progress;
			
	@AndroidFindBy(name = "DISARMING") 
    private WebElement disarming_in_progress;
	
    @AndroidFindBy(name = "Home")
    private WebElement menuHome;

    @AndroidFindBy(name = "Devices")
    private WebElement menuDevices;
 
    @AndroidFindBy(name = "Programs")
    private WebElement menuPrograms;
    
    @AndroidFindBy(name = "My account")
    private WebElement menuMyaccount;
    
    @AndroidFindBy(name = "System settings")
    private WebElement menuSystemsettings;
    
    @AndroidFindBy(name = "Sign out")
    private WebElement menuSignout;
    
    @AndroidFindBy(name = "REPORT EMERGENCY")
    private WebElement menuREPORTEMERGENCY;
    
    @AndroidFindBy(name = "Solution center")
    private WebElement menuSolutioncenter;
    
    @AndroidFindBy(name = "Other services & devices")
    private WebElement menuOtherservicesdevices;
    
    @AndroidFindBy(name = "Digital Life Tour")
    private WebElement menuDigitalLifeTour;
    
    @AndroidFindBy(name = "Legal")
    private WebElement menuLegal;

    public ATT_HamburgerMenuPage(AppiumDriver driver) {
        super(driver);
    }
    
    /****************************************************
    ****************************************************/
    public Boolean isArmed() {
        return (alarm_tab.getText() == "ARMED: ");  //there is a space behind ARMED
    }
    
    public Boolean isArming() {
        return arming_in_progress.isDisplayed(); 
    }    
    
    public Boolean isDisarming() {
        return disarming_in_progress.isDisplayed(); 
    }  
    /****************************************************
    ****************************************************/
 
    public Boolean checkHamburger_menuHome() {
        return menuHome.isDisplayed();
    }
    
    public Boolean checkHamburger_menuDevices() {
        return menuDevices.isDisplayed();
    }
    
    public Boolean checkHamburger_menuPrograms() {
        return menuPrograms.isDisplayed();
    }
    
    public Boolean checkHamburger_menuMyaccount() {
        return menuMyaccount.isDisplayed();
    }
    
    public Boolean checkHamburger_menuSystemsettings() {
        return menuSystemsettings.isDisplayed();
    }
        
    public Boolean checkHamburger_menuSignout() {
        return menuSignout.isDisplayed();
    }
    
    public Boolean checkHamburger_menuREPORTEMERGENCY() {
        return menuREPORTEMERGENCY.isDisplayed();
    }
    
    public Boolean checkHamburger_menuSolutioncenter() {
        return menuSolutioncenter.isDisplayed();
    }
    
    public Boolean checkHamburger_menuOtherservicesdevices() {
        return menuOtherservicesdevices.isDisplayed();
    }
    
    public Boolean checkHamburger_menuDigitalLifeTour() {
        return menuDigitalLifeTour.isDisplayed();
    }
    
    public Boolean checkHamburger_menuLegal() {
        return menuLegal.isDisplayed();
    }
    
    public void signout() {
         menuSignout.click();
    }
    
    /**
    *
    * @return the HamburgerMenuPage_alarmtab_expanded page
    */   
    public Pages.ATT_HamburgerMenuPage_alarmtab_expanded returnHamburgerMenuPage_alarmtab_expanded(){
    	alarm_tab.click();
	    return new ATT_HamburgerMenuPage_alarmtab_expanded(driver);
   }
}

