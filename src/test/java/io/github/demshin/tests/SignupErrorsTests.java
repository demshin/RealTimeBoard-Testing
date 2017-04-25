package io.github.demshin.tests;

import io.github.demshin.pages.MainPage;
import io.github.demshin.pages.SignUpPage;
import io.github.demshin.utils.Generators;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by demshin on 24/04/2017.
 */
public class SignupErrorsTests extends BaseTest {
    @Test
    public void verifyNameError() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        //skip filling name input
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword(Generators.randomPassword());
        signUpPage.clickSubmitButton();
        assertEquals(signUpPage.getTextOfSignupError(), "Please enter your name");
    }

    @Test
    public void verifyEmailError() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        //skip filling email input
        signUpPage.fillPassword(Generators.randomPassword());
        signUpPage.clickSubmitButton();
        assertEquals(signUpPage.getTextOfSignupError(), "Please enter your email address");
    }

    @Test
    public void verifyThatEmailIsAlreadyRegistered() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail("a.demshin@ya.ru");
        signUpPage.fillPassword(Generators.randomPassword());
        signUpPage.clickSubmitButton();
        assertEquals(signUpPage.getTextOfSignupError(), "Sorry, this email is already registered");
    }

    @Test
    public void verifyThatNameAndPasswordAreEqual() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        String nameAndPassword = Generators.randomName();
        signUpPage.fillName(nameAndPassword);
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword(nameAndPassword);
        signUpPage.clickSubmitButton();
        assertEquals(signUpPage.getTextOfSignupError(), "Sorry, name and password cannot be the same");
    }
}
