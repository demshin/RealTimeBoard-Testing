package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatDoYouLikePage extends GenericPage{
    private final static String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "useCasePicker__caption")
    private WebElement useCasePickerCaption;

    @FindBy(className = "useCasePicker__skip")
    private WebElement skipButton;

    public WhatDoYouLikePage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return useCasePickerCaption.getText().equals("What do you like to start with?");
    }

    public BoardPage clickSkipButton() {
        skipButton.click();
        return new BoardPage();
    }
}
