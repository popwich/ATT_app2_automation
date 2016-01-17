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

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

/**
 * A page representing a static homepage
 */
public class ATT_HomePage extends BasePage{

    /**
     * The headline of the homepage
     */
    @AndroidFindBy(id = "android:id/action_bar_title")
    private WebElement headline;

    /**
     * the hamburger menu of the homepage
     */
    @AndroidFindBy(id = "android:id/home")
    private WebElement hamburger_menu;

    public ATT_HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     *
     * @return the header text content
     */
    public String getHeadlineValue() {
        return headline.getText();
    }

    /**
     * check whether is at current page
     */
    public Boolean isCurrentPage_old() {
     	try {
     		 return hamburger_menu.isDisplayed(); //return true if hamburger_menu is displayed
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
         	return false;
        }       
    }    
   
    
    /**
     * check whether is at current page - fluent wait check
     */   
    public Boolean isCurrentPage(int wait_timeout) { //fluent wait method - more flexible, user can pass in wait_timeout to specify how long to wait for certain web element to appear
    	FluentWait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
    			.withTimeout(wait_timeout, TimeUnit.SECONDS)
    			.pollingEvery(5, TimeUnit.SECONDS)
    			.ignoring(NoSuchElementException.class);
    	try {
    		Object interval = pwait.until(new Function<WebDriver, WebElement>() {
    			public WebElement apply(WebDriver d) {
    				WebElement rateButton_obj = d.findElement(By.id("android:id/home"));
    				System.out.println("home icon found"); 
    				return rateButton_obj;
    			}
    		});
    		return true;
    	} catch (TimeoutException t) {
    		System.out.println("Did not find the home icon within fluent wait time");  
    		return false;
    	}
    }
    
	public void pressMenu() {
		hamburger_menu.click();		
	}	
		
    /**
    *
    * @return the hamburger page
    */   
    public Pages.ATT_HamburgerMenuPage returnHamburgerMenuPage(){
	   return new ATT_HamburgerMenuPage(driver);
   }
}
