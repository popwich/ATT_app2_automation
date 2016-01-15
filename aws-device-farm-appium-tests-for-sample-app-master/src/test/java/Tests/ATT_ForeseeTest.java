package Tests;

import Pages.ATT_EnterPinPage;
import Pages.ATT_HamburgerMenuPage;
import Pages.ATT_HamburgerMenuPage_alarmtab_expanded;
import Pages.ATT_LoginPage;
import Pages.ATT_HomePage;
import Pages.ATT_SystemCannotTurnOnPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
       
    @Test
    public void userLike_story1(){
    	for (int i=1; i<=7; i++) { //repeat login logout 7 times - this is precondition of foresee
	   	     //logout
	   	     if (!loginPage.isCurrentPage()) //if already logged in or use: "homePage.isCurrentPage()" to check the same
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
    		
    		//login
    		 loginPage.loginInByStoredCredential();
    		 homePage = loginPage.returnHomePage();   
    	     Assert.assertTrue(homePage.isCurrentPage());
    	     System.out.println("login loop " + i + " SuccessFully");  
    	         	     
    	     //logged in at 7th time already, now we can arm or disarm the system to trigger the foresee
    	     homePage.pressMenu();
    	     hamburgerMenuPage = homePage.returnHamburgerMenuPage(); 
		     if (hamburgerMenuPage.isArmed()) {
		    	 hamburgerMenuPage_alarmtab_expanded = hamburgerMenuPage.returnHamburgerMenuPage_alarmtab_expanded(); //click on alarm tab and return new alarmtab_expanded page		    	 
		     }
		     
		     //enter pin
	    	 enterPinPage = hamburgerMenuPage_alarmtab_expanded.returnEnterPinPage();
	    	 try {
	    		 if (enterPinPage.isCurrentPage()) //enterpin page appeared
	    		 	enterPinPage.enterDigit(1);
	    		 	enterPinPage.enterDigit(2);
	    		 	enterPinPage.enterDigit(3);
	    		 	enterPinPage.enterDigit(4);
	    		    System.out.println("pin 1234 entered");  
	    		    systemCannotTurnOnPage = enterPinPage.returnSystemCannotTurnOnPage();
	    		   
	    		    if (systemCannotTurnOnPage.isCurrentPage()) { //systemCannotTurnOn page appreared
	    			   systemCannotTurnOnPage.clickBypassButton(); //click on bypass button to continue arming process
	    		    }
		    	}
		    	catch (Exception e){
		         	e.getMessage();
		         	System.out.println(e);
		        }	  
	    	 
	    	 //verify arming process is in progress
	    	 try {
	    	 if (hamburgerMenuPage.isArming()) {
	    			 System.out.println("arming in progress...");
	    		 }
	    	 }
	    	 catch (Exception e){
		         	e.getMessage();
		         	System.out.println(e);
		     }	 
	    	 
	    	 //wait for foresee survey
	    	 	    	 
    	}           
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
