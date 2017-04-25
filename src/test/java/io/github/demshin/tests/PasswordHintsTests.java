package io.github.demshin.tests;

import io.github.demshin.pages.MainPage;
import io.github.demshin.pages.SignUpPage;
import org.testng.annotations.Test;

import io.github.demshin.utils.Generators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//@Listeners({ScreenShotOnFailListener.class})
public class PasswordHintsTests extends BaseTest{

    @Test
    public void verifyThatPasswordIsShort() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword("12345");
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        assertEquals(signUpPage.getTextOfSignupInputHint(), "Password must be 6+ characters");
    }

    @Test
    public void verifyThatPasswordIsWeak() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword("123456");
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        assertEquals(signUpPage.getTextOfSignupInputHint(), "Weak password");
    }

    @Test
    public void verifyThatPasswordIsSoSo() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword("12345Qwerq)");
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        assertEquals(signUpPage.getTextOfSignupInputHint(), "So-so password");
    }

    @Test
    public void verifyThatPasswordIsGood() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword("12345Qwer)oiM");
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        assertEquals(signUpPage.getTextOfSignupInputHint(), "Good password");
    }

    @Test
    public void verifyThatPasswordIsGreat() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword(Generators.randomPassword());
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        assertEquals(signUpPage.getTextOfSignupInputHint(), "Great password");
    }
}
