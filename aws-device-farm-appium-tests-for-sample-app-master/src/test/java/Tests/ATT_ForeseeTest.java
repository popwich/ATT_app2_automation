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
import Pages.ATT_LikeDislikePage_subpages.ATT_likesubpage;
import Pages.ATT_LikeDislikePage_subpages.ATT_dislikesubpage;
import Pages.ATT_LikeDislikePage_subpages.ATT_DislikesSubPage_subpages.ATT_yeshelpsubpage;
import Pages.ATT_LikeDislikePage_subpages.ATT_LikesSubPage_subpages.ATT_ratesubpage;
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
    private ATT_likesubpage likesubpage;
    private ATT_dislikesubpage dislikesubpage;  
    private ATT_ratesubpage ratesubpage;
    private ATT_yeshelpsubpage yeshelpubpage;
 
    private Boolean arm_status = false;
    private final String ATT_LikeDislikePage_HEADLINE = "How do you like the Digital Life App?";
    private final String ATT_LikeSubPage_HEADLINE = "Thank you";
    private final String ATT_DislikeSubPage_HEADLINE = "We'd welcome your feedback";
    private final String ATT_YeshelpSubPage_HEADLINE = "Digital Life";    
        
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
    		Assert.assertTrue(homePage.isCurrentPage(30));
    		System.out.println("login loop " + i + " SuccessFully");  

    		//logout
    		if (homePage.isCurrentPage(30)) 
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
    	Assert.assertTrue(homePage.isCurrentPage(30));
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
    /**********************************************/
    /* 
     * like foresee tests
     */ 
    @Test
    public void userLike_rate(){ //like -> rate
    	//wait for foresee survey    	
    	System.out.println("userLike_rate test");  
    	likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
    	//wait for likedislike page to appear
    	Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
    	System.out.println("LikeDislike page appeared");  
    	
    	//assert headline of likeDislikePage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeDislikePage_HEADLINE);

    	//click like button, return likesubpage
    	likeDislikePage.clickLikeButton();	   		
    	likesubpage = likeDislikePage.returnLikeSubPage();
    	
    	//assert headline of likesubpage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeSubPage_HEADLINE);

    	//click rate button, return ratesubpage
    	likesubpage.clickRateButton();	   		
    	ratesubpage = likesubpage.returnRateSubPage();
    	
    	//assert click rate leads to app store (if we are not at hamburgermenu page or homepage, then we must be outside DL app2.0
    	Assert.assertFalse((hamburgerMenuPage.isCurrentPage() | homePage.isCurrentPage(30)));    	    	
    }
    
    @Test
    public void userLike_remindmelater(){ //like -> remind me later
    	//wait for foresee survey    	
    	System.out.println("userLike_remindmelater test");  
    	likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
    	//wait for likedislike page to appear
    	Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
    	System.out.println("LikeDislike page appeared");  
    	
    	//assert headline of likeDislikePage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeDislikePage_HEADLINE);

    	//click like button, return likesubpage
    	likeDislikePage.clickLikeButton();	   		
    	likesubpage = likeDislikePage.returnLikeSubPage();
    	
    	//assert headline of likesubpage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeSubPage_HEADLINE);

    	//click remindmelater button, went back to hamburgermenu page
    	likesubpage.clickRemindButton();	   			
     	Assert.assertTrue(hamburgerMenuPage.isCurrentPage());
    }
    
    @Test
    public void userLike_nothanks(){ //like -> no thanks
    	//wait for foresee survey    	
    	System.out.println("userLike_nothanks test");  
    	likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
    	//wait for likedislike page to appear
    	Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
    	System.out.println("LikeDislike page appeared");  
    	
    	//assert headline of likeDislikePage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeDislikePage_HEADLINE);

    	//click like button, return likesubpage
    	likeDislikePage.clickLikeButton();	   		
    	likesubpage = likeDislikePage.returnLikeSubPage();
    	
    	//assert headline of likesubpage
    	Assert.assertEquals(likesubpage.getHeadlineValue(), ATT_LikeSubPage_HEADLINE);

    	//click nothanks button, went back to hamburgermenu page
    	likesubpage.clickNothanksButton();	   			
     	Assert.assertTrue(hamburgerMenuPage.isCurrentPage());
    }

    
    /* 
     * dislike foresee tests
     */
    @Test
    public void userDislike_nothanks(){ //Dislike -> no thanks
    	//wait for foresee survey    	
    	System.out.println("userDislike_nothanks test");  
    	likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
    	//wait for likedislike page to appear
    	Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
    	System.out.println("LikeDislike page appeared");  
    	
    	//assert headline of likeDislikePage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeDislikePage_HEADLINE);

    	//click dislike button, return dislikesubpage
    	likeDislikePage.clickDislikeButton();	   		
    	dislikesubpage = likeDislikePage.returndislikeSubPage();
    	
    	//assert headline of dislikesubpage
    	Assert.assertEquals(dislikesubpage.getHeadlineValue(), ATT_DislikeSubPage_HEADLINE); 
    	
    	//click nothanks button,  went back to hamburgermenu page
    	dislikesubpage.clickNoThanksButton();
    	Assert.assertTrue(hamburgerMenuPage.isCurrentPage());    	
    }
    
    @Test
    public void userDislike_yeshelp(){ //Dislike -> yes i will help
    	//wait for foresee survey    	
    	System.out.println("userDislike_yeshelp test");  
    	likeDislikePage = hamburgerMenuPage.returnLikeDislikePage();   
    	//wait for likedislike page to appear
    	Assert.assertTrue(likeDislikePage.isCurrentPage(60));	//fluent wait used inside likeDislike Page		
    	System.out.println("LikeDislike page appeared");  
    	
    	//assert headline of likeDislikePage
    	Assert.assertEquals(likeDislikePage.getHeadlineValue(), ATT_LikeDislikePage_HEADLINE);

    	//click dislike button, return dislikesubpage
    	likeDislikePage.clickDislikeButton();	   		
    	dislikesubpage = likeDislikePage.returndislikeSubPage();
    	
    	//assert headline of dislikesubpage
    	Assert.assertEquals(dislikesubpage.getHeadlineValue(), ATT_DislikeSubPage_HEADLINE); 
    	
    	//click yeshelp button, go to foresee survey page
    	dislikesubpage.clickYesHelpButton();
    	yeshelpubpage = dislikesubpage.returnYeshelpSubPage();
    	Assert.assertTrue(yeshelpubpage.isCurrentPage(30)); 
    	
    	//assert headline of yeshelpubpage
    	Assert.assertEquals(yeshelpubpage.getHeadlineValue(), ATT_YeshelpSubPage_HEADLINE);    	  		
    }
    
    
    /**********************************************/
    /**********************************************/
    
    /**
     * After each test method
     */
    @AfterMethod
    //reset app in AfterMethod for Foresee test only 
    public void restartApp() {
        driver.resetApp();
    }
}
