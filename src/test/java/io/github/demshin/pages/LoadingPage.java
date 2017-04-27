package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadingPage extends GenericPage {

    private final static String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(className = "rtbLoader_sticker")
    private WebElement rtbLoaderSticker;

    public LoadingPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return rtbLoaderSticker.isDisplayed();
    }
}
