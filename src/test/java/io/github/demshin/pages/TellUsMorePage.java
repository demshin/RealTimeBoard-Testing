package io.github.demshin.pages;

import io.github.demshin.utils.Generators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TellUsMorePage extends GenericPage {
    private static final String PAGE_URL = "https://realtimeboard.com/signup/";

    public TellUsMorePage() {
        super(false);
    }

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlideTitle;

    @FindBy(css = "select[ng-model='ctrl.roles.selected']")
    private WebElement selectRoleDropdown;

    @FindBy(css = "select[ng-model='ctrl.teamSizes.selected']")
    private WebElement selectTeamSizesDropdown;

    @FindBy(css = "input[ng-model='ctrl.teamPhone']")
    private WebElement phoneInput;

    @FindBy(css = "div[hm-tap='ctrl.submit()']")
    private WebElement continueButton;

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlideTitle.getText().equals("Tell us more\nabout yourself");
    }

    public void selectRole() {
        String role = Generators.randomRole();
        Select dropdown = new Select(selectRoleDropdown);
        dropdown.selectByVisibleText(role);
    }

    public void selectTeamSize() {
        String size = Generators.randomTeamSize();
        Select dropdown = new Select(selectTeamSizesDropdown);
        dropdown.selectByVisibleText(size);
    }

    public WhatDoYouLikePage clickContinueButton() {
        continueButton.click();
        return new WhatDoYouLikePage();
    }

    public void fillPhoneNumberIfNeeded() {
        if (phoneInput.isDisplayed()) {
            String phoneNumber = Generators.randomPhoneNumber();
            phoneInput.sendKeys(phoneNumber);
        }
    }
}
