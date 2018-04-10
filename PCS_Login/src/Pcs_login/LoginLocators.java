package Pcs_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLocators {

	/*
	 * PortFolio WebElement
	 * 
	 */
	public WebElement getSignLoginButton(WebDriver driver)
	{
		WebElement ele = driver.findElement(By.id("sso-login"));
		return ele;
	}
	
	public By getClosePopUpButton()
	{
		By ele = By.id("fancybox-close");
		return ele;
	}
	
	public WebElement getSignOutLink(WebDriver driver)
	{
		//WebElement ele = driver.findElement(By.id("lgout"));
		WebElement ele = driver.findElement(By.xpath("//a[text()='Sign out']"));
		return ele;
	}
	
	/*
	 * 
	 * Common Locators of Sign In window
	 * 
	 * 
	 */
	
	public WebElement getSignInButton(WebDriver driver)
	{
		WebElement ele = driver.findElement(By.xpath("//*[@id='signInButtonDiv']/input"));
		return ele;
	}
	
	public WebElement getPasswordTextField(WebDriver driver)
	{
		WebElement ele = driver.findElement(By.id("password"));
		return ele;
	}
	
	public WebElement Email(WebDriver d) {
		return d.findElement(By.id("emailId"));
	}
	
	public WebElement getGmailIcon(WebDriver d) {
		return d.findElement(By.id("gpRedsigninLong"));
	}
	
	// Gmail Locators
	public WebElement getGEmailTextField(WebDriver d) {
		return d.findElement(By.id("Email"));
	}
	
	public WebElement getGMailPasswordTextField(WebDriver d) {
		return d.findElement(By.id("Passwd"));
	}
	
	public By getNextButton()
	{
		By ele = By.id("next");
		return ele;
	}
	
	public WebElement getGMailSignInButton(WebDriver d) {
		return d.findElement(By.id("signIn"));
	}

	// FB Locators
	
	public WebElement getFBIcon(WebDriver d) {
		return d.findElement(By.cssSelector("input.fb"));
	}
	
	public WebElement getFBEmail(WebDriver d) {
		return d.findElement(By.id("email"));
	}
	
	public WebElement getFBPassword(WebDriver d) {
		return d.findElement(By.id("pass"));
	}
	
	public WebElement getFBSignButton(WebDriver d) {
		return d.findElement(By.id("u_0_2"));
	}
}
