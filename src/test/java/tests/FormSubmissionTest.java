package tests;

import Utils.CommonUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FormPage;


public class FormSubmissionTest extends BaseTest {
    @BeforeTest
    public void setUp(){
        startWebDriver();
    }
    /*
    Getting the Page Factory Class for form submission
     */
    FormPage formPage = new FormPage();


    /*
    As selenium does NOT support captcha, we cannot test end to end scenario to click on "TRAIL SIGN UP" button
     */
    @Test
    public void TC01_SubmitForm(){
        formPage.enterFirstName(CommonUtils.getValueFromProperties("FIRST_NAME"));
        formPage.enterLastName(CommonUtils.getValueFromProperties("LAST_NAME"));
        formPage.enterEmail(CommonUtils.getValueFromProperties("VALID_EMAIL"));
        formPage.enterPassword(CommonUtils.getValueFromProperties("PASSWORD"));
        //formPage.termsCheck();
        //formPage.captchaCheck();
        //formPage.clickSignUp();
    }

    /*
    This test will verify invalid email error message (negative scenario)
     */
    @Test
    public void TC02_CheckInvlaidEmailTest(){
        formPage.enterFirstName(CommonUtils.getValueFromProperties("FIRST_NAME"));
        formPage.enterLastName(CommonUtils.getValueFromProperties("LAST_NAME"));
        formPage.enterEmail(CommonUtils.getValueFromProperties("INVALID_EMAIL"));
        formPage.verifyInvalidEmailText();

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}