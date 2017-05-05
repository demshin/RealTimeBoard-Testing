package io.github.demshin.tests;

import io.github.demshin.pages.*;
import io.github.demshin.utils.Generators;
import org.testng.annotations.Test;

import static io.github.demshin.utils.Time.waitForSeconds;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SetupYourTeamMessageTest extends BaseTest{
    @Test(description = "Message when press 'Continue' without filling team name")
    public void skipFillingTeamNameInput() {
        MainPage mainPage = new MainPage();
        SignUpPage signUpPage = mainPage.clickSignUpButton();
        assertTrue(signUpPage.isPageOpened());

        signUpPage.fillName(Generators.randomName());
        signUpPage.fillEmail(Generators.randomEmail());
        signUpPage.fillPassword(Generators.randomPassword());
        assertTrue(signUpPage.isSignupInputHintIsShowing());

        LoadingPage loadingPage = signUpPage.clickSubmitButton();
        assertTrue(loadingPage.isPageOpened());

        waitForSeconds(15);

        WelcomePage welcomePage = new WelcomePage();
        assertTrue(welcomePage.isPageOpened());

        SetupYourTeamPage setupYourTeamPage = welcomePage.clickContinueButton();
        assertTrue(setupYourTeamPage.isPageOpened());

        setupYourTeamPage.clickContinueButtonExpectingMessage();
        assertEquals(setupYourTeamPage.getTextOfTeamNameLabelText(), "Please enter a Team name");
    }
}
