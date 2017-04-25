package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends GenericPage {

    private static final String PAGE_URL = "https://realtimeboard.com";

    @FindBy(linkText = "Sign up")
    private WebElement signUpButton;

    public MainPage() {
        super(true);
    }

    @Override
    public void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return signUpButton.isDisplayed();
    }

    @Override
    public GenericPage clickButton(String nameOfButton) {
        if (nameOfButton.equals("Sign up")) {
            signUpButton.click();
            return new SignUpPage();
        }
        return this;
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage();
    }
}
