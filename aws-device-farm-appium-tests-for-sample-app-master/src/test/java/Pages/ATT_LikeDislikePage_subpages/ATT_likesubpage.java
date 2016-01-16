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

package Pages.ATT_LikeDislikePage_subpages;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import Pages.BasePage;
import Pages.ATT_LikeDislikePage_subpages.ATT_LikesSubPage_subpages.ATT_ratesubpage;

import com.google.common.base.Function;

/**
 * subpage after click like
 * @param <wait_timeout>
 */
public class ATT_likesubpage<wait_timeout> extends BasePage{
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/tvConfirmationDialogTitle")
    private WebElement headline;
    
    @AndroidFindBy(name = "Rate")
    private WebElement rateButton;
        
    @AndroidFindBy(name = "Remind me later")
    private WebElement remindButton;
    
    @AndroidFindBy(name = "No Thanks")
    private WebElement nothanksButton;
    
    public ATT_likesubpage(AppiumDriver driver) {
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
    public Boolean isCurrentPage(int wait_timeout) { //fluent wait method - more flexible, user can pass in wait_timeout to specify how long to wait for certain web element to appear
    	FluentWait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
    			.withTimeout(wait_timeout, TimeUnit.SECONDS)
    			.pollingEvery(5, TimeUnit.SECONDS)
    			.ignoring(NoSuchElementException.class);
    	try {
    		Object interval = pwait.until(new Function<WebDriver, WebElement>() {
    			public WebElement apply(WebDriver d) {
    				WebElement rateButton_obj = d.findElement(By.name("Rate"));
    				System.out.println("rateButton found"); 
    				return rateButton_obj;
    			}
    		});
    		return true;
    	} catch (TimeoutException t) {
    		System.out.println("Did not find the rateButton within fluent wait time");  
    		return false;
    	}
    }	

	public void clickRateButton() {
		rateButton.click();
	}
	
	public void clickRemindButton() {
		remindButton.click();
	}	
	
	public void clickNothanksButton() {
		nothanksButton.click();
	}	
	
	 /**
    *
    * @return the subpages
    */   
    public Pages.ATT_LikeDislikePage_subpages.ATT_LikesSubPage_subpages.ATT_ratesubpage returnRateSubPage(){
	   return new ATT_ratesubpage(driver);
   }
}