package io.github.demshin.setup;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesGenerator {

    public static DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return DesiredCapabilities.firefox();
            case CHROME:
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

}
