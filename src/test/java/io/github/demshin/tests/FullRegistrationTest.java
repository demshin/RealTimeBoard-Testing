package io.github.demshin.tests;

import io.github.demshin.pages.*;
import org.testng.annotations.Test;

import io.github.demshin.utils.Generators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//@Listeners({ScreenShotOnFailListener.class})
public class FullRegistrationTest extends BaseTest {

    @Test
    public void successRegistrationTest() throws Exception {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword(Generators.randomPassword());
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        GenericPage welcomePage = signUpPage.clickSubmitButton();
        assertTrue(welcomePage.isPageOpened());

        WelcomePage welcomePage1 = new WelcomePage();
        if (welcomePage instanceof WelcomePage) {
            welcomePage1 = (WelcomePage) welcomePage;
        }

        SetupYourTeamPage setupYourTeamPage = welcomePage1.clickContinueButton();
        assertTrue(setupYourTeamPage.isPageOpened());
    }
}
