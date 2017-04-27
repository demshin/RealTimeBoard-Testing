package io.github.demshin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.demshin.utils.Time.waitForElementPresent;

public class WelcomePage extends GenericPage {
    private final static String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "welcomeScreen__button")
    private WebElement continueButton;

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlide;

    @FindBy(className = "welcomeScreenSlide__subTitle")
    private WebElement welcomeScreenSlideSubTitle;

    /*@FindBy(linkText = "Continue")
    private WebElement continueButton;*/

    public WelcomePage() {
        super(false);
    }

    public WebElement getWelcomeScreenSlide() {
        return welcomeScreenSlide;
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlide.getText().equals("Welcome to RealtimeBoard!")
                && welcomeScreenSlideSubTitle.getText().equals("Visual collaboration platform your whole team will fall in love with.");
    }

    public SetupYourTeamPage clickContinueButton() {
        continueButton.click();
        return new SetupYourTeamPage();
    }
}
