package Pages.ATT_LikeDislikePage_subpages.ATT_DislikesSubPage_subpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import Pages.BasePage;

/**
 * @param <wait_timeout>
 */
public class ATT_yeshelpsubpage<wait_timeout> extends BasePage{    
	@AndroidFindBy(id = "android:id/action_bar_title")
	private WebElement headline;
	
	@AndroidFindBy(className = "android.widget.RadioButton")
	private WebElement radioButton;    
	 
    public ATT_yeshelpsubpage(AppiumDriver driver) {
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
     * check whether is at current page, look for radio button which is only available in foresee survey page
     */   
    public Boolean isCurrentPage(int wait_timeout) { //fluent wait method - more flexible, user can pass in wait_timeout to specify how long to wait for certain web element to appear
    	FluentWait<WebDriver> pwait = new FluentWait<WebDriver>(driver)
    			.withTimeout(wait_timeout, TimeUnit.SECONDS)
    			.pollingEvery(5, TimeUnit.SECONDS)
    			.ignoring(NoSuchElementException.class);
    	try {
    		Object interval = pwait.until(new Function<WebDriver, WebElement>() {
    			public WebElement apply(WebDriver d) {
    				WebElement radioButton_obj = d.findElement(By.className("android.widget.RadioButton")); 
    				System.out.println("radioButton found"); 
    				return radioButton_obj;
    			}
    		});
    		return true;
    	} catch (TimeoutException t) {
    		System.out.println("Did not find the radioButton within fluent wait time");  
    		return false;
    	}
    }	
}