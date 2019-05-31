package automation_testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Radio_Button_Test 
{

	WebDriver driver = null;

	@BeforeTest

	public void Setup() 
	{

		System.setProperty("webdriver.chrome.driver", "/Users/sharmilasubramanyan/Desktop/chromedriver/chromedriver");
		driver = new ChromeDriver();
		// open the page
		driver.get("https://www.spicejet.com/");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}// setup()

	
//	@Test(enabled = false)
	@Test(enabled = true)
	public void test_oneway_rbutton() 
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Assert.assertTrue((driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected()));

	}// one way_rdbutton

//	 @Test(enabled = false)
	 @Test
	public void test_roundtrip_rbutton() throws InterruptedException 
	{
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		
		Thread.sleep(5000);

	}// roundtrip_rdbutton

	 //@Test(enabled = false)
	 @Test
	public void test_multicity_rbutton() throws InterruptedException 
	{

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).click();
		//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2']")).click();
		driver.findElement(By.xpath("//a[@id='MultiCityModelAlert']")).click();
		//System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2']")).isSelected());
        Thread.sleep(5000);
        Thread.sleep(5000);
		
	}// multicity_rdbutton

    @Test
	 //@Test(enabled = false)
	public void test_disabled_onewaybutton()
	{
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		List <WebElement> radiobutton = driver.findElements(By.name("ctl00$mainContent$rbtnl_Trip"));
		radiobutton.get(0).click();
		int count =0;
		/*
		 for(WebElement we:radiobutton)
		 {
			  
			 if(we.isSelected() ) {
				 System.out.println(we.getAttribute("value"));
				 count++;
			 }		 
		 }//foreach
		 
		 
		WebElement temp1  =  radiobutton.get(0);
		WebElement temp2  =  radiobutton.get(1);
		WebElement temp3  =  radiobutton.get(2);
			
		 
		for(int i=0; i < radiobutton.size(); i++) {
		     if ( i==0) {
		    	 temp1.click();
		         if (temp1.isSelected() && !temp2.isSelected() && !temp3.isSelected())
		        	 count++;
		     }
		}*/
		
		for(int i=0; i < radiobutton.size(); i++) {
			
			WebElement temp = radiobutton.get(i);
			temp.click();
			if(temp.isSelected())
				count++;
			
			for(int j=0; j<radiobutton.size(); j++) {
			  if( i != j) {	
				 if(radiobutton.get(j).isSelected())
				 {
				   Assert.assertTrue(false);	 
				 }  
			  } //if	  
			}
			
			
			
		}
		
		Assert.assertTrue(count==3);
		
		
	}//test_disabled
	
	@AfterSuite
	public void cleanup()

	{
		driver.close();
	}// cleanup

}// class


