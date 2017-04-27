package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.github.demshin.utils.Time.waitForSeconds;

public class MainPage extends GenericPage {

    private static final String PAGE_URL = "https://realtimeboard.com";

    @FindBy(linkText = "Sign up")
    private WebElement signUpButton;

    @FindBy(className = "rtb-header-1__burger-btn-dash")
    private WebElement burgerButton;

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

    public SignUpPage clickSignUpButton() {
        if (burgerButton.isDisplayed()) {
            waitForSeconds(1);
            burgerButton.click();
        } else {
            signUpButton.click();
        }
        return new SignUpPage();
    }
}
