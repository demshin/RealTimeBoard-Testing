package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends GenericPage {

    private static final String PAGE_URL = "https://realtimeboard.com/signup/";

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "signup__input-hint-text")
    private WebElement signupInputHintText;

    @FindBy(className = "signup__error")
    private WebElement signupError;

    @FindBy(className = "signup__submit")
    private WebElement submitButton;

    public SignUpPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return submitButton.isDisplayed();
    }

    @Override
    public GenericPage clickButton(String nameOfButton) {
        return null;
    }

    public boolean isSignupInputHintIsShowing() {
        return submitButton.isDisplayed();
    }

    public void fillName(String name) {
        nameInput.sendKeys(name);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public String getTextOfSignupInputHint() {
        return signupInputHintText.getText();
    }

    public String getTextOfSignupError() {
        return signupError.getText();
    }

    public GenericPage clickSubmitButton() {
        submitButton.click();
        if (isSignupInputHintIsShowing()) {
            return this;
        }
        return new WelcomePage();
    }
}
