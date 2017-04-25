package io.github.demshin.configuration;

import io.github.demshin.configuration.properties.PropertiesLoader;
import io.github.demshin.configuration.properties.Property;
import io.github.demshin.configuration.properties.PropertyFile;
import io.github.demshin.webtestsbase.Browser;

/**
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("browser.name")
    private String browser = "firefox";

    @Property("browser.version")
    private String version = "";


    /**
     * getting browser object
     * @return browser object
     */
    public Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

    /**
     * getting browser version
     * @return browser version
     */
    public String getBrowserVersion() {
        return version;
    }


}
