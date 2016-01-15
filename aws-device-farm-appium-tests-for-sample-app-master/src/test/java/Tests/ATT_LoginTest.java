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

package Tests;

import Pages.ATT_HamburgerMenuPage;
import Pages.ATT_LoginPage;
import Pages.ATT_HomePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for a login page
 */
public class ATT_LoginTest extends TestBase {
    private final String LOGIN_SUCCESS_MESSAGE = "You are logged on as admin";
    private final String LOGIN_FAIL_MESSAGE = "You gave me the wrong username and password";
    private final String CORRECT_USER_NAME = "qayandroid31";
    private final String CORRECT_PASSWORD = "Ba1tshop";
    private final String FAIL_USER_NAME = "Wrong User";
    private final String FAIL_PASSWORD = "12345";

    private ATT_LoginPage loginPage;
    private ATT_HomePage homePage;
    private ATT_HamburgerMenuPage hamburgerMenuPage;

    @Override
    public String getName() {
        return "Login Page";
    }

    /**
     * Creates a login page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        loginPage = new ATT_LoginPage(driver);
    }
    
    @BeforeClass
    @Override
    public void navigateTo() {
    	//clear license agreement page if there is 1
    	try {
           	if (driver.findElementById("com.att.digitallife.android.phone22:id/acceptEULAButton").isDisplayed())
               {driver.findElementById("com.att.digitallife.android.phone22:id/acceptEULAButton").click(); }
          }
           catch (Exception e){
           	e.getMessage();
           	System.out.println(e);   
           }
    }
   
    
    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Test
    public void login1_SuccessFully(){
        loginPage.loginInByStoredCredential();
        homePage = loginPage.returnHomePage();   
        Assert.assertTrue(homePage.isHomePage());
        System.out.println("loginSuccessFully test done");   
    }

    /**
     * Tests logging in with invalid credentials by verifying if the error message is correct
     */
    @Test
    public void login2_Fail() {
        loginPage.loginIn(FAIL_USER_NAME, FAIL_PASSWORD);     
        Assert.assertTrue(true);
        System.out.println("loginFail test done");
    }

    /**
     * After each test method, logout
     */
    @AfterMethod
    public void logOut(){        
        //logout
    	if (!loginPage.isCurrentPage())
    	{
	    	try {
		    	homePage.pressMenu();
		    	hamburgerMenuPage = homePage.returnHamburgerMenuPage();
		    	hamburgerMenuPage.signout();
	    	}
	    	catch (Exception e){
	         	e.getMessage();
	         	System.out.println(e);
	        }	      
    	}
    }
}
