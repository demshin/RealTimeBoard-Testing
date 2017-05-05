package io.github.demshin.tests;

import io.github.demshin.utils.ScreenShotOnFailListener;
import io.github.demshin.setup.WebDriverFactory;
import org.testng.annotations.*;

@Listeners({ScreenShotOnFailListener.class})
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
