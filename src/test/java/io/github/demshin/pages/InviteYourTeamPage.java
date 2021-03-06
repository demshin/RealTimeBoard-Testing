package io.github.demshin.pages;

import io.github.demshin.utils.Generators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.github.demshin.utils.Time.waitForSeconds;

public class InviteYourTeamPage extends GenericPage {

    private static final String PAGE_URL = "https://realtimeboard.com/app";

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlide;

    @FindBy(css = "textarea[ng-model='enteredEmails']")
    private WebElement multiEmailInput;

    @FindBy(css = "div[hm-tap='ctrl.invite()']")
    private WebElement sendInvitationsButton;

    @FindBy(css = "div[hm-tap='ctrl.addTeamMembersLater()']")
    private WebElement skipButton;

    @FindBy(css = "div[hm-tap='selectInput()']")
    private WebElement linkField;

    @FindBy(css = "hm-tap='copyToClipboard()'")
    private WebElement copyButton;

    @FindBy(className = "rtb-checkbox__label")
    private WebElement checkBoxToAddPeople;

    @FindBy(className = "email-content")
    private WebElement emailContent;

    @FindBy(css = "input[ng-attr-id='ui-input-{{::id}}']")
    private WebElement emailInput;

    public InviteYourTeamPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlide.getText().equals("Invite your team");
    }

    public void fillEmail() {
        String email = Generators.randomEmail();
        if (multiEmailInput.isDisplayed()) {
            multiEmailInput.sendKeys(email + " ");
            while (!emailContent.getText().equals(email)) {
                waitForSeconds(1);
            }
        } else if (emailInput.isDisplayed()) {
            emailInput.sendKeys(email);
        }
    }

    public TellUsMorePage clickSendInvitationsButton() {
        sendInvitationsButton.click();
        return new TellUsMorePage();
    }

    public TellUsMorePage clickSkipForNowButton() {
        skipButton.click();
        return new TellUsMorePage();
    }

    public TellUsMorePage clickSkipButton() {
        skipButton.click();
        return new TellUsMorePage();
    }
}
