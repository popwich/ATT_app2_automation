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

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A login page
 */
public class ATT_LoginPage extends BasePage {
    /**
     * The pick credential button - works for android phone but not android tab because android tab need scrollable obj
     */
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.att.digitallife.android.phone22:id/serverPicker\")")	   
    private MobileElement pickButton_phoneonly;
	
	 /**
     * The pick credential button
     */
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.att.digitallife.android.phone22:id/serverPicker\")")	   
    private MobileElement pickButton;
	
	/**
     * The login button
     */
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/button_sign_in")
    private MobileElement loginButton;

    /**
     * The user name input
     */
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/userName")
    private MobileElement userNameField;

    /**
     * The password input
     */
    @AndroidFindBy(id = "com.att.digitallife.android.phone22:id/password")
    private MobileElement passwordField;

    public ATT_LoginPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tries to login with a set of credentials
     *
     * @param userName the username
     * @param password the password
     */
    public void loginIn(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    //alternative login method using stored credential in app
    public void loginInByStoredCredential(boolean firstLogin){

    	try {
        	if (driver.findElementById("com.att.digitallife.android.phone22:id/userName").isDisplayed())
            {   //swipe up no matter what to take care android tab small login window problem
           		Dimension size = driver.manage().window().getSize(); 
        		int starty = (int) ( (size.height /2) +  80); 
        		int endy = (int) ( (size.height /2) -  80); 
        		int startx = size.width / 2; 
        		driver.swipe(startx, starty, startx, endy, 500); 
        		Thread.sleep(1000);
               		
        		//click pick button
        		pickButton.click(); 
        		driver.findElementByName("QA2: qayandroid31").click(); 
        		loginButton.click(); 
        		System.out.println("LoginPage: Logged in successfully.");      
        		Thread.sleep(3000);
            }        	
        }
        catch (Exception e){
        	e.getMessage();
        	System.out.println(e);   
        }  
        
    	
    	if (firstLogin) {
    	       //clear ivPhotoview, whatsnew & notification page
            try {
            	if (driver.findElementById("com.att.digitallife.android.phone22:id/ivPhotoView").isDisplayed())
                {   
            		Dimension size = driver.manage().window().getSize(); 
            		int startx = (int) (size.width * 0.8); 
            		int endx = (int) (size.width * 0.20); 
            		int starty = size.height / 2; 
            		driver.swipe(startx, starty, endx, starty, 1000); 
            		Thread.sleep(1000);
            		driver.swipe(startx, starty, endx, starty, 1000);     
            		Thread.sleep(1000);
            		driver.swipe(startx, starty, endx, starty, 1000);     
            		
            		if (driver.findElementById("com.att.digitallife.android.phone22:id/btnGotIt").isDisplayed())
            		{
            			driver.findElementById("com.att.digitallife.android.phone22:id/btnGotIt").click();
            		}        		
            		System.out.println("ivPhotoView cleared successfully.");   
            		
            		if (driver.findElementByName("What's New!").isDisplayed())
            		{
            			driver.findElementById("com.att.digitallife.android.phone22:id/btnConfirmationDialogOK").click();
            		}        		
            		System.out.println("whatsnew page cleared successfully.");   
            		
            		if (driver.findElementByName("Notifications").isDisplayed())
            		{
            			driver.findElementByName("Yes").click();
            		}        		
            		System.out.println("notification page cleared successfully.");          		
                }        	
            }
            catch (Exception e){
            	e.getMessage();
            	//System.out.println(e);   
            	System.out.println("There is no ivPhotoview, whatsnew & notification needs to be cleared");
            }   
    	}
     
    }
    

    /**
     * Checks to see if back at login page
     *
     * @return is back at login
     */
    public boolean isCurrentPage(){
    	try {
    		return loginButton.isDisplayed();
    	}
    	catch (Exception e){
         	e.getMessage();
         	System.out.println(e);
         	return false;
        }
    }

    /**
    *
    * @return the main page
    */   
    public Pages.ATT_HomePage returnHomePage(){
	   return new ATT_HomePage(driver);
   }
}
