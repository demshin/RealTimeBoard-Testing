package io.github.demshin.tests;

import io.github.demshin.utils.ScreenShotOnFailListener;
import io.github.demshin.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by demshin on 21/04/2017 for rtb-testing.
 */
//@Listeners({ScreenShotOnFailListener.class})
public class BaseTest {

    @BeforeClass
    public void init() {
        WebDriverFactory.startBrowser(true);
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.finishBrowser();
    }

}
