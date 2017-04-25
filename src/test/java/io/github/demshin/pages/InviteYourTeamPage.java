package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InviteYourTeamPage extends GenericPage {

    private static final String PAGE_URL = "https://realtimeboard.com";

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlide;

    @FindBy(className = "editor-input")
    private WebElement emailInput;

    @FindBy(className = "welcomeScreen__button--big")
    private WebElement sendIvationsButton;

    @FindBy(className = "welcomeScreen__button--small")
    private WebElement skipButton;

    @FindBy(css = "hm-tap=\"selectInput()\"")
    private WebElement linkField;

    @FindBy(css = "hm-tap=\"copyToClipboard()\"" )
    private WebElement copyButton;

    public InviteYourTeamPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public GenericPage clickButton(String nameOfButton) {
        return null;
    }


}
