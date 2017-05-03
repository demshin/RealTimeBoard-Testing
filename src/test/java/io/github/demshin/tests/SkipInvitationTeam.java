package io.github.demshin.tests;

import io.github.demshin.pages.*;
import io.github.demshin.utils.Generators;
import org.testng.annotations.Test;

import static io.github.demshin.utils.Time.waitForSeconds;
import static org.testng.Assert.assertTrue;

public class SkipInvitationTeam extends BaseTest{
    @Test(description = "Full registration with skipping invitation team")
    public void successRegistrationTestWithoutInvitationTeam() throws Exception {
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

        TellUsMorePage tellUsMorePage = inviteYourTeamPage.clickSendInvitationsButton();
        assertTrue(tellUsMorePage.isPageOpened());

        tellUsMorePage.selectRole();
        tellUsMorePage.selectTeamSize();
        tellUsMorePage.fillPhoneNumberIfNeeded();
        WhatDoYouLikePage whatDoYouLikePage = tellUsMorePage.clickContinueButton();
        assertTrue(whatDoYouLikePage.isPageOpened());

        BoardPage boardPage = whatDoYouLikePage.clickSkipButton();
        assertTrue(boardPage.isPageOpened());
    }
}
