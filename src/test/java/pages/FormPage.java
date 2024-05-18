package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

/*
Page object class to have common methods and element locators in form page
 */
public class FormPage extends BaseTest {
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By email = By.id("user_email");
    By createPassword = By.id("user_password");
    By trailSignUpButton = By.id("send");
    By termsCheckBox = By.id("terms");
    By captchaCheckBox = By.id("recaptcha-anchor");

    By invalidEmailText = By.xpath("//span[contains(text(),'Invalid email')]");

    public void enterFirstName(String text){
        driver.findElement(firstName).sendKeys(text);
    }

    public void enterLastName(String text){
        driver.findElement(lastName).sendKeys(text);
    }

    public void enterEmail(String text){
        driver.findElement(email).sendKeys(text);
    }

    public void verifyInvalidEmailText(){
        driver.findElement(invalidEmailText).getText();

    }

    public void enterPassword(String text){
        driver.findElement(createPassword).sendKeys(text);
    }

    public void termsCheck(){
        WebElement element = driver.findElement(termsCheckBox);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    /*
    Selenium does not support Captcha, so this method cannot be executed
     */

    public void captchaCheck(){
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(captchaCheckBox);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        driver.switchTo().defaultContent();
    }

    public void clickSignUp(){
        driver.findElement(trailSignUpButton).click();
    }
}
