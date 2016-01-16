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
 * likedislike page for foresee page 
 * @param <wait_timeout>
 */
public class ATT_LikeDislikePage<wait_timeout> extends BasePage{
    @AndroidFindBy(name = "Like")
    private WebElement likeButton;
        
    @AndroidFindBy(name = "Dislike")
    private WebElement dislikeButton;
    
    @AndroidFindBy(name = "No Thanks")
    private WebElement nothanksButton;
    
    public ATT_LikeDislikePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * check whether is at current page
     */
    public Boolean isCurrentPage_old() {
      	try {
      		return likeButton.isDisplayed(); 
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
         	return false;
        }
    }	
    
    public Boolean isCurrentPage(int wait_timeout) { //fluent wait method - more flexible, user can pass in wait_timeout to specify how long to wait for certain web element to appear
    	FluentWait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
    			.withTimeout(wait_timeout, TimeUnit.SECONDS)
    			.pollingEvery(5, TimeUnit.SECONDS)
    			.ignoring(NoSuchElementException.class);
    	try {
    		Object interval = pwait.until(new Function<WebDriver, WebElement>() {
    			public WebElement apply(WebDriver d) {
    				WebElement likeButton_obj = d.findElement(By.name("Like"));
    				System.out.println("likeButton found"); 
    				return likeButton_obj;
    			}
    		});
    		return true;
    	} catch (TimeoutException t) {
    		System.out.println("Did not find the Like Button within fluent wait time");  
    		return false;
    	}
    }	

	public void clickLikeButton() {
		likeButton.click();
	}
	
	public void clickDislikeButton() {
		dislikeButton.click();
	}	
	
	public void clickNothanksButton() {
		nothanksButton.click();
	}	
}