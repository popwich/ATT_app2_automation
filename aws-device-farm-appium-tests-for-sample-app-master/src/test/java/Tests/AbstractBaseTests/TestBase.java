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

package Tests.AbstractBaseTests;


import io.appium.java_client.AppiumDriver;

import Pages.NavigationPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
public abstract class TestBase {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver<MobileElement> driver;

    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * A page containing the navigation drawer
     */
    private NavigationPage navigationPage;

    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage();

    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException{

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        driver = new AndroidDriver<MobileElement>(url, new DesiredCapabilities());

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        try {
        	if (driver.findElementById("com.att.digitallife.android.phoneCSJ:id/acceptEULAButton").isDisplayed())
            {driver.findElementById("com.att.digitallife.android.phoneCSJ:id/acceptEULAButton").click(); }
       }
        catch (Exception e){
        	e.getMessage();
        	System.out.println(e);   
        }
        
        //login
        try {
        	if (driver.findElementById("com.att.digitallife.android.phoneCSJ:id/userName").isDisplayed())
            {        		
        		driver.findElementById("com.att.digitallife.android.phoneCSJ:id/serverPicker").click(); 
        		driver.findElementByName("QA1: qayqa33mickey").click(); 
        		driver.findElementById("com.att.digitallife.android.phoneCSJ:id/button_sign_in").click(); 
        		System.out.println("Logged in succesfully.");          		       		
            }        	
        }
        catch (Exception e){
        	e.getMessage();
        	System.out.println(e);   
        }    
        
        
        //clear ivPhotoview, whatsnew & notfication page
        try {
        	if (driver.findElementById("com.att.digitallife.android.phoneCSJ:id/ivPhotoView").isDisplayed())
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
        		
        		if (driver.findElementById("com.att.digitallife.android.phoneCSJ:id/btnGotIt").isDisplayed())
        		{
        			driver.findElementById("com.att.digitallife.android.phoneCSJ:id/btnGotIt").click();
        		}        		
        		System.out.println("ivPhotoView cleared succesfully.");   
        		
        		if (driver.findElementByName("What's New!").isDisplayed())
        		{
        			driver.findElementById("com.att.digitallife.android.phoneCSJ:id/btnConfirmationDialogOK").click();
        		}        		
        		System.out.println("whatsnew page cleared succesfully.");   
        		
        		if (driver.findElementByName("Notifications").isDisplayed())
        		{
        			driver.findElementByName("Yes").click();
        		}        		
        		System.out.println("notification page cleared succesfully.");          		
            }        	
        }
        catch (Exception e){
        	e.getMessage();
        	System.out.println(e);   
        }       
    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium(){
        driver.quit();
    }

    /**
     *
     *  Creates a navigation page and navigates to the Class' category
     *  within the navigation drawer
     *
     */
    @BeforeClass
    public void navigateTo() throws InterruptedException {
       navigationPage = new NavigationPage(driver);
       navigationPage.gotoCategory(getName());
    }

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @AfterClass
    public void restartApp() {
        //driver.resetApp();
    
    }
}