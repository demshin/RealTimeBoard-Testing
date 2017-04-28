package io.github.demshin.webtestsbase;

/**
 * This class represents browsers. For add support of your browser - add it to this enum
 */
public enum  Browser {
    FIREFOX("firefox"),
    CHROME("chrome");
    private String browserName;

    private Browser(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static Browser getByName(String name){
        for(Browser browser : values()) {
            if(browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }


}
