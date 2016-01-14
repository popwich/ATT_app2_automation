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

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A login page
 */
public class ATT_LicenseAgreementPage extends BasePage {
    /**
     * The 'i have read and agree to the license agreement' button
     */
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/acceptEULAButton")
    private MobileElement licenseAgreementButton;

    /**
     * The headline of this page
     */
    @AndroidFindBy(name = "License Agreement")
    private WebElement headline;
        
    public ATT_LicenseAgreementPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * press agree button
     */
    public void clickAgree(){
    	licenseAgreementButton.click();
    }

    /**
     *
     * @return the login message
     */    
    public String getMessage(){
    	return driver.findElementById("com.att.digitallife.android.phone22:id/userName").getText();
    }
    
    /**
    *
    * @return the login page - lee tbd
    */   
   public Pages.ATT_LoginPage returnLoginPage(){
	   return new ATT_LoginPage(driver);
   }
}
