package io.github.demshin.tests;

import io.github.demshin.pages.*;
import org.testng.annotations.Test;

import io.github.demshin.utils.Generators;

import static io.github.demshin.utils.Time.waitForSeconds;
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

        LoadingPage loadingPage = signUpPage.clickSubmitButton();
        assertTrue(loadingPage.isPageOpened());

        waitForSeconds(15);

        WelcomePage welcomePage = new WelcomePage();
        assertTrue(welcomePage.isPageOpened());

        SetupYourTeamPage setupYourTeamPage = welcomePage.clickContinueButton();
        assertTrue(setupYourTeamPage.isPageOpened());

        setupYourTeamPage.fillTeamName();
        InviteYourTeamPage inviteYourTeamPage = setupYourTeamPage.clickContinueButton();
        assertTrue(inviteYourTeamPage.isPageOpened());

        inviteYourTeamPage.fillEmail();
        //inviteYourTeamPage.fillEmail();
       // TellUsMorePage tellUsMorePage = inviteYourTeamPage.clickSendInvitationsButton();
       // assertTrue(tellUsMorePage.isPageOpened());
    }
}
