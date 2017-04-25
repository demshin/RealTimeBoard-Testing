package io.github.demshin.pages;

import io.github.demshin.utils.Generators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by demshin on 24/04/2017.
 */
public class SetupYourTeamPage extends GenericPage {
    public static final String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "welcomeScreenSlide__header")
    private WebElement welcomeScreenSlide;

    @FindBy(className= "welcomeScreenControl__label")
    private WebElement welcomScreenLabel;

    @FindBy(className = "welcomeScreenControl__input")
    private WebElement welcomeScreenInput;

    @FindBy(className = "welcomeScreen__button")
    private WebElement welcomeScreenButton;

    public SetupYourTeamPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlide.getText().equals("Set up your team");
    }

    @Override
    public GenericPage clickButton(String nameOfButton) {
        return null;
    }

    public void fillTeamName() {
        welcomeScreenInput.sendKeys(Generators.randomTeam());
    }

    public boolean isWelcomScreenLabelIsShowing() {
        return welcomScreenLabel.isDisplayed();
    }

    public GenericPage clickContinueButton() {
        welcomeScreenButton.click();
        if (isWelcomScreenLabelIsShowing()) {
            return this;
        } else {
            return new InviteYourTeamPage();
        }
    }
}
