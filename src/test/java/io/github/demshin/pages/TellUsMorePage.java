package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TellUsMorePage extends GenericPage {
    private static final String PAGE_URL = "https://realtimeboard.com/signup/";

    public TellUsMorePage() {
        super(false);
    }

    @FindBy(className = "welcomeScreenSlide__title")
    private WebElement welcomeScreenSlideTitle;

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return welcomeScreenSlideTitle.getText().equals("Tell us more about yourself");
    }
}
