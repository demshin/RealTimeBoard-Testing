package io.github.demshin.pages;

import io.github.demshin.utils.Generators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupYourTeamPage extends GenericPage {
    public static final String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlideTitle;

    @FindBy(className = "welcomeScreenControl__input")
    private WebElement teamNameInput;

    @FindBy(className = "welcomeScreen__button--big")
    private WebElement continueButton;

    public SetupYourTeamPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlideTitle.getText().equals("Set up your team");
    }

    public void fillTeamName() {
        teamNameInput.sendKeys(Generators.randomTeam());
    }

    public InviteYourTeamPage clickContinueButton() {
        continueButton.click();
        return new InviteYourTeamPage();
    }
}
