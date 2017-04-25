package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends GenericPage {
    private final static String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlide;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;

    public WelcomePage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlide.getText().equals("Welcome to RealtimeBoard!");
    }

    @Override
    public GenericPage clickButton(String nameOfButton) {
        return null;
    }

    public SetupYourTeamPage clickContinueButton() {
        continueButton.click();
        return new SetupYourTeamPage();
    }
}
