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
 * Tests for a foresee
 */
public class ATT_ForeseeTest extends TestBase {
    private ATT_LoginPage loginPage;
    private ATT_HomePage homePage;
    private ATT_HamburgerMenuPage hamburgerMenuPage;

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
		    	 
		     }
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
