package io.github.demshin.pages;

import io.github.demshin.utils.Time;
import io.github.demshin.setup.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class GenericPage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 15;

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public GenericPage(boolean openPageByUrl){
        if(openPageByUrl){
            openPage();
        }
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    protected void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            Time.waitForSeconds(10);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if(!isPageOpenedIndicator) {
            throw new AssertionError("The page not opened");
        }
    }

    public WebDriver getDriver(){
        return WebDriverFactory.getDriver();
    }

}
