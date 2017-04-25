package io.github.demshin.pages;

import io.github.demshin.utils.TimeUtils;
import io.github.demshin.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the main class for pages. When you create your page - you must extend your class from this
 */
public abstract class GenericPage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 15;

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public abstract GenericPage clickButton(String nameOfButton);

 //   public abstract void fillInput(String nameOfInput);

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
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if(!isPageOpenedIndicator) {
            throw new AssertionError("The page not opened");
        }
    }

    protected WebDriver getDriver(){
        return WebDriverFactory.getDriver();
    }

}
