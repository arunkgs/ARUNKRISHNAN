package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
public void enterusername(String username) throws IOException
{
	driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_username_xpath"))).sendKeys(username);
}
public void enterpassword(String password) throws IOException
{
	driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_password_xpath"))).sendKeys(password);
}
public void clicksignin() throws IOException
{
	driver.findElement(By.xpath(utilityPackage.utilityFetchproperty.fetchlocatorvalue("login_signin_xpath"))).click();
}
}
