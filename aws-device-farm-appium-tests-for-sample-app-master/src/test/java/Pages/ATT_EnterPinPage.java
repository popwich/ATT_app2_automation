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
public class ATT_EnterPinPage extends BasePage{
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/enter_pin")
    private WebElement enter_pin;
    
    @AndroidFindBy(name = "1")
    private WebElement number1;
    
    @AndroidFindBy(name = "2")
    private WebElement number2;
    
    @AndroidFindBy(name = "3")
    private WebElement number3;
    
    @AndroidFindBy(name = "4")
    private WebElement number4;
    
    @AndroidFindBy(name = "5")
    private WebElement number5;
        
    @AndroidFindBy(name = "6")
    private WebElement number6;        
    
    @AndroidFindBy(name = "7")
    private WebElement number7;
    
    @AndroidFindBy(name = "8")
    private WebElement number8;
    
    @AndroidFindBy(name = "9")
    private WebElement number9;
    
    @AndroidFindBy(name = "0")
    private WebElement number0;    
    
    public ATT_EnterPinPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * check whether is at current page
     */
    public Boolean isCurrentPage() {
      	try {
      		return enter_pin.isDisplayed(); //return true if enter_pin element is found which means we are EnterPinPage
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
         	return false;
        }
    }
		
    /**
    *
    * @return the SystemCannotTurnOn page
    */   
    public Pages.ATT_SystemCannotTurnOnPage returnSystemCannotTurnOnPage(){
	   return new ATT_SystemCannotTurnOnPage(driver);
   }
}
