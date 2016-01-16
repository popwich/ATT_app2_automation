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
 * likedislike page for foresee page 
 */
public class ATT_LikeDislikePage extends BasePage{
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
    public Boolean isCurrentPage() {
      	try {
      		return likeButton.isDisplayed(); 
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
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