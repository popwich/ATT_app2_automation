package Tests;

import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

import Pages.ATT_EnterPinPage;
import Pages.ATT_HamburgerMenuPage;
import Pages.ATT_HamburgerMenuPage_alarmtab_expanded;
import Pages.ATT_LikeDislikePage;
import Pages.ATT_LoginPage;
import Pages.ATT_HomePage;
import Pages.ATT_SystemCannotTurnOnPage;
import Tests.AbstractBaseTests.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * Tests for a foresee
 */
public class ATT_ForeseeTest extends TestBase {
    private ATT_LoginPage loginPage;
    private ATT_HomePage homePage;
    private ATT_HamburgerMenuPage hamburgerMenuPage;
    private ATT_HamburgerMenuPage_alarmtab_expanded hamburgerMenuPage_alarmtab_expanded;
    private ATT_EnterPinPage enterPinPage;
    private ATT_SystemCannotTurnOnPage systemCannotTurnOnPage;
    private ATT_LikeDislikePage likeDislikePage;    
 
    private Boolean arm_status = false;

    @Override
    public String getName() {
        return "foresee Page";
    }

    /**
     * Creates a foresee page
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
       
    @BeforeMethod
    public void foresee_precondition() {
    	//clear license agreement page if there is 1
    	try {
           	if (driver.findElementById("com.att.digitallife.android.phone22:id/acceptEULAButton").isDisplayed())
               {driver.findElementById("com.att.digitallife.android.phone22:id/acceptEULAButton").click(); }
          }
           catch (Exception e){
           	e.getMessage();
           	System.out.println(e);   
           }    	
    	
    	for (int i=1; i<7; i++) { 
    		//login 6 times
    		loginPage.loginInByStoredCredential();
    		homePage = loginPage.returnHomePage();   
    		Assert.assertTrue(homePage.isCurrentPage());
    		System.out.println("login loop " + i + " SuccessFully");  

    		//logout
    		if (homePage.isCurrentPage()) 
    		{
    			try {
    				homePage.pressMenu();
    				hamburgerMenuPage = homePage.returnHamburgerMenuPage();
    				hamburgerMenuPage.signout();
    				System.out.println("logout loop " + i + " SuccessFully");  
    			}
    			catch (Exception e){
    				e.getMessage();
    				System.out.println(e);
    			}	      
    		}
    	}

    	//login 7th time  	     
    	loginPage.loginInByStoredCredential();
    	homePage = loginPage.returnHomePage();   
    	Assert.assertTrue(homePage.isCurrentPage());
    	System.out.println("login loop " + "7" + " SuccessFully");  

    	//logged in at 7th time already, now we can arm or disarm the system to trigger the foresee
    	homePage.pressMenu();
    	hamburgerMenuPage = homePage.returnHamburgerMenuPage(); 
 		hamburgerMenuPage_alarmtab_expanded = hamburgerMenuPage.returnHamburgerMenuPage_alarmtab_expanded(); //click on alarm tab and return new alarmtab_expanded page	
 		
    	if (!hamburgerMenuPage.isArmed()) { //if system is not armed   	
    		arm_status = false; 
    		hamburgerMenuPage_alarmtab_expanded.armSystem(); //arm system from hamburgerMenuPage_alarmtab_expanded page
    	}
    	else { //else system is armed
    		arm_status = true;
    		hamburgerMenuPage_alarmtab_expanded.disarmSystem(); //disarm system from hamburgerMenuPage_alarmtab_expanded page
    	}

    	//enter pin
    	enterPinPage = hamburgerMenuPage_alarmtab_expanded.returnEnterPinPage();
    	try {
    		if (enterPinPage.isCurrentPage()){ //enterpin page appeared
    			enterPinPage.enterDigit(1);
	    		enterPinPage.enterDigit(2);
	    		enterPinPage.enterDigit(3);
	    		enterPinPage.enterDigit(4);
	    		System.out.println("pin 1234 entered");  
	    		systemCannotTurnOnPage = enterPinPage.returnSystemCannotTurnOnPage();
    		}
    		
    		if (!arm_status) { //skip waiting for systemCannotTurnOn page if we are disarming the system
	    		if (systemCannotTurnOnPage.isCurrentPage()) { //systemCannotTurnOn page appeared
	    			systemCannotTurnOnPage.clickBypassButton(); //click on bypass button to continue arming process
	    		}
    		}
    	}
    	catch (Exception e){
    		e.getMessage();
    		System.out.println(e);
    	}	  

    	//verify arming or disarming process is in progress
    	try {
    		if (arm_status) {
    			if (hamburgerMenuPage.isDisarming()) {
        			System.out.println("Disarming in progress..."); 
    			}
    		}
    		else {
    			if (hamburgerMenuPage.isArming()) {
        			System.out.println("Arming in progress...");    				
    			}
    		}
    	}
    	catch (Exception e){
    		e.getMessage();
    		System.out.println(e);
    	}	     
    }          
        
    /**********************************************/
    /*********************************************/    
    @Test
    public void userLike_story1(){
    	//wait for foresee survey
    	try {
			System.out.println("userLike_story1 test");  
			likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
			//wait for likedislike page to appear
			Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
			System.out.println("LikeDislike page appeared");  
    		
			//click like button
			likeDislikePage.clickLikeButton();	    
		} catch (Exception e){
    		e.getMessage();
    		System.out.println(e);
		}
    	
    	/*FluentWait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
    			.withTimeout(60, TimeUnit.SECONDS)
    			.pollingEvery(7, TimeUnit.SECONDS)
    			.ignoring(NoSuchElementException.class);
    	try {
    		Object interval = pwait.until(new Function<WebDriver, WebElement>() {
    			public WebElement apply(WebDriver d) {
    				WebElement likeButton = d.findElement(By.name("Like"));
    				System.out.println("likeButton found"); 
    				return likeButton;
    			}
    		});
    	} catch (TimeoutException t) {
    		System.out.println("Did not find the Like Button within fluent wait time");
    	}*/
    }
    
    @Test
    public void userLike_story2(){
    	//wait for foresee survey
    	try {
			TimeUnit.SECONDS.sleep(60);
			System.out.println("userLike_story2 test");    
		} catch (Exception e){
    		e.getMessage();
    		System.out.println(e);
		}
    }


    /**
     * After each test method
     */
    @AfterMethod
    //reset app in AfterMethod for Foresee test only 
    public void restartApp() {
        driver.resetApp();
    }
}
