package io.github.demshin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends GenericPage {
    private final static String PAGE_URL = "https://realtimeboard.com/app/";

    @FindBy(css = "div[hm-tap='openBoardInfo()']")
    private WebElement boardInfo;

    public BoardPage() {
        super(false);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return boardInfo.getText().equals("My First Board");
    }
}
